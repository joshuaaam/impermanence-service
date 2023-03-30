package com.example.impermanenceservice.service.impl;

import com.example.impermanenceservice.entity.Article;
import com.example.impermanenceservice.repository.ArticleMapper;
import com.example.impermanenceservice.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleMapper.getAllArticles();
    }

}
