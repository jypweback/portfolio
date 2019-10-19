package com.jypweback.portfolio.service;

import com.jypweback.portfolio.dto.board.*;
import com.jypweback.portfolio.entity.Board;
import com.jypweback.portfolio.entity.BoardReply;
import com.jypweback.portfolio.entity.BoardTag;
import com.jypweback.portfolio.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto reqDto) {

        Board board = reqDto.getBoardDto().toEntity();

        for(BoardTagDto tagDto : reqDto.getTagDtos()){
            board.addBoardTag(tagDto.toEntity());
        }

        for(BoardReplyDto replyDto : reqDto.getReplyDtos()){
            board.addReply(replyDto.toEntity());
        }

        return this.convertEntityToDto(this.boardRepository.save(board));
    }

    @Override
    @Transactional(readOnly = true)
    public BoardResponseDto getBoardDto(Long id) {
        return this.convertEntityToDto(this.getBoard(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Board getBoard(Long id) {
        return this.boardRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Board " + id + " not found."));
    }

    @Override
    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto reqDto) {
        Board board = this.getBoard(id);

        BoardDto boardDto = reqDto.getBoardDto();
        board.update(boardDto.toEntity());

        /** tag remove */
        Set<Long> ids = new HashSet<Long>();
        for(BoardTagDto tag : reqDto.getTagDtos()){
            ids.add(tag.getId());
        }
        board.removeBoardTagNotContainByIds(ids);

        /** tag add */
        for(BoardTagDto tagDto : reqDto.getTagDtos()){
            if(!board.hasBoardTagById(tagDto.getId())){
                board.addBoardTag(tagDto.toEntity());
            }
        }

        return this.convertEntityToDto(board);
    }

    private BoardResponseDto convertEntityToDto(Board board){

        BoardResponseDto resDto = new BoardResponseDto();
        resDto.setBoardDto(new BoardDto(board));

        if(board.getBoardTags() != null){
            for(BoardTag tag : board.getBoardTags()){
                resDto.getTagDtos().add(new BoardTagDto(tag));
            }
        }

        if(board.getBoardReplies() != null){
            for(BoardReply reply : board.getBoardReplies()){
                resDto.getReplyDtos().add(new BoardReplyDto(reply));
            }
        }

        return resDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BoardListDto> searchBoardList(BoardSearchDto searchDto, Pageable pageable) {
        Page<BoardListDto> pageListDto = null;
        if (pageable != null && searchDto != null) {
            pageListDto = this.boardRepository.findAllBoardListBySearchDto(searchDto, pageable);
        }
        return pageListDto;
    }

    @Override
    @Transactional
    public BoardDto removeBoard(Long id) {
        Board board = this.getBoard(id);
        this.boardRepository.delete(board);
        return new BoardDto(board);
    }

}
