package com.spring.jpa.springjpa.enums;

/**
 * @Auther: shalei
 * @Date: 2019-01-04 11:22
 * @MonthName:十一月
 * @Description: 树形结构父级参数及其他系统定义的参数
 */
public enum OtherEnum {
    //定义数形结构的根目录
    PARROOT("-1","---"),
    //定义数形结构的根级别
    CLASSROOT("1","1级"),
    //定义是否授权参数
    IS_ACCREDIT_YES("1","已授权"),
    IS_ACCREDIT_NO("2","未授权"),
    LOG_LOGIN("1","登录日志"),
    LOG_OPERATER("2","操作日志"),
    IS_DISABLE_START("1","启用"),
    IS_DISABLE_STOP("2","停用");

    private String status;
    private String desc;
    private OtherEnum(String status,String desc){
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
