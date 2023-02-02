package com.zylear.order.web.controller.page.request;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
public class CreateOrderRequest {

    private String phoneNumber;

    private String remark;

    private Integer orderStatus;

    private Date finishTime;

    private Date createTime;

}
