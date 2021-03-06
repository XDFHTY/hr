package com.cj.core.utils.http;

import com.cj.core.domain.ApiResult;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public  class HttpUtil {


    static Gson gson =new Gson();
    /**
     * @param response
     * @param apiResult
     * @throws IOException
     */
    public static void doReturn(HttpServletResponse response, ApiResult apiResult)  {

        try {


            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null ;
            out = response.getWriter();
            out.append(gson.toJson(apiResult));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void doReturnStr(HttpServletResponse response, String str)  {
        ApiResult apiResult = gson.fromJson(str,ApiResult.class);
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            if (apiResult.getCode()==401||apiResult.getCode()==403){
                response.setStatus(apiResult.getCode());
            }
            PrintWriter out = response.getWriter();
            out.append(str);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
