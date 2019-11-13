package com.inspur.community.dto;

import com.inspur.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {

    private Integer id;

    private String title;

    private String description;

    private String tag;

    private Long gmtCreate;

    private Long gmtModified;

    private Integer creator;

    private Integer commentCount;

    private Integer viewCount;

    private Integer likeCount;

    private User user;
}
