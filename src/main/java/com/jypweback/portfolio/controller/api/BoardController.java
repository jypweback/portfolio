package com.jypweback.portfolio.controller.api;

import com.jypweback.portfolio.dto.board.BoardListDto;
import com.jypweback.portfolio.dto.board.BoardRequestDto;
import com.jypweback.portfolio.dto.board.BoardResponseDto;
import com.jypweback.portfolio.dto.board.BoardSearchDto;
import com.jypweback.portfolio.service.BoardService;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */

@RestController
@RequestMapping("/api/v1")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping(value = "/board")
    public ResponseEntity<BoardResponseDto> createBoard(@Valid @RequestBody BoardRequestDto reqDto) {

        return ResponseEntity.ok(this.boardService.createBoard(reqDto));
    }

    @GetMapping(value = "/board/{id}")
    public ResponseEntity<BoardResponseDto> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(this.boardService.getBoardDto(id));
    }

    @PutMapping(value = "/board/{id}")
    public ResponseEntity<BoardResponseDto> updateBoard(@PathVariable Long id, @Valid @RequestBody BoardRequestDto reqDto) {
        return ResponseEntity.ok(this.boardService.updateBoard(id, reqDto));
    }

    @GetMapping(value = "/boards")
    public ResponseEntity<Page<BoardListDto>> searchBoardList(
            BoardSearchDto searchDto,
            @PageableDefault(sort = {"createDatetime"}, direction = Sort.Direction.DESC, size = 200) Pageable pageable){
        return ResponseEntity.ok(this.boardService.searchBoardList(searchDto, pageable));
    }
}
