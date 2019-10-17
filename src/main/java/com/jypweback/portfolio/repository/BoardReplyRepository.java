package com.jypweback.portfolio.repository;

import com.jypweback.portfolio.entity.Board;
import com.jypweback.portfolio.entity.BoardReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>, JpaSpecificationExecutor<BoardReply> {
    
    //public Optional<BoardReply> findByUserId(String userId);

}
