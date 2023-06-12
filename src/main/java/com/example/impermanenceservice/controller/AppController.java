package com.example.impermanenceservice.controller;

import com.example.impermanenceservice.config.ApiResponse;
import com.example.impermanenceservice.entity.Article;
import com.example.impermanenceservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/getArticleList")
    public ApiResponse<List<Article>> getAllArticlesByApp(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        int offset = (page - 1) * pageSize;
        List<Article> list = articleService.getAllArticlesByApp(offset, pageSize);
        return new ApiResponse<>(200, "OK", list);
    }

    @GetMapping("/getArchiveList")
    public ApiResponse<List<Article>> getArchiveList(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize
    ) {
        List<Article> list = articleService.getNewArticleList(page, pageSize);
        Map<Integer, List<Map<String, String>>> dataMap = new LinkedHashMap<>();
        for (Article entity : list) {

            Map<String, String> obj = new HashMap<>();
            obj.put("title", entity.getTitle());
            obj.put("create_time", String.valueOf(entity.getCreate_time()));
            obj.put("tags", entity.getTags());
            obj.put("id", String.valueOf(entity.getId()));

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(entity.getCreate_time());
            int year = calendar.get(Calendar.YEAR);
            dataMap.computeIfAbsent(year, k -> new ArrayList<>()).add(obj);
        }
        return new ApiResponse<>(200, "OK", dataMap);
    }

    @PostMapping("/getArticleDetail")
    public ApiResponse<Article> detail(
            @RequestBody Article data
    ) {
        int id = data.getId();
        Article article = articleService.getArticleDetail(id);
        return new ApiResponse<>(200, "OK", article);
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

    @GetMapping("/getNewList")
    public ApiResponse<List<Article>> getNewList(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize
    ) {
        List<Article> list = articleService.getNewArticleList(page, pageSize);
        return new ApiResponse<>(200, "OK", list);
    }
}
