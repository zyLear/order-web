package com.zylear.order.web.bean.base;

import lombok.Data;

import java.util.List;


@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

}
