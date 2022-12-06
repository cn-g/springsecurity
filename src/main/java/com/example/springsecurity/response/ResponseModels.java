package com.example.springsecurity.response;

/**
 * 封装返回结果
 * 
 * @author xu
 */
public class ResponseModels {

    public ResponseModels() {

    }

    /**
     * 创建新对象
     * 
     * @return
     */
    public static ResponseModelDto newInstance() {
        ResponseModelDto responseMpdelDto = new ResponseModelDto();
        return responseMpdelDto;
    }

    /**
     * 返回对象中的内容
     * 
     * @param responseCode
     * @return
     */
    public static ResponseModelDto newInstance(ResponseCode responseCode) {
        return newInstance().responseCode(responseCode);
    }

    /**
     * 实体出参封装
     * 
     * @param date
     * @param <T>
     * @return
     */
    public static <T> ResponseModelDto<T> ok(T date) {
        return newInstance().ok(date);
    }

    /**
     * 无参数返回封装
     * 
     * @return
     */
    public static ResponseModelDto ok() {
        return newInstance().ok();
    }

    /**
     * 业务异常封装
     * 
     * @param <T>
     * @return
     */
    public static <T> ResponseModelDto<T> commonnException() {
        ResponseModelDto<T> responseModel = new ResponseModelDto();
        responseModel.responseCode(ResponseCode.CommonException);
        return responseModel;
    }

    /**
     * 业务异常信息封装
     * 
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseModelDto<T> commonException(String message) {
        ResponseModelDto<T> responseModel = new ResponseModelDto();
        responseModel.responseCode(ResponseCode.CommonException).message(message);
        return responseModel;
    }

    public static <T> ResponseModelDto<T> commonException(CommonException commonException) {
        ResponseModelDto<T> responseModel = new ResponseModelDto();
        responseModel.responseCode(ResponseCode.CommonException).message_en(commonException.getMessage_en())
            .message(commonException.getMessage()).errorCode(commonException.getCode()).data(commonException.getData());
        return responseModel;
    }

    /**
     * 登录异常
     * 
     * @return
     */
    public static ResponseModelDto loginException() {
        ResponseModelDto responseModel = new ResponseModelDto();
        responseModel.responseCode(ResponseCode.LOGINEXCEPTION);
        return responseModel;
    }

    /**
     * 无权限
     * 
     * @return
     */
    public static ResponseModelDto noPowerException() {
        ResponseModelDto responseModel = new ResponseModelDto();
        responseModel.responseCode(ResponseCode.NOPOWER);
        return responseModel;
    }

}
