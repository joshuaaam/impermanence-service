package com.example.impermanenceservice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer is_admin;

    private Integer status;

    private Date create_time;

    private Date update_time;
}
