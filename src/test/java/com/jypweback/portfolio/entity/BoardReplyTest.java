package com.jypweback.portfolio.entity;

import com.jypweback.portfolio.repository.BoardReplyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardReplyTest {

    @Autowired
    BoardReplyRepository boardReplyRepository;

    @Test
    @Transactional
    public void 댓글등록_테스트(){
        BoardReply reply = this.boardReplyRepository.save(BoardReply.builder().replyText("등록테스트").creatorId("jypweback").build());
        BoardReply newReply = this.boardReplyRepository.findById(reply.getId()).get();

        assertThat(newReply.getCreatorId(), is("jypweback"));
    }
}