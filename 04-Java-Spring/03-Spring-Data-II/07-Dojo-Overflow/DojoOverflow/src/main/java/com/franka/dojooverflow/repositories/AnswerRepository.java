package com.franka.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.franka.dojooverflow.models.Answer;
import com.franka.dojooverflow.models.Question;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
	List<Answer> findByQuestion(Question question);
}
