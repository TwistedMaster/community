package com.inspur.community.service;

import com.inspur.community.dto.QuestionDTO;
import com.inspur.community.mapper.QuestionMapper;
import com.inspur.community.mapper.UserMapper;
import com.inspur.community.model.Question;
import com.inspur.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper qm;

    @Autowired
    private UserMapper um;


    public List<QuestionDTO> list() {
        List<Question> questions = qm.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = um.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
