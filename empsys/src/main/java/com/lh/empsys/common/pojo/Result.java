package com.lh.empsys.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回对象
 */

@Data
public class Result<T> implements Serializable {

    private T data;      //返回数据
    private String msg;  //返回信息
    private String code; //返回码


    public  Result(){}
    public  Result(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result(String msg, String code,T data) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }


    public static Result  success(String msg){
        return new Result("200",msg);
    }
}
