package com.jypweback.portfolio.repository;

import com.jypweback.portfolio.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-16
 * Github : http://github.com/jypweback
 */

public interface MemberRepository extends JpaRepository<Member, Integer>, JpaSpecificationExecutor<Member> {

    public Optional<Member> findByUserId(String userId);

    public Optional<Member> findByUserIdAndUserPassword(String userId, String password);

}
