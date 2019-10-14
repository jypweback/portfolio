package com.jypweback.portfolio.dto;

import com.jypweback.portfolio.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionReqDto {

    private String title;

    private String author;

    private String content;

    public Question toEntity(){
        return Question.builder().title(this.title).author(this.author).content(this.content).build();
    }



}
