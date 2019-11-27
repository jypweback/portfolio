package com.jypweback.portfolio.repository;

import com.jypweback.portfolio.entity.Board;
import com.jypweback.portfolio.entity.BoardReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-16
 * Github : http://github.com/jypweback
 */

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>, JpaSpecificationExecutor<BoardReply> {
}
