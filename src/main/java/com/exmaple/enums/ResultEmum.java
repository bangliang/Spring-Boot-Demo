package com.exmaple.enums;

// 通过枚举的方式将code和message维护在同一个地方，统一管理，修改方便
public enum ResultEmum {
    UNKONW_ERORR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY(100, "小学ing"),
    MIDDLE(101, "初中ing"),
    HIGH(102, "高中ing"),
    ;

    private Integer code;
    private String msg;

    ResultEmum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
