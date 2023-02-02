package com.zylear.order.web.controller.page;

import com.zylear.order.web.controller.page.request.CreateOrderRequest;
import com.zylear.order.web.dao.OrderInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page/order")
public class PageController {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order_list");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create_order");
        return modelAndView;
    }




}
