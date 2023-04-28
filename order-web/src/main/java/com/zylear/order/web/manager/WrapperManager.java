package com.zylear.order.web.manager;

import com.zylear.order.web.bean.base.ResultMsg;
import com.zylear.order.web.dao.OrderInfoDao;
import com.zylear.order.web.enums.OrderStatus;
import com.zylear.order.web.exception.CommonException;
import com.zylear.order.web.model.OrderInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class WrapperManager {

    @Autowired
    private OrderInfoManager orderInfoManager;

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Autowired
    private TestManagerInterface testManagerInterface;

    @Transactional
    public void handle() {

        try {
            orderInfoManager.add();
        } catch (Exception e) {
            e.printStackTrace();
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }finally {
            Optional<OrderInfoEntity> optionalOrderInfo = orderInfoDao.findById(1L);
            if (optionalOrderInfo.isPresent()) {
                OrderInfoEntity orderInfoEntity = optionalOrderInfo.get();
                orderInfoEntity.setPrice(orderInfoEntity.getPrice().add(BigDecimal.ONE));
                orderInfoDao.save(orderInfoEntity);
            }
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public void nestedWithRequired() {
        Optional<OrderInfoEntity> optionalOrderInfo = orderInfoDao.findById(1L);

        try {
            testManagerInterface.nestedWithRequired();
        } catch (Exception e) {
            e.printStackTrace();
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }finally {
            optionalOrderInfo = orderInfoDao.findById(1L);
        }
    }

    @Transactional
    public void throwException() {

        OrderInfoEntity orderInfoEntity = new OrderInfoEntity();
        orderInfoEntity.setOrderStatus(OrderStatus.init.getValue());
        orderInfoEntity.setRemark("remark");
        orderInfoEntity.setPrice(new BigDecimal("1.1"));
        orderInfoEntity.setPhoneNumber("phoneNumber");
        orderInfoDao.save(orderInfoEntity);
        throw new CommonException(ResultMsg.INTERNAL_SERVER_ERROR.getCode(), "error");

    }
}
