package com.example.impermanenceservice.controller;

import com.example.impermanenceservice.common.ApiResponse;
import com.example.impermanenceservice.entity.User;
import com.example.impermanenceservice.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

//    @PostMapping("/signUp")
//    public <T> ApiResponse signUp(@RequestBody User user) {
////      查询邮箱是否已经注册
//    }

    @PostMapping("/login")
    public <T> ApiResponse<T> login(@RequestBody User User) {
        // 验证用户名和密码
        User user = userMapper.login(User.getUsername(), User.getPassword());
        if (user != null) {
            // 生成JWT token
            String token = generateToken(User.getUsername());

            // 将token放入响应头中
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Authorization", "Bearer " + token);
            return new ApiResponse<>(200, "OK");
        } else {
            return new ApiResponse<>(201, "账号密码错误");
        }
    }

    private String generateToken(String username) {
        // 生成JWT token，例如使用Spring Security的JwtTokenProvider
        return "jwt_token";
    }
}
