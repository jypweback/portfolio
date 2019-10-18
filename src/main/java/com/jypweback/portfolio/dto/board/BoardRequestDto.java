package com.jypweback.portfolio.dto.board;

import lombok.Data;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */

@Data
public class BoardRequestDto {

    @Valid
    private BoardDto boardDto = new BoardDto();

    @Valid
    private List<BoardTagDto> tagDtos = new ArrayList<BoardTagDto>();

    @Valid
    private List<BoardReplyDto> replyDtos = new ArrayList<BoardReplyDto>();

}
