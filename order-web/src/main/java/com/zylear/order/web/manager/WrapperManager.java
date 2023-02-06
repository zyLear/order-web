package com.zylear.order.web.manager;

import com.zylear.order.web.dao.OrderInfoDao;
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

}
