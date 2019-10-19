package com.jypweback.portfolio.service;

import com.jypweback.portfolio.entity.Board;
import com.jypweback.portfolio.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-19
 * Github : http://github.com/jypweback
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyServiceTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyService replyService;

    @Test
    @Transactional
    public void addReply_테스트(){
        Board board = this.boardRepository.findById(1L).get();
        this.replyService.addReply(board.getId(), "댓글추가합니다아앙");
    }
}