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

    public BoardResponseDto createBoard(BoardRequestDto reqDto);

    public BoardResponseDto getBoardDto(Long id);

    public Board getBoard(Long id);

    public BoardResponseDto updateBoard(Long id, BoardRequestDto reqDto);

    public Page<BoardListDto> searchBoardList(BoardSearchDto searchDto, Pageable pageable);

    public BoardDto removeBoard(Long id);

}
