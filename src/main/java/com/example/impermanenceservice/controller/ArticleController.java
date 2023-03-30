package com.example.impermanenceservice.controller;

import com.example.impermanenceservice.entity.Article;
import com.example.impermanenceservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

}
