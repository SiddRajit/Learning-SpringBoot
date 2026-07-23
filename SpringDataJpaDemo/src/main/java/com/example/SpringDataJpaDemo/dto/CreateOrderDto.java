package com.example.SpringDataJpaDemo.dto;

import com.example.SpringDataJpaDemo.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateOrderDto {
    private String productName;
    private int quantity;

}
