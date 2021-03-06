package com.cj.core.utils.jwt;

import com.cj.core.domain.Customer;
import com.cj.core.domain.MemoryData;
import com.cj.core.entity.AuthRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * jwt工具类
 */
public class JwtUtil {

    //加密、解析秘钥
    private static final String key = "secretkey";

    //加密、解析算法
    private static final SignatureAlgorithm mode = SignatureAlgorithm.HS256;

    static Map tokenMap = MemoryData.getTokenMap();

    /**
     * 生成token并放入内存
     * @param consumerId 用户ID
     * @param consumerName 用户名
//     * @param consumerType 用户类型
     * @param consumerRoles 用户角色
     * @return
     */
    public static String getToken( long consumerId, String consumerName, List<AuthRole> consumerRoles,Long pid,Long cid,String client){
        long time = System.currentTimeMillis();
        String token = Jwts
                .builder()
                .claim("id",consumerId)
                .claim("name",consumerName)
                .claim("pid",pid)
                .claim("cid",cid)
                .claim("client",client)
                .claim("roles",consumerRoles)
                //签发时间
                .setIssuedAt(new Date(time))
                //截止时间
//                .setExpiration(new Date(time+1000*60*60*2))
                .signWith(mode,key)
                .compact();

        String tokenKey = "i"+consumerId;
        System.out.println("===============tokenKey:"+tokenKey);



        if (!tokenMap.containsKey(tokenKey)) { //不存在，首次登陆，放入Map
            tokenMap.put(tokenKey, token);  //添加adminId-token

        } else if (tokenMap.containsKey(tokenKey) && !StringUtils.equals(token, (String) tokenMap.get(tokenKey))) {
            tokenMap.remove(tokenKey);  //删除adminId-token
            tokenMap.put(tokenKey, token);  //添加adminId-token
        }


        return token;
    }

    /**
     * 解析token
     * @param token
     * @return 解析失败返回null
     *
     */
    public static Claims getClaims(String token)  {
        Claims claims=null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();

        } catch (Exception e) {
            System.out.println("===========token解析失败");
        }

        System.out.println("=============claims===========================");
        System.out.println(claims);
        System.out.println("=============claims===========================");

        return claims;
    }

    public static Customer getCustomer(String token)  {
        Claims claims=null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();

        } catch (Exception e) {
            System.out.println("===========token解析失败");
        }
        Customer customer = new Customer();
        customer.setCustomerId(new Long((Integer) claims.get("id")));
        customer.setCustomerName((String) claims.get("name"));
        customer.setClient((String) claims.get("client"));
        customer.setPid(Long.valueOf((Integer) claims.get("pid")));
        customer.setCid(Long.valueOf((Integer) claims.get("cid")));

        return customer;
    }


    //获取用户ID
    public static String getConsumerId(String token){
        Claims claims = null;
        String consumerId = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();

            consumerId = ""+claims.get("id");


        } catch (Exception e) {
            System.out.println("===========token解析失败");
        }
        return consumerId;
    }

//    public static String getVerifyCodetoken(String code){
//        Date date = new Date();
//        long time = date.getTime();
//        String token = Jwts.builder()
//                .claim("code", code)
//                .setIssuedAt(date)
//                //设置token过期时间戳
//                .setExpiration(new Date(time+1000*60*2))
//                .signWith(mode,key)
//                .compact();
//        return token;
//    }
//    public static  Claims getVerifyCodeClaims(String token){
//        Claims claims=null;
//        try {
//            claims = Jwts.parser()
//                    .setSigningKey(key)
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return claims;
//    }
}
