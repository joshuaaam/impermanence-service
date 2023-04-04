package com.example.impermanenceservice.repository;

import com.example.impermanenceservice.entity.Article;
import com.example.impermanenceservice.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(username, password, email) VALUES(#{username}, #{password}, #{email})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    int signUpUser(User user);

    @Select("SELECT * from user WHERE  username = #{username} AND password = #{password}")
    User login(String username, String password);
}
