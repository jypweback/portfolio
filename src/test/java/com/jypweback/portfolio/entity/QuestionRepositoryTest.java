package com.jypweback.portfolio.entity;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    @After
    public void cleanup() {
        this.questionRepository.deleteAll();
    }


    @Test
    public void 질문저장_불러오기(){

        // given
        questionRepository.save(Question.builder().title("테스트 게시글").author("jypweback").build());

        // when
        List<Question> questions = this.questionRepository.findAll();

        // then
        Question question = questions.get(0);

        assertThat(question.getTitle(), is("테스트 게시글"));
    }

}