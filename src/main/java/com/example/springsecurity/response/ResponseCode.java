package com.example.springsecurity.response;

/**
 * 自定义响应枚举
 * 
 * @author xu
 */
public enum ResponseCode {

    OK(200, "OK", "OK"), CommonException(503, "业务异常", "Common Exception"), NOPOWER(403, "权限不足", "No Power"),
    LOGINEXCEPTION(402, "认证失败", "LOGIN ERROR");

    private int errorCode;

    private String message;

    private String message_en;

    private ResponseCode(int errorCode, String message, String message_en) {
        this.errorCode = errorCode;
        this.message = message;
        this.message_en = message_en;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage_en(String message_en) {
        this.message_en = message_en;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage_en() {
        return message_en;
    }

    @Override
    public String toString() {
        return "{" + "errorCode=" + errorCode + ", message='" + message + '\'' + ", message_en='" + message_en + '\''
            + '}';
    }

}
