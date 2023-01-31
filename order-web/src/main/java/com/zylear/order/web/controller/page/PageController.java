package com.zylear.order.web.controller.page;

import com.zylear.order.web.dao.OrderInfoDao;
import com.zylear.order.web.model.OrderInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/page/order")
public class PageController {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @GetMapping("/list")
    public ModelAndView hello() {
        Optional<OrderInfoEntity> byId = orderInfoDao.findById(1L);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderInfo", byId.get());
        modelAndView.setViewName("ok");
        return modelAndView;
    }



}
