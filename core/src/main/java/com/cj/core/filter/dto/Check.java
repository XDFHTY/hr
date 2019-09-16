package com.cj.core.filter.dto;

import com.cj.core.domain.ApiResult;
import com.cj.core.domain.AuthRoleModulars;
import com.cj.core.domain.Customer;
import com.cj.core.domain.MemoryData;
import com.cj.core.utils.jwt.JwtUtil;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.apache.tomcat.util.http.MimeHeaders;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.*;

public class Check {
    /**
     * 不校验登录和权限的URL
     * 比如js，国际化文件，页面等
     */
    private static final String[] URIs = {

            "/i18n/**",
            "/*/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/webjars/**",
            "/configuration/ui",
            "/configuration/security",
            "/favicon.ico",
            "csrf",

            "/swagger-ui.html",
            "/docs.html",


            "/*",
            "/static/**",
            "/file/*",
            //登录
            "/api/v1/user/login",
            //管理员登录
            "/api/v1/account/ifLogin",

    };
    String[] uris = {

    };


    static AntPathMatcher matcher = new AntPathMatcher();

    Gson gson = new Gson();


    public ApiResult check(HttpServletRequest request) {
        ApiResult apiResult = ApiResult.CODE_200();
        //拦截请求uri
        String requestURI = request.getRequestURI();
        if (requestURI.indexOf("?") != -1) {
            requestURI = requestURI.substring(0, requestURI.indexOf("?"));
        }
        //默认需要校验token
        boolean isToken = true;
        String finalRequestURI = requestURI;
        boolean b1 = Arrays.stream(URIs).anyMatch(uri -> matcher.match(uri, finalRequestURI));
        if (b1) isToken = false;
        if (isToken) {
            //用户所拥有的角色集合
            Set<String> userRoles = new HashSet<>();
            //访问此url所需要的角色集合
            Set<String> urlRoles = new HashSet<>();


            String str = checkToken(request, userRoles);


            if (!"OK".equals(str)) {
                System.out.println("=================== token无效 ===================");
                apiResult = ApiResult.CODE_401();
                apiResult.setMsg(str);
                return apiResult;
            }
            //默认需要校验权限
            boolean isPower = true;
            boolean b2 = Arrays.stream(uris).anyMatch(uri -> matcher.match(uri, finalRequestURI));
            if (b2) isPower = false;
            if (isPower) {
                if (!checkPower(request, userRoles, urlRoles, requestURI)) {
                    System.out.println("=================== 无权访问 ===================");
                    apiResult = ApiResult.CODE_403();
                }
            }
        }

        return apiResult;
    }

    Map tokenMap = MemoryData.getTokenMap();

    public String checkToken(HttpServletRequest request, Set<String> userRoles) {
        HttpSession session = request.getSession();
        //前端提交的token
        ApiResult apiResult = null;
        //获取用户提交的token
        String token = request.getHeader("token");

        //用户未上传token
        if (token == null || token.trim().length() == 0) {
            return "用户未提交token,URI: " + request.getRequestURI();
        }
        System.out.println("[" + Thread.currentThread().getName() + "]=======用户提交的token:  " + token);
        //解析用户token
        Claims claims = JwtUtil.getClaims(token);
        //token解析失败
        if (claims == null) {
            return "无效的token,URI: " + request.getRequestURI();
        }


        Customer customer = new Customer();
        customer.setCustomerId(new Long((Integer) claims.get("id")));
        customer.setCustomerName((String) claims.get("name"));
        customer.setClient((String) claims.get("client"));
        customer.setPid(Long.valueOf((Integer) claims.get("pid")));
        customer.setCid(Long.valueOf((Integer) claims.get("cid")));

        List<Map> roles = (List<Map>) claims.get("roles");

        session.setAttribute("id",customer.getCustomerId());
        session.setAttribute("name",customer.getCustomerName());
        session.setAttribute("client",customer.getClient());
        session.setAttribute("roles",roles);
        session.setAttribute("pid",customer.getPid());
        session.setAttribute("cid",customer.getCid());



        String iKey = "i" + customer.getCustomerId();
        System.out.println("===============tokenKey:"+iKey);
        String oldToken = (String) tokenMap.get(iKey);
        System.out.println("[" + Thread.currentThread().getName() + "]=======系统储存的token:  " + oldToken);
        if (!token.equals(oldToken)) {
            return "token已失效,URI: " + request.getRequestURI();
        }

        for (Map map :roles){
            userRoles.add((String) map.get("roleName"));
        }
        return "OK";
    }


    List<AuthRoleModulars> authRoleModulars = null;

    public boolean checkPower(HttpServletRequest request,
                              Set<String> userRoles,
                              Set<String> urlRoles,
                              String requestURI) {


        authRoleModulars = (List<AuthRoleModulars>) MemoryData.getRoleModularMap().get("modulars");
        //拦截请求方法
        String requestMethod = request.getMethod();

        String finalRequestURI = requestURI;

        authRoleModulars.forEach(authRoleModulars1 -> {
            authRoleModulars1.getAuthModulars().getChildren().forEach(authModulars2 -> {
                authModulars2.getChildren().forEach(authModulars3 -> {
                    authModulars3.getChildren().forEach(authModulars0 -> {
                        String authUrl = authModulars0.getPageUrl();
                        String authMethod = authModulars0.getPageMethod();
                        if (restFulUrlMatch(requestMethod, authMethod, finalRequestURI, authUrl)) {
//                            System.out.println("==========访问此url所需的角色:  "+authRoleModulars1.getRoleName() );
                            urlRoles.add(authRoleModulars1.getRoleName());
                        }
                    });
                });
            });
        });

        if (urlRoles.size() == 0) return false;
        boolean b = false;
        b = urlRoles.stream().anyMatch(
                urlRoleName -> userRoles.stream().anyMatch(
                        userRoleName -> userRoleName.equals(urlRoleName))
        );

        return b;
    }

    private static boolean restFulUrlMatch(String reqMethod, String authMethod, String reqUrl, String authUrl) {
        boolean isMethoh = false;
        if ("ALL".equals(authMethod) || reqMethod.equals(authMethod)) isMethoh = true;

        boolean isUrl = matcher.match(authUrl, reqUrl);
        return isMethoh & isUrl;
    }



}
