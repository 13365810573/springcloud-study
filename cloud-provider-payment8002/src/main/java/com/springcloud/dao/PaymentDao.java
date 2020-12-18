package com.springcloud.dao;

import com.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/11/21 002110:44
 */
@Mapper
public interface  PaymentDao {

    public  int create(Payment payment);

    public  Payment getPaymentById(@Param("id") Long id);
}
