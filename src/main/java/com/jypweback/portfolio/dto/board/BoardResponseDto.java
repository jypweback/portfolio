package com.jypweback.portfolio.dto.board;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */

@Data
public class BoardResponseDto {

    private BoardDto boardDto = new BoardDto();

    private List<BoardTagDto> tagDtos = new ArrayList<BoardTagDto>();

    private List<BoardReplyDto> replyDtos = new ArrayList<BoardReplyDto>();

}
