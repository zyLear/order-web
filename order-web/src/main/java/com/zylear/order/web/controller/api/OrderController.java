package com.zylear.order.web.controller.api;

import com.zylear.order.web.dao.OrderInfoDao;
import com.zylear.order.web.model.OrderInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @GetMapping("/list")
    @ResponseBody
    public Iterable<OrderInfoEntity> list() {
        List<OrderInfoEntity> all = orderInfoDao.findByOrderStatusOrderById(1);
        return all;
    }



}
