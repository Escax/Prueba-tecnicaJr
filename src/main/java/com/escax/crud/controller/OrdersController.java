package com.escax.crud.controller;


import com.escax.crud.dto.OrdersDTO;
import com.escax.crud.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public ResponseEntity<OrdersDTO> createOrder(@RequestBody OrdersDTO ordersDTO) {
        return ResponseEntity.ok(ordersService.createOrder(ordersDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdersDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(ordersService.getOrderById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrdersDTO>> listOrdersByUser(@RequestParam Long userId) {
        return ResponseEntity.ok(ordersService.listOrdersByUser(userId));
    }
}
