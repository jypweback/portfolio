package com.jypweback.portfolio.controller.web;

import com.jypweback.portfolio.dto.board.BoardResponseDto;
import com.jypweback.portfolio.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-08
 * Github : http://github.com/jypweback
 */

@Controller
@RequestMapping("/boards")
public class BoardViewController {

    private BoardService boardService;

    public BoardViewController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/create")
    public String create() {
        return "view/board/create";
    }

    @GetMapping("")
    public String list(Model model) {
        return "view/board/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        BoardResponseDto resDto = this.boardService.getBoardDto(id);
        model.addAttribute("resDto", resDto);
        model.addAttribute("newLineChar", '\n');
        return "view/board/detail";
    }

    @GetMapping("/{id}/form")
    public String update(@PathVariable Long id, Model model) {
        BoardResponseDto resDto = this.boardService.getBoardDto(id);
        model.addAttribute("resDto", resDto);
        return "view/board/update";
    }

    @GetMapping("/login")
    public String login() {
        return "view/board/login";
    }

    @GetMapping("/test")
    public String test() {
        return "view/board/test";
    }

    @GetMapping("/detail/{id}")
    public String detail_test(@PathVariable Long id, Model model) {
        BoardResponseDto resDto = this.boardService.getBoardDto(id);
        model.addAttribute("resDto", resDto);
        model.addAttribute("newLineChar", '\n');
        return "view/board/detail_test";
    }
}
