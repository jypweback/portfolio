package com.jypweback.portfolio.repository;

import com.jypweback.portfolio.entity.Board;
import com.jypweback.portfolio.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long>, JpaSpecificationExecutor<Board> {

    //public Optional<Board> findByUserId(String userId);

}
