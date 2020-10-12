package com.franka.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franka.dojooverflow.models.Answer;
import com.franka.dojooverflow.models.Question;
import com.franka.dojooverflow.models.Tag;
import com.franka.dojooverflow.repositories.AnswerRepository;
import com.franka.dojooverflow.repositories.QuestionRepository;
import com.franka.dojooverflow.repositories.TagRepository;

@Service
public class AppService {
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private TagRepository tRepo;
	
	public Question createNewQuestion(Question question) {
		List<Tag> questionsTags = new ArrayList<Tag>();
		String[] tags = question.splitTags();
		
		for(String subject: tags) {
			Tag tag = this.tRepo.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tag();
				tag.setSubject(subject);
				this.createTag(tag);
			}
			
			if(!questionsTags.contains(tag)) 
				questionsTags.add(tag);
		}
		question.setTags(questionsTags);
		return createQuestion(question);
	}
	
	public Question createQuestion(Question question) {
		return this.qRepo.save(question);
	}
	
	public Tag createTag(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
	public List<Question> getQuestions(){
		return this.qRepo.findAll();
	}
	
	public Question getQuestionById(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
}
