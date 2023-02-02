package com.zylear.order.web.dao;

import com.zylear.order.web.model.OrderInfoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface OrderInfoDao extends PagingAndSortingRepository<OrderInfoEntity, Long> {

    List<OrderInfoEntity> findTenByOrderStatusOrderById(int status);

    List<OrderInfoEntity> findTenByOrderStatusAndPhoneNumberLikeOrderById(Integer orderStatus, String keyword);
}
