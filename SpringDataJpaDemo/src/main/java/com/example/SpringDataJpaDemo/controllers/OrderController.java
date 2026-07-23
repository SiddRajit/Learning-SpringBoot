package com.example.SpringDataJpaDemo.controllers;

import com.example.SpringDataJpaDemo.dto.CreateOrderDto;
import com.example.SpringDataJpaDemo.dto.OrderDto;
import com.example.SpringDataJpaDemo.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users/{userId}/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@PathVariable Long userId, @RequestBody CreateOrderDto order){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(userId, order));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrderByUserId(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrdersByUserId(userId));
    }

}
