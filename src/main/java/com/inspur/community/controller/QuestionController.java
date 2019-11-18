package com.inspur.community.controller;

import com.inspur.community.dto.QuestionDTO;
import com.inspur.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService qs;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id, Model model) {
        QuestionDTO questionDTO = qs.getById(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }
}
