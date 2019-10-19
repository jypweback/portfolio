package com.jypweback.portfolio.dto.board;

import com.jypweback.portfolio.entity.BoardReply;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */

@Data
@NoArgsConstructor
public class BoardReplyDto {

    public BoardReplyDto(BoardReply reply){
        this.id = reply.getId();
        if(reply.getBoard() != null){
            this.boardId = reply.getBoard().getId();
        }
        this.replyText = reply.getReplyText();
        this.creatorId = reply.getCreatorId();
    }

    private Long id;

    private Long boardId;

    @NotBlank
    private String replyText;

    private String creatorId;

    public BoardReply toEntity(){
        return BoardReply.builder().replyText(replyText).creatorId(this.creatorId).build();
    }

}
