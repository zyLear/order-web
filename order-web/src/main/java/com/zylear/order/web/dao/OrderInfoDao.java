package com.zylear.order.web.dao;

import com.zylear.order.web.model.OrderInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoDao extends PagingAndSortingRepository<OrderInfoEntity, Long> {

    Page<OrderInfoEntity> findByOrderStatusOrderByLastUpdateTimeDesc(int status, Pageable pageable);

    Page<OrderInfoEntity> findTenByOrderStatusAndPhoneNumberLikeOrderByLastUpdateTimeDesc(Integer orderStatus, String keyword, Pageable pageable);
}
