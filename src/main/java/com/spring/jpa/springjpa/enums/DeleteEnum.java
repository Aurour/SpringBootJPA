package com.spring.jpa.springjpa.enums;

/**
 * @Auther: yanb
 * @Date: 2018-11-20 11:22
 * @MonthName:十一月
 * @Description:
 */
public enum DeleteEnum {
    NORMAL("1","有效状态"),DELETE("0","删除状态"),
    LOG_TYPE_LOGIN("1","登陆日志"),LOG_TYPE_OPER("2","操作日志");


    private String status;
    private String desc;
    private DeleteEnum(String status,String desc){
        this.status = status;
        this.desc = desc;
    }

    public String getStatus(){
        return this.status;
    }
    public String getDesc(){
        return this.desc;
    }
}
