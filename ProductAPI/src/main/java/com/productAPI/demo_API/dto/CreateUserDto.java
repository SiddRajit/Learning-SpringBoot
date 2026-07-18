package com.productAPI.demo_API.dto;

public class CreateUserDto {
    private String name;
    private String email;

    public CreateUserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
