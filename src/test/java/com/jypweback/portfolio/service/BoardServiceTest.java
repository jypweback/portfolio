package com.jypweback.portfolio.service;

import com.jypweback.portfolio.dto.board.*;
import com.jypweback.portfolio.entity.Board;
import com.jypweback.portfolio.entity.BoardReply;
import com.jypweback.portfolio.entity.BoardTag;
import com.jypweback.portfolio.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void createBoard_테스트(){

        // given
        final int LOOP_MIN_NUM = 1;
        final int LOOP_MAX_NUM = 5;

        BoardRequestDto reqDto = new BoardRequestDto();

        BoardDto boardDto = new BoardDto();
        boardDto.setBoardText("게시판");

        reqDto.setBoardDto(boardDto);
        for(int i = LOOP_MIN_NUM; i <= LOOP_MAX_NUM; i++){
            BoardTagDto tagDto = new BoardTagDto();
            tagDto.setTagText("태그" + i);
            reqDto.getTagDtos().add(tagDto);
        }

        for(int i = LOOP_MIN_NUM; i <= LOOP_MAX_NUM; i++){
            BoardReplyDto replyDto = new BoardReplyDto();
            replyDto.setReplyText("댓글" + i);
            reqDto.getReplyDtos().add(replyDto);
        }

        // when
        BoardResponseDto resDto =  this.boardService.createBoard(reqDto);

        // then
        assertThat(resDto.getBoardDto().getBoardText(), is("게시판"));
        assertThat(resDto.getReplyDtos().size(), is(LOOP_MAX_NUM));
        assertThat(resDto.getTagDtos().size(), is(LOOP_MAX_NUM));
    }

    @Test
    public void updateBoard_테스트(){

        final String title = "update title";
        final String text = "update text";

        // given
        Board board = Board.builder().title("title").boardText("text").build();

        board.addReply(BoardReply.builder().replyText("reply1").build());
        board.addReply(BoardReply.builder().replyText("reply2").build());

        board.addBoardTag(BoardTag.builder().tagText("tag1").build());
        board.addBoardTag(BoardTag.builder().tagText("tag2").build());

        Board savedBoard = this.boardRepository.save(board);

        BoardRequestDto reqDto = new BoardRequestDto();
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle(title);
        boardDto.setBoardText(text);
        reqDto.setBoardDto(boardDto);

        List<BoardTagDto> tagDtos = new ArrayList<BoardTagDto>();
        BoardTagDto originalDto = new BoardTagDto();
        originalDto.setId(savedBoard.getBoardTags().get(0).getId());
        tagDtos.add(originalDto);

        BoardTagDto newTag1 = new BoardTagDto();
        newTag1.setId(null);
        newTag1.setTagText("태그3");
        tagDtos.add(newTag1);

        BoardTagDto newTag2 = new BoardTagDto();
        newTag2.setId(null);
        newTag2.setTagText("태그4");
        tagDtos.add(newTag2);

        reqDto.setTagDtos(tagDtos);

        // when
        BoardResponseDto resDto = this.boardService.updateBoard(savedBoard.getId(), reqDto);

        // then
        assertThat(resDto.getBoardDto().getTitle(), is(title));
        assertThat(resDto.getBoardDto().getBoardText(), is(text));
        assertThat(resDto.getTagDtos().size(), is(3));
        assertThat(resDto.getReplyDtos().size(), is(2));
    }
}