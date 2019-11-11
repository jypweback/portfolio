package com.jypweback.portfolio.controller.api;

import com.jypweback.portfolio.dto.board.BoardReplyDto;
import com.jypweback.portfolio.service.ReplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */

@RestController
@RequestMapping("/api/v1/boards/{boardId}/replys")
public class ReplyController {

    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping(value = "")
    public ResponseEntity<BoardReplyDto> createReply(@PathVariable Long boardId, @Valid @RequestBody BoardReplyDto reply) {
        return ResponseEntity.ok(this.replyService.addReply(boardId, reply.getReplyText()));
    }

    @DeleteMapping(value ="{id}")
    public ResponseEntity<BoardReplyDto> deleteReply(@PathVariable Long id) {
        return ResponseEntity.ok(this.replyService.removeReply(id));
    }
}
