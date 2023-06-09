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
    public List<Article> getAllArticles(int offset, int pageSize) {
        return articleMapper.getAllArticles(offset, pageSize);
    }

    @Override
    public List<Article> getAllArticlesByApp(int offset, int pageSize) {
        return articleMapper.getAllArticlesByApp(offset, pageSize);
    }

    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    public int deleteArticleById(String id) {
        return articleMapper.deleteArticleById(id);
    }

    public Article getArticleDetail(int id) {
        return articleMapper.getArticleById(id);
    }

    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public List<Article> getNewArticleList(Integer offset, Integer pageSize) {
        return articleMapper.getNewArticleList(offset, pageSize);
    }
}
