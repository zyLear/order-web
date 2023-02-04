package com.zylear.order.web.controller.api;

import cn.hutool.core.date.DateUtil;
import com.zylear.order.web.bean.base.Result;
import com.zylear.order.web.bean.base.ResultMsg;
import com.zylear.order.web.controller.api.response.AppOrderVo;
import com.zylear.order.web.controller.page.request.CompleteOrderRequest;
import com.zylear.order.web.controller.page.request.CreateOrderRequest;
import com.zylear.order.web.dao.OrderInfoDao;
import com.zylear.order.web.enums.OrderStatus;
import com.zylear.order.web.exception.CommonException;
import com.zylear.order.web.model.OrderInfoEntity;
import com.zylear.order.web.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @GetMapping("/list")
    @ResponseBody
    public Result list(@Param("orderStatus") Integer orderStatus, @Param("keyword") String keyword) {
        List<OrderInfoEntity> all;


        if (StringUtils.isBlank(keyword)) {
            all = orderInfoDao.findTenByOrderStatusOrderByIdDesc(orderStatus);
        } else {
            all = orderInfoDao.findTenByOrderStatusAndPhoneNumberLikeOrderByIdDesc(orderStatus, "%" + keyword + "%");
        }

        ArrayList<AppOrderVo> list = new ArrayList<>();
        for (OrderInfoEntity orderInfoEntity : all) {
            AppOrderVo appOrderVo = new AppOrderVo();
            appOrderVo.setId(orderInfoEntity.getId());
            appOrderVo.setPhoneNumber(orderInfoEntity.getPhoneNumber());
            appOrderVo.setRemark(orderInfoEntity.getRemark());
            appOrderVo.setPrice(orderInfoEntity.getPrice());
            appOrderVo.setOrderStatus(orderInfoEntity.getOrderStatus());
            appOrderVo.setCreateTime(DateUtil.formatDateTime(orderInfoEntity.getCreateTime()));
            if (orderInfoEntity.getFinishTime() != null) {
                appOrderVo.setFinishTime(DateUtil.formatDateTime(orderInfoEntity.getFinishTime()));
            }
            list.add(appOrderVo);
        }

        return ResultUtil.success(list);
    }

    @PostMapping("/create-order")
    @ResponseBody
    public Result create(@RequestBody CreateOrderRequest createOrderRequest) {

        if (StringUtils.isBlank(createOrderRequest.getPhoneNumber())) {
            throw new CommonException(ResultMsg.PARAMS_ERROR.getCode(), "手机号不能为空");
        }
        if (StringUtils.isBlank(createOrderRequest.getRemark())) {
            throw new CommonException(ResultMsg.PARAMS_ERROR.getCode(), "备注不能为空");
        }
        if (createOrderRequest.getPrice() == null) {
            throw new CommonException(ResultMsg.PARAMS_ERROR.getCode(), "金额不能为空");
        }

        OrderInfoEntity orderInfoEntity = new OrderInfoEntity();
        orderInfoEntity.setOrderStatus(OrderStatus.init.getValue());
        orderInfoEntity.setRemark(createOrderRequest.getRemark());
        orderInfoEntity.setPrice(createOrderRequest.getPrice());
        orderInfoEntity.setPhoneNumber(createOrderRequest.getPhoneNumber());
        orderInfoEntity.setCreateTime(new Date());
        orderInfoDao.save(orderInfoEntity);
        return ResultUtil.success();
    }

    @PostMapping("/complete-order")
    @ResponseBody
    public Result create(@RequestBody CompleteOrderRequest createOrderRequest) {

        if (createOrderRequest.getId() == null) {
            throw new CommonException(ResultMsg.PARAMS_ERROR.getCode(), "ID不能为空");
        }

        Optional<OrderInfoEntity> optional = orderInfoDao.findById(createOrderRequest.getId());

        if (!optional.isPresent()) {
            throw new CommonException(ResultMsg.PARAMS_ERROR.getCode(), "找不到记录" + createOrderRequest.getId());
        }
        OrderInfoEntity orderInfoEntity = optional.get();
        orderInfoEntity.setFinishTime(new Date());
        orderInfoEntity.setOrderStatus(OrderStatus.finish.getValue());
        orderInfoDao.save(orderInfoEntity);
        return ResultUtil.success();
    }


}
