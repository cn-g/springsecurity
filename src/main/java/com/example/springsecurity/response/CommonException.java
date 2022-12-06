package com.example.springsecurity.response;

/**
 * 自定义异常
 * 
 * @author xu
 */
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Object data;
    private int code;
    private String message;
    private String message_en;

    public CommonException(String message, String message_en, int errorcode) {
        this.code = ResponseCode.CommonException.getErrorCode();
        this.message = ResponseCode.CommonException.getMessage();
        this.message_en = ResponseCode.CommonException.getMessage_en();
        this.message = message;
        this.message_en = message_en;
        this.code = errorcode;
    }

    public CommonException(String message, int errorcode) {
        this.code = ResponseCode.CommonException.getErrorCode();
        this.message = ResponseCode.CommonException.getMessage();
        this.message_en = ResponseCode.CommonException.getMessage_en();
        this.message = message;
        this.message_en = this.message_en;
        this.code = errorcode;
    }

    public CommonException(String message, String message_en, int errorcode, Object data) {
        this.code = ResponseCode.CommonException.getErrorCode();
        this.message = ResponseCode.CommonException.getMessage();
        this.message_en = ResponseCode.CommonException.getMessage_en();
        this.message = message;
        this.message_en = message_en;
        this.code = errorcode;
        this.data = data;
    }

    public CommonException() {
        this.code = ResponseCode.CommonException.getErrorCode();
        this.message = ResponseCode.CommonException.getMessage();
        this.message_en = ResponseCode.CommonException.getMessage_en();
    }

    public CommonException(String message) {
        this.code = ResponseCode.CommonException.getErrorCode();
        this.message = ResponseCode.CommonException.getMessage();
        this.message_en = ResponseCode.CommonException.getMessage_en();
        this.message = message;
        this.message_en = message;
    }

    public CommonException(int code) {
        this.code = ResponseCode.CommonException.getErrorCode();
        this.message = ResponseCode.CommonException.getMessage();
        this.message_en = ResponseCode.CommonException.getMessage_en();
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage_en(String message_en) {
        this.message_en = message_en;
    }

    public String getMessage_en() {
        return this.message_en;
    }

    @Override
    public String toString() {
        return String.format("\"code\":%s,{\"message\":\"%s\",{\"message_en\":\"%s\"}", this.code, this.message,
            this.message_en);
    }

}
