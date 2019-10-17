package com.jypweback.portfolio.repository;

import com.jypweback.portfolio.entity.MultiTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MultiTagRepository extends JpaRepository<MultiTag, Long>, JpaSpecificationExecutor<MultiTag> {

    //public Optional<Board> findByUserId(String userId);

}
