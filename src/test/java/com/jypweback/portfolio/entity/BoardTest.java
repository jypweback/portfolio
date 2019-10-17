package com.jypweback.portfolio.entity;

import com.jypweback.portfolio.entity.enums.MultiTagTypeEnum;
import com.jypweback.portfolio.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    @Transactional
    public void 게시판등록_TEST(){
        Board board = this.boardRepository.save(Board.builder().boardText("등록테스트").creatorId("jypweback").title("타이틀").build());
        Board newBoard = this.boardRepository.findById(board.getId()).get();

        assertThat(newBoard.getCreatorId(), is("jypweback"));
    }

    @Test
    @Transactional
    public void 게시판연관관계_댓글태그등록_테스트(){

        final int LOOP_MIN_NUM = 1;
        final int LOOP_MAX_NUM = 5;

        Board board = Board.builder().boardText("등록테스트").creatorId("jypweback").title("타이틀").build();

        for(int i = LOOP_MIN_NUM; i <= LOOP_MAX_NUM; i++){
            MultiTag tag = MultiTag.builder().tagText("태그" + i).tagType(MultiTagTypeEnum.BOARD).creatorId("jypweback").build();
            board.addMultiTag(tag);
        }

        List<BoardReply> boardReplies = new ArrayList<BoardReply>() ;
        for(int i = LOOP_MIN_NUM; i <= LOOP_MAX_NUM; i++){
            BoardReply reply = BoardReply .builder().replyText("댓글" + i).creatorId("jypweback").build();
            boardReplies.add(reply);
        }
        board.setBoardReplies(boardReplies);

        Board newBoard = this.boardRepository.save(board);
        Board savedBoard = this.boardRepository.findById(newBoard.getId()).get();

        // 작성자
        assertThat(savedBoard.getCreatorId(), is("jypweback"));

        // 태그
        assertThat(savedBoard.getMultiTags().size(), is(LOOP_MAX_NUM));

        // 댓글
        assertThat(savedBoard.getBoardReplies().size(), is(LOOP_MAX_NUM));
    }

}