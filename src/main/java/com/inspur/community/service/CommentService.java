package com.inspur.community.service;

import com.inspur.community.enums.CommentTypeEnum;
import com.inspur.community.exception.CustomizeErrorCode;
import com.inspur.community.exception.CustomizeException;
import com.inspur.community.mapper.CommentMapper;
import com.inspur.community.mapper.QuestionExtMapper;
import com.inspur.community.mapper.QuestionMapper;
import com.inspur.community.model.Comment;
import com.inspur.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentMapper cm;

    @Autowired
    private QuestionMapper qm;

    @Autowired
    private QuestionExtMapper qem;

    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.COMMENT_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            // 回复评论
            Comment dbComment = cm.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            cm.insert(comment);
        } else {
            // 回复问题
            Question question = qm.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            cm.insert(comment);
            question.setCommentCount(1);
            qem.incCommentCount(question);
        }
    }
}
