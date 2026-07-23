package com.example.SpringDataJpaDemo.services;

import com.example.SpringDataJpaDemo.dto.CreateOrderDto;
import com.example.SpringDataJpaDemo.dto.OrderDto;
import com.example.SpringDataJpaDemo.dto.UserDto;
import com.example.SpringDataJpaDemo.entities.Order;
import com.example.SpringDataJpaDemo.entities.User;
import com.example.SpringDataJpaDemo.repositories.OrderRepository;
import com.example.SpringDataJpaDemo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderDto createOrder(Long userId, CreateOrderDto order) {
        User user = userRepository.findById(userId).orElseThrow();
        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setProductName(order.getProductName());
        newOrder.setQuantity(order.getQuantity());

        Order savedOrder = orderRepository.save(newOrder);
        return new OrderDto(savedOrder.getId(), savedOrder.getProductName(), savedOrder.getQuantity(),
                new UserDto(savedOrder.getUser().getId(), savedOrder.getUser().getName(), savedOrder.getUser().getEmail()));
    }

    public List<OrderDto> getOrdersByUserId(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        List<OrderDto> orderDtos = new ArrayList<>();
        orders.forEach((order -> {
            OrderDto orderDto = new OrderDto(order.getId(), order.getProductName(), order.getQuantity(),
                    new UserDto(order.getUser().getId(), order.getUser().getName(), order.getUser().getEmail()));
            orderDtos.add(orderDto);
        }));

        return orderDtos;
    }
}
