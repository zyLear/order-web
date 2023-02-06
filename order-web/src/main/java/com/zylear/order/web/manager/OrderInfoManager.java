package com.zylear.order.web.manager;

import com.zylear.order.web.dao.OrderInfoDao;
import com.zylear.order.web.enums.OrderStatus;
import com.zylear.order.web.model.OrderInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class OrderInfoManager {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add() {

        OrderInfoEntity orderInfoEntity = new OrderInfoEntity();
        orderInfoEntity.setOrderStatus(OrderStatus.init.getValue());
        orderInfoEntity.setRemark("remark");
        orderInfoEntity.setPrice(new BigDecimal("1.1"));
        orderInfoEntity.setPhoneNumber("phoneNumber");
        orderInfoDao.save(orderInfoEntity);
        throw new RuntimeException("add exception");

    }

}
