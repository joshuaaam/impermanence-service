package com.example.impermanenceservice.controller;

import com.example.impermanenceservice.config.ApiResponse;
import com.example.impermanenceservice.entity.Article;
import com.example.impermanenceservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/list")
    public ApiResponse<List<Article>> getAllArticles(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        int offset = (page - 1) * pageSize;
        List<Article> list = articleService.getAllArticles(offset, pageSize);

//        ZSetOperations<String, String> zsetOps = redisTemplate.opsForZSet();
//        System.out.println(zsetOps.reverseRange("proxies:universal", 0, -1));
        return new ApiResponse<>(200, "OK", list);
    }


    @PostMapping("/detail")
    public ApiResponse<Article> detail(
            @RequestBody Article data
    ) {
        int id = data.getId();
        Article article = articleService.getArticleDetail(id);
        return new ApiResponse<>(200, "OK", article);
    }


    @PostMapping("/add")
    public <T> ApiResponse<T> addArticle(
            @RequestBody Article article
    ) {
        int rows = articleService.addArticle(article);
        if (rows > 0) {
            return new ApiResponse<>(200, "OK");
        } else {
            return new ApiResponse<>(201, "err");
        }
    }

    @PostMapping("/delete")
    public <T> ApiResponse<T> deleteArticle(@RequestBody Article article) {
        int rows = articleService.deleteArticleById(article.getIds());
        if (rows > 0) {
            return new ApiResponse<>(200, "OK");
        } else {
            return new ApiResponse<>(201, "err");
        }
    }

    @PostMapping("/update")
    public ApiResponse<Article> updateArticle(@RequestBody Article article) {
        int row = articleService.updateArticle(article);
        if (row <= 0) {
            return new ApiResponse<>(201, "更新失败");
        }
        int id = article.getId();
        Article data = articleService.getArticleDetail(id);
        return new ApiResponse<>(200, "OK", data);
    }
}
