package com.cj.core.domain;

import com.cj.core.domain.ApiResult;

import java.io.Serializable;

public class ResultUtil {

    public static ApiResult result(int i, String msg, Object data){
        ApiResult apiResult = ApiResult.SUCCESS();
        if (i==0){
            apiResult = ApiResult.FAIL();
        }
        apiResult.setMsg(msg);
        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult result(int i, String msg){
        ApiResult apiResult = ApiResult.SUCCESS();
        if (i==0){
            apiResult = ApiResult.FAIL();
        }
        apiResult.setMsg(msg);

        return apiResult;
    }
    public static ApiResult result(int i, Object data){
        ApiResult apiResult = ApiResult.SUCCESS();
        if (i==0){
            apiResult = ApiResult.FAIL();
        }

        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult result(int i){
        ApiResult apiResult = ApiResult.SUCCESS();
        if (i==0){
            apiResult = ApiResult.FAIL();
        }

        return apiResult;
    }
    public static ApiResult result(Object data){
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult result(){
        ApiResult apiResult = ApiResult.SUCCESS();

        return apiResult;
    }


}
