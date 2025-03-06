package com.escax.crud.mapper;

import com.escax.crud.dto.OrdersDTO;
import com.escax.crud.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrdersMapper {

    @Mapping(source = "user.id", target = "userId")
    OrdersDTO toDTO(Orders orders);
    Orders toEntity(OrdersDTO ordersDTO);

}
