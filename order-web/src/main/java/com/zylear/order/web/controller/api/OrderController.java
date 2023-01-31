package com.zylear.order.web.controller.api;

import com.zylear.order.web.dao.OrderInfoDao;
import com.zylear.order.web.model.OrderInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @GetMapping("/list")
    @ResponseBody
    public Iterable<OrderInfoEntity> hello() {
        Iterable<OrderInfoEntity> all = orderInfoDao.findAll();
        return all;
    }



}
