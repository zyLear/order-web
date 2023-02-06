package com.zylear.order.web.controller;

import com.zylear.order.web.manager.WrapperManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class TestController {

    @Autowired
    private WrapperManager wrapperManager;

    @GetMapping("/test")
    @ResponseBody
    public String hello() {
        wrapperManager.handle();
        return "test";
    }

}
