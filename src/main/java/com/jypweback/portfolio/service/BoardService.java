package com.jypweback.portfolio.service;

import com.jypweback.portfolio.dto.board.BoardRequestDto;
import com.jypweback.portfolio.dto.board.BoardResponseDto;

public interface BoardService {

    public BoardResponseDto createBoard(BoardRequestDto reqDto);

}
