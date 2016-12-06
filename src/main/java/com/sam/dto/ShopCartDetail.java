package com.sam.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by samchu on 2016/12/6.
 */
@Data
@ApiModel(description = "購物明細")
public class ShopCartDetail {
    @ApiModelProperty(value = "商品序號", required = true, example = "2")
    private Long itemID;
    @ApiModelProperty(value = "商品名稱", required = true, example = "棉麻休閒格子襯衫外套長袖棉麻上衣")
    private String itemName;
    @ApiModelProperty(value = "金額", required = true, example = "520")
    private Integer itemPrice;
}
