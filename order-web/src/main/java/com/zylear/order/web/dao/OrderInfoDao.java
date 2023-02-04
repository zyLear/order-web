package com.zylear.order.web.dao;

import com.zylear.order.web.model.OrderInfoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoDao extends PagingAndSortingRepository<OrderInfoEntity, Long> {

    List<OrderInfoEntity> findTenByOrderStatusOrderByLastUpdateTimeDesc(int status);

    List<OrderInfoEntity> findTenByOrderStatusAndPhoneNumberLikeOrderByLastUpdateTimeDesc(Integer orderStatus, String keyword);
}
