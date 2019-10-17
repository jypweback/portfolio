package com.jypweback.portfolio.dto.board;

import com.jypweback.portfolio.entity.Board;
import lombok.Data;

@Data
public class BoardDto {

    private Long id;

    private String title;

    private String boardText;

    public Board toEntity(){
        return Board.builder()
                .title(this.title)
                .boardText(this.boardText)
                .build();
    }

}
