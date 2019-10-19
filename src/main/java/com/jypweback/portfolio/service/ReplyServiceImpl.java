package com.jypweback.portfolio.service;

import com.jypweback.portfolio.dto.board.BoardReplyDto;
import com.jypweback.portfolio.entity.Board;
import com.jypweback.portfolio.entity.BoardReply;
import com.jypweback.portfolio.repository.BoardReplyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-19
 * Github : http://github.com/jypweback
 */

@Service
public class ReplyServiceImpl implements ReplyService {

    private final BoardService boardService;
    private final BoardReplyRepository boardReplyRepository;

    public ReplyServiceImpl(BoardService boardService, BoardReplyRepository boardReplyRepository) {
        this.boardService = boardService;
        this.boardReplyRepository = boardReplyRepository;
    }

    @Override
    @Transactional
    public BoardReplyDto addReply(Long boardId, String replyText) {
        Board board = boardService.getBoard(boardId);
        BoardReply reply = BoardReply.builder().replyText(replyText).creatorId("default").build();
        board.addReply(reply);
        this.boardReplyRepository.save(reply);

        return new BoardReplyDto(reply);
    }

    @Override
    @Transactional(readOnly = true)
    public BoardReply getReply(Long id) {
        return this.boardReplyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BoardReply " + id + " not found."));
    }

    @Override
    public BoardReplyDto removeReply(Long id) {
        BoardReply reply = this.getReply(id);
        this.boardReplyRepository.delete(reply);
        return new BoardReplyDto(reply);
    }
}
