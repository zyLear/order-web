package com.zylear.order.web.bean.base;

/**
 * @author xiezongyu
 */

public enum ResultMsg {

    SUCCESS(0, "ok"),
    INTERNAL_SERVER_ERROR(1000, "出错了!!!"),
    PARAMS_ERROR(1001, "参数错误"),
    UNAUTHORIZED(1002, "未授权");

    ;

    private final int code;
    private final String message;


    ResultMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
