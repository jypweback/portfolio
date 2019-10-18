package com.jypweback.portfolio.repository;

import com.jypweback.portfolio.dto.board.BoardListDto;
import com.jypweback.portfolio.dto.board.BoardSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */
public interface CustomBoardRepository {

    public Page<BoardListDto> findAllBoardListBySearchDto(BoardSearchDto searchDto, Pageable pageable);

}
