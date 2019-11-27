package com.jypweback.portfolio.repository;

import com.jypweback.portfolio.entity.BoardTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-16
 * Github : http://github.com/jypweback
 */

public interface BoardTagRepository extends JpaRepository<BoardTag, Long>, JpaSpecificationExecutor<BoardTag> {
}
