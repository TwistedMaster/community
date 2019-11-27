package com.inspur.community.controller;

import com.inspur.community.dto.CommentDTO;
import com.inspur.community.dto.QuestionDTO;
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
        List<CommentDTO> comments = cs.listByQuestionId(id);
        //累加阅读数
        qs.incView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        return "question";
    }
}
