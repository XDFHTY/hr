package com.cj.core.security.dto;


import com.cj.core.domain.ApiResult;
import com.cj.core.filter.dto.Check;
import com.google.gson.Gson;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyAuthService {

    Check check = new Check();
    Gson gson = new Gson();
    /**
     *
     * @Description: 判断一个请求是否拥有权限。
     *
     * @auther: csp
     * @date:  2019/1/7 下午9:48
     * @param request
     * @param authentication
     * @return: boolean
     *
     */
    public boolean canAccess(HttpServletRequest request,Authentication authentication) {

//        Object principal = authentication.getPrincipal();
//        if(principal == null){
//            return false;
//        }

//        if(authentication instanceof AnonymousAuthenticationToken){
//            //check if this uri can be access by anonymous
//            return false;
//        }

//        authentication.getAuthorities();
//        String uri = request.getRequestURI();
        //check this uri can be access by this role

        long t1 = System.currentTimeMillis();
        ApiResult apiResult = check.check(request);
        if (apiResult.getCode() !=200) {
            throw new CustomAuthenticationException(gson.toJson(apiResult));
        }
        long t2 = System.currentTimeMillis();
        System.out.println("[" + Thread.currentThread().getName() + "]========鉴权耗时: " + (t2 - t1) + "ms");

        return true;

    }
}