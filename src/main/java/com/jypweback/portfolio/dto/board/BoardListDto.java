package com.jypweback.portfolio.dto.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */

@Data
@NoArgsConstructor
public class BoardListDto {

    private Long rowNumber;

    private Long id;

    private String title;

    private String boardText;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createDatetime;

    private String creatorId;
}
