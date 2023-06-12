package com.example.impermanenceservice.service;
import com.example.impermanenceservice.entity.Article;

import java.util.List;


public interface ArticleService {
    List<Article> getAllArticles(int offset, int pageSize);

    List<Article> getAllArticlesByApp(int offset, int pageSize);

    int addArticle(Article article);

    int deleteArticleById(String id);

    Article getArticleDetail(int id);

    int updateArticle(Article article);

    List<Article> getNewArticleList(Integer offset, Integer pageSize);
}
