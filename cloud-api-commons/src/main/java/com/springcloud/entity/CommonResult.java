package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/11/21 002110:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String  messgae;
    private T data;

    public CommonResult(Integer code,String messgae){
        this(code,messgae,null);
    }
}
