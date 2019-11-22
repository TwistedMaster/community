package com.inspur.community.mapper;

import com.inspur.community.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);

    int incCommentCount(Question record);
}