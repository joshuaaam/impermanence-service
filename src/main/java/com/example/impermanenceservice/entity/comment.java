package com.example.impermanenceservice.entity;
import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private Integer id;

    private String content;

    private Integer aid;

    private Date create_time;

    private Date update_time;
}
