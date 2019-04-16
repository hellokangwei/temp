package org.kt.temp.pojo;

import lombok.Data;

@Data
public class BaseResponse {
    private Integer code=0;
    private String msg="访问成功";
    private long count;
    private Object data;
}
