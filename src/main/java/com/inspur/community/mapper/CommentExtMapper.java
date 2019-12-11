package com.inspur.community.mapper;

import com.inspur.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}