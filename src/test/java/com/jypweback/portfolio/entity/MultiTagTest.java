package com.jypweback.portfolio.entity;

import com.jypweback.portfolio.entity.enums.MultiTagTypeEnum;
import com.jypweback.portfolio.repository.MultiTagRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiTagTest {

    @Autowired
    MultiTagRepository tagRepository;

    @Test
    public void 태그등록_테스트(){
        MultiTag tag = this.tagRepository.save(MultiTag.builder().tagText("등록테스트").tagType(MultiTagTypeEnum.BOARD).creatorId("jypweback").build());
        MultiTag newTag = this.tagRepository.findById(tag.getId()).get();

        assertThat(newTag.getTagType(), is(MultiTagTypeEnum.BOARD));
    }

}