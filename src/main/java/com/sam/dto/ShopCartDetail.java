package com.sam.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by samchu on 2016/12/6.
 */
@Data
@ApiModel(description = "購物明細")
public class ShopCartDetail {
    @ApiModelProperty(value = "商品序號", required = true, example = "2")
    @NotNull
    private Long itemID;
    @ApiModelProperty(value = "數量", required = true, example = "1")
    @NotNull
    private Integer itemCount;
}
