package com.inspur.community.controller;

import com.inspur.community.dto.CommentDTO;
import com.inspur.community.dto.QuestionDTO;
import com.inspur.community.enums.CommentTypeEnum;
import com.inspur.community.service.CommentService;
import com.inspur.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService qs;

    @Autowired
    private CommentService cs;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model) {
        QuestionDTO questionDTO = qs.getById(id);
        List<QuestionDTO> relatedQuestions = qs.selectRelated(questionDTO);
        List<CommentDTO> comments = cs.listByTargetId(id, CommentTypeEnum.QUESTION);
        //累加阅读数
        qs.incView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }
}
