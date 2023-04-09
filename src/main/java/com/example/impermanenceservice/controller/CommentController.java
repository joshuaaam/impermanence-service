package com.example.impermanenceservice.controller;

import com.example.impermanenceservice.config.ApiResponse;
import com.example.impermanenceservice.entity.Comment;
import com.example.impermanenceservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

//    @GetMapping("/list")
//    public List<Comment> getAllComment() {
//        return commentService.getAllComment();
//    }

    @GetMapping("/list")
    public <T> ApiResponse<List<Comment>> getAllComment(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        int offset = (page - 1) * pageSize;
        List<Comment> list = commentService.getAllComment(offset, pageSize);
        return new ApiResponse<>(200, "OK", list);
    }
}
