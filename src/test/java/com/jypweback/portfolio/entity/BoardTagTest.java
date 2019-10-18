package com.jypweback.portfolio.entity;

import com.jypweback.portfolio.repository.BoardTagRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTagTest {

    @Autowired
    BoardTagRepository tagRepository;

    @Test
    public void 태그등록_테스트(){
        BoardTag tag = this.tagRepository.save(BoardTag.builder().tagText("등록테스트").creatorId("jypweback").build());
        BoardTag newTag = this.tagRepository.findById(tag.getId()).get();

        assertThat(newTag.getCreatorId(), is("jypweback"));
    }

}