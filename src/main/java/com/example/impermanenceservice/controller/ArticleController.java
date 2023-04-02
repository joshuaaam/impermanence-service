package com.example.impermanenceservice.controller;

import com.example.impermanenceservice.common.ApiResponse;
import com.example.impermanenceservice.entity.Article;
import com.example.impermanenceservice.service.ArticleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//    @GetMapping("/list")
//    public List<Article> getAllArticles(HttpServletRequest request) {
////        String currentParam = request.getParameter("current");
////        String pageSizeParam = request.getParameter("pageSize");
//        List<Article> list = articleService.getAllArticles();
//        return articleService.getAllArticles();
//    }
    @GetMapping("/list")
    public ApiResponse<List<Article>> getAllArticles(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize
            ){
        int offset = (page - 1) * pageSize;
        List<Article> list = articleService.getAllArticles(offset, pageSize);
        return  new ApiResponse<>(200, "OK", list);
    }
}
