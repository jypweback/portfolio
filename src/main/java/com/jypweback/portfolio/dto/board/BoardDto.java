package com.jypweback.portfolio.dto.board;

import com.jypweback.portfolio.entity.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */

@Data
@NoArgsConstructor
public class BoardDto {

    public BoardDto(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.boardText = board.getBoardText();
    }

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String boardText;

    public Board toEntity(){
        return Board.builder()
                .title(this.title)
                .boardText(this.boardText)
                .build();
    }
}