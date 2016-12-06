package com.sam;

import com.sam.domain.UserOrder;
import com.sam.domain.OrderDetail;
import com.sam.repository.OrderDetailRep;
import com.sam.repository.UserOrderRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by samchu on 2016/12/6.
 */
@Component
public class ApplicationLoader implements CommandLineRunner {
    @Autowired
    private UserOrderRep orderRep;
    @Autowired
    private OrderDetailRep orderDetailRep;

    @Override
    public void run(String... args) throws Exception {




//        UserOrder userOrder = new UserOrder();
//        userOrder.setMobileNumber("11234567890");
//        userOrder.setOrderAmount(1500);
//        userOrder.setOrderDetails(new ArrayList());
//        userOrder = orderRep.save(userOrder);
//        //
//        OrderDetail orderDetail = new OrderDetail();
//        orderDetail.setOrderID(userOrder.getOrderid());
//        orderDetail.setItemID(1L);
//        orderDetail.setItemName("KUWO K1音樂運動無線藍芽耳機");
//        orderDetail.setItemPrice(980);
//        orderDetailRep.save(orderDetail);
//        orderDetail = new OrderDetail();
//        orderDetail.setOrderID(userOrder.getOrderid());
//        orderDetail.setItemID(2L);
//        orderDetail.setItemName("棉麻休閒格子襯衫外套長袖棉麻上衣");
//        orderDetail.setItemPrice(520);
//        orderDetailRep.save(orderDetail);
    }
}
