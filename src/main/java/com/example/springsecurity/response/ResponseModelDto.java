package com.example.springsecurity.response;

import java.io.Serializable;

/**
 * 接口返回数据结构
 * 
 * @author xu
 * @param <T>
 */
public class ResponseModelDto<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int errorCode;

    private String message;

    private String message_en;

    private ResponseCode responseCode;

    private T data;

    private Boolean success;

    public ResponseModelDto responseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
        this.errorCode = responseCode.getErrorCode();
        this.message = responseCode.getMessage();
        this.message_en = responseCode.getMessage_en();
        return this;
    }

    /**
     * 成功提示
     * 
     * @return
     */
    public ResponseModelDto<T> ok() {
        this.responseCode(ResponseCode.OK);
        return this;
    }

    public ResponseModelDto<T> ok(T data) {
        this.data = data;
        return this.ok();

    }

    public ResponseModelDto message(String message) {
        this.message = message;
        return this;
    }

    public ResponseModelDto errorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public ResponseModelDto message_en(String message_en) {
        this.message_en = message_en;
        return this;
    }

    public ResponseModelDto data(T data) {
        this.data = data;
        return this;
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

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public T getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
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

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
