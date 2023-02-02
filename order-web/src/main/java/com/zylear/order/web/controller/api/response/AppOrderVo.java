package com.zylear.order.web.controller.api.response;

import lombok.Data;

import java.util.Date;


@Data
public class AppOrderVo {

    private Long id;

    private String phoneNumber;

    private String remark;

    private Integer orderStatus;

    private String finishTime;

    private String createTime;

}
