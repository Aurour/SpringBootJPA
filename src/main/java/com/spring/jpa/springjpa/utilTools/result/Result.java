package com.spring.jpa.springjpa.utilTools.result;

import com.spring.jpa.springjpa.enums.ResultEnum;
import lombok.Data;

@Data
public class Result<T> {
    private String message;
    private Exception e;
    private int retCode;
    private T data;
    private T param;


    public Result(String message, int retCode, Exception e) {
        this.message = message;
        this.retCode = retCode;
        this.e = e;
    }

    public Result(String message, int retCode) {
        this.message = message;
        this.retCode = retCode;
    }

    public Result(String message, int retCode, T data) {
        this.message = message;
        this.retCode = retCode;
        this.data = data;
    }

    public Result(String message, T data) {
        this.message = message;
        this.retCode = retCode;
        this.data = data;
    }

    public Result(String message) {
        this.message = message;
        this.retCode = 200;
    }

    public Result(String message, int retCode, T data, T param) {
        this.message = message;
        this.retCode = retCode;
        this.data = data;
        this.param = param;
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<T>(message, data);
    }

    public static <T> Result<T> resultEnum(ResultEnum codeEnum, T data) {
        return new Result<T>(codeEnum.getMsg(), codeEnum.getCode(), data);
    }
    public static <T> Result<T> resultEnum(ResultEnum codeEnum) {
        return new Result<T>(codeEnum.getMsg(), codeEnum.getCode());
    }
    public static <T> Result<T> resultEnum(ResultEnum codeEnum,Exception e) {
        return new Result<T>(codeEnum.getMsg(), codeEnum.getCode(), e);
    }
    public static <T> Result<T> success(String message) {
        return new Result<T>(message);
    }

    public static <T> Result<T> error(int code, String message, Exception e) {
        return new Result<T>(message, code, e);
    }

    public static <T> Result<T> resultEnum(ResultEnum codeEnum, T data, T param) {
        return new Result<T>(codeEnum.getMsg(), codeEnum.getCode(), data, param);
    }

}