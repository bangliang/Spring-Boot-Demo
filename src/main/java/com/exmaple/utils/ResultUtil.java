package com.exmaple.utils;

import com.exmaple.domain.Result;

/**
 * 通过工具类来优化代码，减少重复代码
 */
public class ResultUtil {

    // 静态方法
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功！");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
