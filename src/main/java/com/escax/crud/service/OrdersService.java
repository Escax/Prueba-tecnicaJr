package com.escax.crud.service;

import com.escax.crud.dto.OrdersDTO;
import com.escax.crud.entity.Orders;
import com.escax.crud.mapper.OrdersMapper;
import com.escax.crud.repository.OrdersRepository;
import com.escax.crud.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final OrdersMapper ordersMapper;

    @Autowired
    public OrdersService (OrdersRepository ordersRepository, UserRepository userRepository, OrdersMapper ordersMapper) {
        this.ordersRepository = ordersRepository;
        this.userRepository = userRepository;
        this.ordersMapper = ordersMapper;
    }

    public OrdersDTO createOrder(OrdersDTO ordersDTO) {
        Orders order = ordersMapper.toEntity(ordersDTO);
        order.setUser(userRepository.findById(ordersDTO.userId())
                .orElseThrow(() -> new RuntimeException("User not found")));
        order = ordersRepository.save(order);
        return ordersMapper.toDTO(order);
    }

    public OrdersDTO getOrderById(Long id) {
        Orders order = ordersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        return ordersMapper.toDTO(order);
    }

    public List<OrdersDTO> listOrdersByUser(Long userId) {
        List<Orders> orders = ordersRepository.findByUserId(userId);
        return orders.stream().map(ordersMapper::toDTO).toList();
    }
}
