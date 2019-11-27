package com.jypweback.portfolio.service;

import com.jypweback.portfolio.dto.board.*;
import com.jypweback.portfolio.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */

public interface BoardService {

    BoardResponseDto createBoard(BoardRequestDto reqDto);

    BoardResponseDto getBoardDto(Long id);

    Board getBoard(Long id);

    BoardResponseDto updateBoard(Long id, BoardRequestDto reqDto);

    Page<BoardListDto> searchBoardList(BoardSearchDto searchDto, Pageable pageable);

    BoardDto removeBoard(Long id);

}
