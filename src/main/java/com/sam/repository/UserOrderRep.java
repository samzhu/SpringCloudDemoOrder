package com.sam.repository;

import com.sam.domain.UserOrder;
import com.sam.domain.UserOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by samchu on 2016/12/6.
 * http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
@RepositoryRestResource(path = "userorder")
public interface UserOrderRep extends PagingAndSortingRepository<UserOrder, Long> {

    Page<UserOrder> findByMobileNumberIs(@Param("mobileNumber") String mobileNumber, Pageable pageable);

    Page<UserOrder> findByOrderAmountBetween(@Param("minOrderAmount") Integer minOrderAmount, @Param("maxOrderAmount") Integer maxOrderAmount, Pageable pageable);

    // Prevents GET /userorder/:id
    //@Override
    //@RestResource(exported = false)
    //UserOrder findOne(String id);

    // Prevents GET /userorder
    //@Override
    //@RestResource(exported = false)
    //Page<UserOrder> findAll(Pageable pageable);

    // 關閉透過 Rest API 建立 UserOrder 的方式
    // Prevents POST /userorder and PATCH /userorder/:id
    @Override
    @RestResource(exported = false)
    UserOrder save(UserOrder s);

    // Prevents DELETE /userorder/:id
    @Override
    @RestResource(exported = false)
    void delete(UserOrder t);



}
