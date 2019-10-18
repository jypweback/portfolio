package com.jypweback.portfolio.dto.board;

import com.jypweback.portfolio.entity.BoardTag;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */

@Data
@NoArgsConstructor
public class BoardTagDto {

    public BoardTagDto(BoardTag tag){
        this.id = tag.getId();
        if(tag.getBoard() != null){
            this.boardId = tag.getBoard().getId();
        }
        this.tagText = tag.getTagText();
    }

    private Long id;

    private Long boardId;

    @NotBlank
    private String tagText;

    public BoardTag toEntity(){
        return BoardTag.builder()
                .tagText(this.tagText)
                .build();
    }

}
