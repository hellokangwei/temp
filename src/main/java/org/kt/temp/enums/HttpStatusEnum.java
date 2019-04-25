package org.kt.temp.enums;

/**
 * 请求状态码枚举类
 */
public enum HttpStatusEnum {

    SUCCESS(200,"请求成功"),
    REQUEST_ERROR(-1,"请求失败"),
    UNAUTHORIZED(401,"用户未验证"),
    INTERNAT_SERVER_ERROR(500,"服务错误"),
    NOT_FOUND(404,"资源不存在");

    private int code;
    private String msg;

    HttpStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
