package com.exmaple.exception;

import com.exmaple.enums.ResultEmum;

// spring框架只对RuntimeException抛出的异常进行回滚
// 自定义异常，默认异常只接收message这个字段，没有code
public class DemoException extends RuntimeException{

    public Integer getCode() {
        return code;
    }

    public DemoException(ResultEmum resultEmum) {
        super(resultEmum.getMsg());
        this.code = resultEmum.getCode();
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    private Integer code;

}
