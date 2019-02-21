package com.spring.jpa.springjpa.enums;

/**
 * @Auther: shalei
 * @Date: 2018-12-28 17:35
 * @MonthName:十一月
 * @Description:
 */
public enum ResultEnum {
    SUCCESS(200,"成功"),
    LOGIN_SUCCESS(200,"登录成功！"),
    INSERT_SUCCESS(ResultEnum.SUCCESS.getCode(),"保存信息成功"),
    DELETE_SUCCESS(ResultEnum.SUCCESS.getCode(),"删除信息成功"),
    SEARCH_SUCCESS(ResultEnum.SUCCESS.getCode(),"查询信息成功"),
    UPDATE_SUCCESS(ResultEnum.SUCCESS.getCode(),"修改信息成功"),
    USER_AUTH(300101,"用户认证错误"),
    SESSION_OVERDUE(300102,"Session过期"),
    URL_INVALID(300103,"URL无效"),
    JSON_ERROR(300104,"传入参数错误"),
    INSERT_ERROR(300201,"保存信息失败"),
    DELETE_ERROR(300202,"删除信息失败"),
    SEARCH_ERROR(300203,"查询信息失败"),
    SEARCH_RELYON(300204,"主键存在引用,不能删除"),
    SEARCH_REPEAT(300205,"信息重复,保存信息失败"),
    SON_EXIST(300206,"存在子数据,不能删除"),
    IS_ACCREDIT(300207,"已被授权,不能删除"),
    SYSTEM_ERROR(300299,"系统错误"),
    LOGIN_ERROR(300104,"用户名或密码错误！"),
    LOGIN_OVERDUE(300102,""),
    OLDPWD_ERROR(300201,"旧密码错误！"),
    PWD_ERROR(300201,"旧密码与新密码相同！"),
    DATABASE_ABNORMAL(300301,"数据库连接异常"),
    RUNTIME_ABNORMAL(300302,"运行时异常"),
    PARAMS_NULL(300303,"参数异常"),
    SYSTEM_BUSY(300999,"系统繁忙，请稍后再试...."),
    RETURN_FRONT_ERROR(500,"出现错误，错误方为接口调用方"),
    RETURN_BACKEND_ERROR(501,"出现错误，错误方为程序内部"),
    RETURN_NOT_VERIFICATION(502,"验证未通过或存在不允许的操作"),
    RETURN_NOT_LOGIN(401,"用户未登录"),
    RETURN_NO_AUTHORITY(402,"用户权限不足");

    private Integer code;
    private String msg;

    private ResultEnum(int code, String desc){
        this.code = code;
        this.msg = desc;
    }

    public int getCode(){
        return this.code;
    }
    public String getMsg(){
        return this.msg;
    }
}
