package com.example.impermanenceservice.repository;
import com.example.impermanenceservice.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("SELECT * FROM article WHERE id = #{id}")
    Article getArticleById(Integer id);

    @Select("SELECT * FROM article LIMIT #{offset},#{pageSize}")
    List<Article> getAllArticles();

    @Insert("INSERT INTO article(title, content, tags) VALUES(#{title}, #{content}, #{tags})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addArticle(Article article);

    @Update("UPDATE article SET title = #{title}, content = #{content}, tags = #{tags} WHERE id = #{id}")
    void updateUser(Article article);

    @Delete("DELETE FROM article WHERE id = #{id}")
    void deleteArticleById(Integer id);
}

