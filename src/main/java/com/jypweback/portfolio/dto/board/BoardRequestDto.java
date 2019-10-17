package com.jypweback.portfolio.dto.board;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BoardRequestDto {

    private BoardDto boardDto = new BoardDto();

    private List<BoardMultiTagDto> tagDtos = new ArrayList<BoardMultiTagDto>();

    private List<BoardReplyDto> replyDtos = new ArrayList<BoardReplyDto>();

}
