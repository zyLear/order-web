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
import java.util.Optional;

@Component
public class OrderInfoManager implements TestManagerInterface{

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Autowired
    private WrapperManager wrapperManager;


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


    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void nestedWithRequired() {

        Optional<OrderInfoEntity> byId = orderInfoDao.findById(1L);
        OrderInfoEntity orderInfoEntity = new OrderInfoEntity();
        orderInfoEntity.setOrderStatus(OrderStatus.init.getValue());
        orderInfoEntity.setRemark("remark");
        orderInfoEntity.setPrice(new BigDecimal("1.1"));
        orderInfoEntity.setPhoneNumber("phoneNumber");
        orderInfoDao.save(orderInfoEntity);

        wrapperManager.throwException();


    }

}
