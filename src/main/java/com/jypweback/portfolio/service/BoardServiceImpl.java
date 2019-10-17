package com.jypweback.portfolio.service;

import com.jypweback.portfolio.dto.board.BoardRequestDto;
import com.jypweback.portfolio.dto.board.BoardResponseDto;
import com.jypweback.portfolio.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService{

    private BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto reqDto) {



        return null;
    }
}
