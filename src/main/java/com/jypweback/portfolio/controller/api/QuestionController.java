package com.jypweback.portfolio.controller.api;

import com.jypweback.portfolio.dto.QuestionReqDto;
import com.jypweback.portfolio.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class QuestionController {

    private QuestionRepository questionRepository;

    @PostMapping("/question")
    public void saveQuestion(@RequestBody QuestionReqDto dto){
        this.questionRepository.save(dto.toEntity());
    }

}
