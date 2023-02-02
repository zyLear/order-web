package com.zylear.order.web.enums;

/**
 * Created by xiezongyu on 2018/8/7.
 */
public enum OrderStatus {

    init(1,"未完成"),
    finish(2,"已完成");


    OrderStatus(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    private Integer value;
    private String description;


    public static String getDescription(Integer value) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.getValue().equals(value)) {
                return orderStatus.getDescription();
            }
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
       return description;
    }
}
