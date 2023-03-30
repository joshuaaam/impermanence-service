package com.example.impermanenceservice.entity;
import lombok.Data;

@Data
public class comment {
    private Integer id;

    private String content;

    private Integer aid;

    private long create_time;

    private long update_time;
}
