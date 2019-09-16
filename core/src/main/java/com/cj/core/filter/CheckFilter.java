package com.cj.core.filter;

import com.cj.core.domain.ApiResult;
import com.cj.core.filter.dto.Check;
import com.cj.core.utils.http.HttpUtil;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class CheckFilter implements Filter {

    Gson gson = new Gson();
    Check check = new Check();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long t1 = System.currentTimeMillis();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ResponseWrapper wrapperResponse = new ResponseWrapper(response);//转换成代理类

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "36000");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "*");


        if (request.getMethod().equals("OPTIONS")) {
            HttpUtil.doReturn(response, ApiResult.SUCCESS());
        }

        String URL = request.getRequestURL().toString();
        System.out.println("[" + Thread.currentThread().getName() + "]====" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                "===========请求URL: " + URL);
        ApiResult apiResult = check.check(request);
        if (apiResult.getCode() != 200) {
            HttpUtil.doReturn(response, apiResult);
        }
        HeaderMapRequestWrapper headerMapRequestWrapper = new HeaderMapRequestWrapper(request);

        long t2 = System.currentTimeMillis();
        System.out.println("[" + Thread.currentThread().getName() + "]========鉴权耗时: " + (t2 - t1) + "ms");

        filterChain.doFilter(headerMapRequestWrapper, response);


    }
}