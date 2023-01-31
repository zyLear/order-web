package com.zylear.order.web.dao;

import com.zylear.order.web.model.OrderInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoDao extends CrudRepository<OrderInfoEntity, Long> {


}
