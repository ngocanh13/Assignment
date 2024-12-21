package com.example.spring.mapper;

import com.example.spring.dbo.req.OrderReq;
import com.example.spring.dbo.res.OrderRes;
import com.example.spring.entity.Order;
import org.mapstruct.Mapper;

import java.net.CacheRequest;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderReq orderReq);
    OrderRes toDTO(Order order);

}
