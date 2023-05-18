package com.example.impermanenceservice.controller;

import com.example.impermanenceservice.config.ApiResponse;
import com.example.impermanenceservice.entity.Article;
import com.example.impermanenceservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

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
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        int offset = (page - 1) * pageSize;
        List<Article> list = articleService.getAllArticlesByApp(offset, pageSize);
//        List newlist = new ArrayList();
//        for (int i = 0; i < list.size(); i++) {
//            HashMap<String, String> testMap = new HashMap<>();
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(list.get(i).getCreate_time());
//            int year = calendar.get(Calendar.YEAR);
//            System.out.print(year);
//            testMap.put("1", "第一个数");
//            testMap.put("2", "第二个数");
//            testMap.put("3", "第三个数");
//        }
        return new ApiResponse<>(200, "OK", list);
    }

    @PostMapping("/getArticleDetail")
    public ApiResponse<Article> detail(
            @RequestBody Article data
    ) {
        int id = data.getId();
        Article article = articleService.getArticleDetail(id);
        return new ApiResponse<>(200, "OK", article);
    }
}
