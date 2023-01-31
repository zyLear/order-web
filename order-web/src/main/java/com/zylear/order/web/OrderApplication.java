package com.zylear.order.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {
//        DispatcherServletAutoConfiguration.class,
//        ErrorMvcAutoConfiguration.class,
//        DataSourceAutoConfiguration.class
})
public class OrderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OrderApplication.class, args);
    //        run.getBeanFactory().getBeansOfType(Object.class)
//            new SpringApplication().setWebApplicationType(WebApplicationType.NONE);
        System.out.println(run);
    }

}
