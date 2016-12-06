package com.sam.repository;

import com.sam.domain.UserOrder;
import com.sam.domain.UserOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by samchu on 2016/12/6.
 * http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
@RepositoryRestResource(path = "order", collectionResourceRel = "order")
public interface UserOrderRep extends PagingAndSortingRepository<UserOrder, Long> {

    Page<UserOrder> findByMobileNumberIs(@Param("mobileNumber") String mobileNumber, Pageable pageable);

    Page<UserOrder> findByOrderAmountBetween(@Param("minOrderAmount") Integer minOrderAmount, @Param("maxOrderAmount") Integer maxOrderAmount, Pageable pageable);
}
