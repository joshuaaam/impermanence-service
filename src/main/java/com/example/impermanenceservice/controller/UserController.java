package com.example.impermanenceservice.controller;

import com.example.impermanenceservice.config.ApiResponse;
import com.example.impermanenceservice.entity.User;
import com.example.impermanenceservice.repository.UserMapper;
import com.example.impermanenceservice.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;
//    @PostMapping("/signUp")
//    public <T> ApiResponse signUp(@RequestBody User user) {
////      查询邮箱是否已经注册
//    }

    @PostMapping("/login")
    public <T> ApiResponse<T> login(@RequestBody User User) {
        // 验证用户名和密码
        User user = userMapper.login(User.getUsername(), User.getPassword());
        if (user != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", User.getUsername());
            String token = jwtUtil.generateToken(claims);

//            将token放入响应头中
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Authorization", "Bearer " + token);

            return new ApiResponse<>(200, "登录成功", token);
        } else {
            return new ApiResponse<>(201, "账号密码错误");
        }
    }

    private String generateToken(String username) {
        // 生成JWT token，例如使用Spring Security的JwtTokenProvider
        return "jwt_token";
    }
}
