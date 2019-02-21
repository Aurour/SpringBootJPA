package com.spring.jpa.springjpa.enums;

public enum QueryEnum {

    EQ("EQ", "等于"),
    NE("NE", "不等于"),
    LIKE("LIKE", "匹配"),
    NOTLIKE("NOTLIKE", "不匹配"),
    GT("GT", "大于"),
    LT("LT", "小于"),
    GTE("GTE", "大于等于"),
    LTE("LTE", "小于等于"),
    IS_MEMBER("IS_MEMBER", "包含"),
    IS_NOT_MEMBER("IS_NOT_MEMBER", "不包含");

    private String code;
    private String msg;

    private QueryEnum(String code, String desc){
        this.code = code;
        this.msg = desc;
    }

    public String getCode(){
        return this.code;
    }
    public String getMsg(){
        return this.msg;
    }

}
