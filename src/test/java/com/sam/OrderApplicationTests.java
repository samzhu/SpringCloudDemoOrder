package com.sam;

import com.sam.dto.ShopCart;
import com.sam.dto.ShopCartDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, value = {
//        "eureka.instance.leaseRenewalIntervalInSeconds=10", // Lease Interval
//        "eureka.client.instanceInfoReplicationIntervalSeconds=1",
//        "eureka.client.initialInstanceInfoReplicationIntervalSeconds=1",
//        "eureka.client.registryFetchIntervalSeconds=1",
//        "eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka"})

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
//        "myexample.ribbon.listOfServers:example.com", "feign.hystrix.enabled=false" })
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    //@Test
    public void testUserorder() {
        ResponseEntity<String> response = this.restTemplate.getForEntity(
                "/userorder", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println(response.getBody());
    }

    //@Test
    public void testErrorMobileNumber() {
        ShopCart shopCart = new ShopCart();
        shopCart.setMobileNumber("1234678");
        ShopCartDetail shopCartDetail = new ShopCartDetail();
        shopCartDetail.setItemID(1L);
        shopCartDetail.setItemCount(2);
        List<ShopCartDetail> shopCartDetails = new ArrayList<>();
        shopCartDetails.add(shopCartDetail);
        shopCart.setShopCartDetails(shopCartDetails);
        ResponseEntity<String> response = this.restTemplate.postForEntity(
                "/api/order", shopCart, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }


    //@Test
    public void testCreateUserOrder() {
        ShopCart shopCart = new ShopCart();
        shopCart.setMobileNumber("11234567890");
        ShopCartDetail shopCartDetail = new ShopCartDetail();
        shopCartDetail.setItemID(1L);
        shopCartDetail.setItemCount(2);
        List<ShopCartDetail> shopCartDetails = new ArrayList<>();
        shopCartDetails.add(shopCartDetail);
        shopCart.setShopCartDetails(shopCartDetails);
        ResponseEntity<String> response = this.restTemplate.postForEntity(
                "/api/order", shopCart, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        System.out.println(response.getBody());
    }


}
