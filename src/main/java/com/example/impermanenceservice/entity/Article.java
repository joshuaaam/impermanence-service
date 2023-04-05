package com.example.impermanenceservice.entity;
import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer id;

    private String title;

    private String content;

    private String tags;

    private Date create_time;

    private Date update_time;

    private Integer status;

    private String ids;
}
