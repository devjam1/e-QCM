package com.javaee.eqcm.repository;

import com.javaee.eqcm.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
