package com.example.impermanenceservice.controller;

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

    @GetMapping("/")
    public List<Comment> getAllComment() {
        return commentService.getAllComment();
    }
}
