package com.jypweback.portfolio.service;

import com.jypweback.portfolio.dto.board.BoardReplyDto;
import com.jypweback.portfolio.entity.BoardReply;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-19
 * Github : http://github.com/jypweback
 */

public interface ReplyService {

    BoardReplyDto addReply(Long boardId, String replyText);

    BoardReplyDto removeReply(Long id);

    BoardReply getReply(Long id) ;

}
