package com.sam.repository;

import com.sam.domain.UserOrder;
import com.sam.domain.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by samchu on 2016/12/6.
 */
@RepositoryRestResource(path = "orderdetail", collectionResourceRel = "orderdetail")
public interface OrderDetailRep extends PagingAndSortingRepository<OrderDetail, Long> {

    Page<OrderDetail> findByItemNameContaining(@Param("itemName") String itemName, Pageable pageable);
}
