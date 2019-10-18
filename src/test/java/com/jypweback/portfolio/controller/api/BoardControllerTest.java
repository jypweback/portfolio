package com.jypweback.portfolio.controller.api;

import com.jypweback.portfolio.common.AbstractTest;
import com.jypweback.portfolio.dto.board.BoardDto;
import com.jypweback.portfolio.dto.board.BoardReplyDto;
import com.jypweback.portfolio.dto.board.BoardRequestDto;
import com.jypweback.portfolio.dto.board.BoardTagDto;
import com.jypweback.portfolio.entity.Board;
import com.jypweback.portfolio.repository.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class BoardControllerTest extends AbstractTest{

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BoardRepository boardRepository;


    @Test
    public void createBoard_테스트() throws Exception {

        // given
        final int LOOP_MIN_NUM = 1;
        final int LOOP_MAX_NUM = 2;

        final String URL = "/api/v1/board";

        BoardRequestDto reqDto = new BoardRequestDto();

        BoardDto boardDto = new BoardDto();
        boardDto.setBoardText("게시판");
        boardDto.setTitle("타이틀");
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
        ResultActions action = mvc.perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(super.mapToJson(reqDto)))
                .andDo(print())
                ;

        // then
        action.andExpect(status().isOk());
    }

    @Test
    public void Spring_Validation_테스트() throws Exception {

        // given
        BoardRequestDto reqDto = new BoardRequestDto();
        final String URL = "/api/v1/board";

        BoardDto boardDto = new BoardDto();
        reqDto.setBoardDto(boardDto);

        BoardReplyDto replyDto = new BoardReplyDto();
        reqDto.getReplyDtos().add(replyDto);

        // when
        ResultActions action = mvc.perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(super.mapToJson(reqDto)))
                .andDo(print());

        // then
        action.andExpect(status().isBadRequest());
    }

    @Test
    public void getBoard_테스트() throws Exception{

        // given
        Board board = this.boardRepository.save(Board.builder().title("title").boardText("text").build());
        final String URL = "/api/v1/board/" + board.getId();

        // when
        ResultActions action = mvc.perform(MockMvcRequestBuilders.get(URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print());

        // then
        action
            .andExpect(status().isOk())
            .andExpect(jsonPath("$..boardDto..title").value("title"))
            .andExpect(jsonPath("$..boardDto..boardText").value("text"))
        ;
    }

    @Test
    public void updateBoard_테스트() throws Exception{

        // given
        final String title = "update title";
        final String text = "update text";

        Board board = this.boardRepository.save(Board.builder().title("title").boardText("text").build());
        final String URL = "/api/v1/board/" + board.getId();

        BoardRequestDto reqDto = new BoardRequestDto();
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle(title);
        boardDto.setBoardText(text);
        reqDto.setBoardDto(boardDto);

        System.out.println(super.mapToJson(reqDto));

        // when
        ResultActions action = mvc.perform(MockMvcRequestBuilders.put(URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(super.mapToJson(reqDto)))
                .andDo(print());

        // then
        action
            .andExpect(status().isOk())
            .andExpect(jsonPath("$..boardDto..title").value(title))
            .andExpect(jsonPath("$..boardDto..boardText").value(text))
        ;
    }

    @Test
    public void searchBoardList_테스트() throws Exception{

        // given
        final String URL = "/api/v1/boards";

        for(int i=1; i <= 50; i++){
            Board board = Board.builder().boardText("text" + i).title("title" + i).build();
            this.boardRepository.save(board);
        }

        // when
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .param("page", "0")
                .param("size", "10")).andDo(print());

        // then
        action
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content[0].title").value("title50"))
            .andExpect(jsonPath("$.content[0].boardText").value("text50"))
            .andExpect(jsonPath("$.content[0].rowNumber").value("50"))
            ;

    }

}