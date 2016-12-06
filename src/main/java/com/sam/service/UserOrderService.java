package com.sam.service;

import com.sam.domain.OrderDetail;
import com.sam.domain.UserOrder;
import com.sam.dto.ShopCart;
import com.sam.repository.OrderDetailRep;
import com.sam.repository.UserOrderRep;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samchu on 2016/12/6.
 */
@Slf4j
@Service
public class UserOrderService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserOrderRep userOrderRep;
    @Autowired
    private OrderDetailRep orderDetailRep;

    public UserOrder createOrder(ShopCart shopCart) {
        UserOrder userOrder = null;
        try {
            userOrder = modelMapper.map(shopCart, UserOrder.class);
            userOrder = userOrderRep.save(userOrder);
            Long orderid = userOrder.getOrderid();
            List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
            shopCart.getShopCartDetails().forEach(shopCartDetail -> {
                OrderDetail orderDetail = modelMapper.map(shopCartDetail, OrderDetail.class);
                orderDetail.setOrderID(orderid);
                orderDetailRep.save(orderDetail);
                orderDetails.add(orderDetail);
            });
            userOrder.setOrderDetails(orderDetails);
        } catch (Exception ex) {
            log.error("", ex);
        }
        return userOrder;
    }
}
