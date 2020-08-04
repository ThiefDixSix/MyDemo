package com.cyc.security.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<T> implements Serializable {

    private Boolean success;
    private Integer errorCode;
    private String errorMsg;
    private T data;

    public JsonResult() {
    }

    public JsonResult(boolean success) {
        this.success = success;
        this.errorCode = success ? ResultCode.SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage() : ResultCode.COMMON_FAIL.getMessage();
    }

    public JsonResult(boolean success, ResultCode JsonResultEnum) {
        this.success = success;
        this.errorCode = success ? ResultCode.SUCCESS.getCode() : (JsonResultEnum == null ? ResultCode.COMMON_FAIL.getCode() : JsonResultEnum.getCode());
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage() : (JsonResultEnum == null ? ResultCode.COMMON_FAIL.getMessage() : JsonResultEnum.getMessage());
    }

    public JsonResult(boolean success, T data) {
        this.success = success;
        this.errorCode = success ? ResultCode.SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage() : ResultCode.COMMON_FAIL.getMessage();
        this.data = data;
    }
    public JsonResult(boolean success, ResultCode JsonResultEnum, T data) {
        this.success = success;
        this.errorCode = success ? ResultCode.SUCCESS.getCode() : (JsonResultEnum == null ? ResultCode.COMMON_FAIL.getCode() : JsonResultEnum.getCode());
        this.errorMsg = success ? ResultCode.SUCCESS.getMessage() : (JsonResultEnum == null ? ResultCode.COMMON_FAIL.getMessage() : JsonResultEnum.getMessage());
        this.data = data;
    }
}
