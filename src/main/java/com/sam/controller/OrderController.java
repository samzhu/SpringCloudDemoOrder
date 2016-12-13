package com.sam.controller;

import com.sam.domain.UserOrder;
import com.sam.dto.ShopCart;
import com.sam.service.UserOrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by samchu on 2016/12/6.
 */
@Api(tags = "Order")
@RestController
@RequestMapping(value = "api")
public class OrderController {
    @Autowired
    private UserOrderService userOrderService;

    @ApiOperation(value = "建立訂單", notes = "購物車結帳使用", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "authorization header", required = true, dataType = "string", paramType = "header", defaultValue = "bearer eyJhbGciOiJIUzI1NiJ9.eyJ")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "存檔成功", response = UserOrder.class)})
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserOrder createGift(
            @ApiParam(required = true, value = "購物車資料")
            @Valid @RequestBody ShopCart shopCart) {
        UserOrder userOrder = null;
        userOrder = userOrderService.createOrder(shopCart);
        return userOrder;
    }
}
