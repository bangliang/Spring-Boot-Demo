package com.exmaple.handle;

import com.exmaple.domain.Result;
import com.exmaple.exception.DemoException;
import com.exmaple.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    // 捕获Exception这个类的异常
    public Result handle(Exception e){
        if(e instanceof DemoException){
            // 捕获自定义异常
            DemoException demoException = (DemoException) e;
            return ResultUtil.error(demoException.getCode(), demoException.getMessage());
        }
        else{
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
