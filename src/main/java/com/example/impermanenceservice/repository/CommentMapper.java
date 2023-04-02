package com.example.impermanenceservice.repository;
import com.example.impermanenceservice.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

//    @Select("SELECT * FROM comment WHERE id = #{id}")
//    Comment getCommentById(Integer id);

    @Select("SELECT * FROM comment")
    List<Comment> getAllComment();

//    @Insert("INSERT INTO comment(title, content, tags) VALUES(#{title}, #{content}, #{tags})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    void addComment(Comment comment);
//
//    @Update("UPDATE comment SET title = #{title}, content = #{content}, tags = #{tags} WHERE id = #{id}")
//    void updateUser(Comment comment);
//
//    @Delete("DELETE FROM comment WHERE id = #{id}")
//    void deleteCommentById(Integer id);
}

