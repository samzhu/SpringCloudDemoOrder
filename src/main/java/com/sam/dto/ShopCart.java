package com.sam.dto;

import com.sam.validator.MobileNumber;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by samchu on 2016/12/6.
 */
@Data
@ApiModel(description = "轉訂單用的購物車")
public class ShopCart {
    @ApiModelProperty(value = "自訂義的電話號碼驗證器", required = true, example = "11234567890")
    @NotNull @NotEmpty
    @MobileNumber
    private String mobileNumber;
    @ApiModelProperty(value = "購物明細", required = true)
    @NotNull
    private List<ShopCartDetail> shopCartDetails;
}
