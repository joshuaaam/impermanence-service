package com.example.impermanenceservice.service.impl;

import com.example.impermanenceservice.entity.Comment;
import com.example.impermanenceservice.repository.CommentMapper;
import com.example.impermanenceservice.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> getAllComment() {
        return commentMapper.getAllComment();
    }

}