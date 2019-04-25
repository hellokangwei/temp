package org.kt.temp.util;

import lombok.Data;
import org.kt.temp.enums.HttpStatusEnum;

import java.io.Serializable;

@Data
public class ResultData implements Serializable {

    private Integer code;
    private String msg;
    private Object data;

    public ResultData(){}

    public ResultData(Integer code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 请求成功，返回包含请求成功状态码和成功提示消息
     */
    public static ResultData success() {
        return new ResultData(HttpStatusEnum.SUCCESS.getCode(),HttpStatusEnum.SUCCESS.getMsg(),null);
    }


    public static ResultData success(String msg) {
        return new ResultData(HttpStatusEnum.SUCCESS.getCode(),msg,null);
    }

    /**
     * 请求成功，并传入相应的data数据
     * @param data data数据
     * @return 返回包含请求成功状态码、成功提示消息和返回的数据
     */
    public static ResultData success(Object data) {
        return new ResultData(HttpStatusEnum.SUCCESS.getCode(),HttpStatusEnum.SUCCESS.getMsg(),data);
    }

    /**
     * 请求成功，传入成功消息和返回的数据
     * @param msg 成功提示消息
     * @param data 数据
     * @return 返回包含请求成功状态码、成功提示消息和返回的数据
     */
    public static ResultData success(String msg,Object data) {
        return new ResultData(HttpStatusEnum.SUCCESS.getCode(),msg,data);
    }

    /**
     * 请求失败，传入失败状态码和失败提示消息
     * @param code 失败状态码
     * @param msg 失效提示消息
     */
    public static ResultData error(Integer code,String msg) {
        return new ResultData(code,msg,null);
    }

    public static ResultData error() {
        return new ResultData(HttpStatusEnum.REQUEST_ERROR.getCode(),HttpStatusEnum.REQUEST_ERROR.getMsg(),null);
    }

}
