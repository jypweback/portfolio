package com.jypweback.portfolio.controller.api;

import com.jypweback.portfolio.dto.board.*;
import com.jypweback.portfolio.service.BoardService;
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
@RequestMapping("/api/v1/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping(value = "")
    public ResponseEntity<BoardResponseDto> createBoard(@Valid @RequestBody BoardRequestDto reqDto) {
        return ResponseEntity.ok(this.boardService.createBoard(reqDto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BoardResponseDto> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(this.boardService.getBoardDto(id));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<BoardResponseDto> updateBoard(@PathVariable Long id, @Valid @RequestBody BoardRequestDto reqDto) {
        return ResponseEntity.ok(this.boardService.updateBoard(id, reqDto));
    }

    @DeleteMapping(value ="{id}")
    public ResponseEntity<BoardDto> deleteBoard(@PathVariable Long id) {
        return ResponseEntity.ok(this.boardService.removeBoard(id));
    }

    @GetMapping(value = "")
    public ResponseEntity<Page<BoardListDto>> searchBoardList(
            BoardSearchDto searchDto,
            @PageableDefault(sort = {"createDatetime"}, direction = Sort.Direction.DESC, size = 200) Pageable pageable){
        return ResponseEntity.ok(this.boardService.searchBoardList(searchDto, pageable));





    }


}
