package com.example.impermanenceservice.repository;
import com.example.impermanenceservice.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("SELECT * FROM article WHERE id = #{id}")
    Article getArticleById(int id);

    @Select("SELECT * FROM article LIMIT #{offset},#{pageSize}")
    List<Article> getAllArticles(int offset, int pageSize);

    @Select("SELECT * FROM article WHERE status=1 LIMIT #{offset},#{pageSize}")
    List<Article> getAllArticlesByApp(int offset, int pageSize);

    @Insert("INSERT INTO article(title, content, tags) VALUES(#{title}, #{content}, #{tags})")
    @ResultType(Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addArticle(Article article);

//    @Update("UPDATE article SET title = #{title}, content = #{content}, tags = #{tags} WHERE id = #{id}")
//    boolean updateArticle(Article article);

    @Delete("DELETE FROM article WHERE FIND_IN_SET(id,#{ids})")
    int deleteArticleById(String id);

    int updateArticle(Article article);
}

