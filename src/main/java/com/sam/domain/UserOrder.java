package com.sam.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sam.validator.MobileNumber;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by samchu on 2016/12/6.
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class) //加這行 CreatedBy 才會生效
public class UserOrder implements Persistable<Long> {
    @Id
    @GeneratedValue
    private Long orderid;

    @MobileNumber
    private String mobileNumber;

    @NotNull
    private Integer orderAmount;

    @OneToMany()
    @JoinColumn(name = "orderID", insertable = false, updatable = false)
    private List<OrderDetail> orderDetails;

    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Date createdDate;

    @LastModifiedBy
    private String lastModifiedBy;
    @LastModifiedDate
    private Date lastModifiedDate;

    @Override
    public Long getId() {
        return orderid;
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return createdDate == null;
    }
}
