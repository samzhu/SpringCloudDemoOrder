package com.sam.service;

import com.sam.domain.OrderDetail;
import com.sam.domain.UserOrder;
import com.sam.dto.Item;
import com.sam.dto.ShopCart;
import com.sam.dto.ShopCartDetail;
import com.sam.reader.ItemReader;
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
    private ItemReader itemReader;
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
            Integer orderAmount = 0;
            List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
            for (ShopCartDetail detail : shopCart.getShopCartDetails()) {
                Item item = itemReader.get(detail.getItemID()).getContent();
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setItemID(item.getItemid());
                orderDetail.setItemName(item.getName());
                orderDetail.setItemPrice(item.getPrice());
                orderDetail.setItemCount(detail.getItemCount());
                orderAmount = orderAmount + (item.getPrice() + detail.getItemCount());
                orderDetails.add(orderDetail);
            }
            userOrder.setOrderAmount(orderAmount);
            userOrder = userOrderRep.save(userOrder);
            Long orderid = userOrder.getOrderid();
            orderDetails.forEach(orderDetail -> {
                orderDetail.setOrderID(orderid);
                orderDetailRep.save(orderDetail);
            });
        } catch (Exception ex) {
            log.error("", ex);
            throw ex;
        }
        return userOrder;
    }
}
