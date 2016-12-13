package com.sam.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by samchu on 2016/12/6.
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class) //加這行 CreatedBy 才會生效
public class OrderDetail implements Persistable<Long> {
    @Id
    @GeneratedValue
    private Long orderDetailID;

    private Long orderID;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "orderID", insertable = false, updatable = false, referencedColumnName = "orderID")
    // 不用實際設定物件的關聯 只要指定欄位 name=自己欄欄位名稱 referencedColumnName=參考對象的欄位名稱
    private UserOrder userOrder;

    private Long itemID;
    private String itemName;
    private Integer itemPrice;
    private Integer itemCount;

    @CreatedBy
    private String createdBy;
    @JsonIgnore
    @CreatedDate
    private Date createdDate;
    @JsonIgnore
    @LastModifiedBy
    private String lastModifiedBy;
    @JsonIgnore
    @LastModifiedDate
    private Date lastModifiedDate;


    @Override
    public Long getId() {
        return orderDetailID;
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return createdDate == null;
    }
}
