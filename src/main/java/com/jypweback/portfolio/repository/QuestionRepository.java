package com.jypweback.portfolio.repository;

import com.jypweback.portfolio.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
