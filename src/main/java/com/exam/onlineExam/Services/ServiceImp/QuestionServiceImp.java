package com.exam.onlineExam.Services.ServiceImp;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.onlineExam.Entities.Quizess.Question;
import com.exam.onlineExam.Entities.Quizess.Quiz;
import com.exam.onlineExam.Repositories.Quizess.QuestionRepo;
import com.exam.onlineExam.Services.QuestionService;

@Service
public class QuestionServiceImp implements QuestionService{

	@Autowired
	QuestionRepo questionRepo;
	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionRepo.save(question);
	}

	@Override
	public Set<Question> getAllQuestion() {
		// TODO Auto-generated method stub
		return (Set<Question>) questionRepo.findAll();
	}

	@Override
	public Set<Question> getQuestionsByQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return (Set<Question>) questionRepo.findByQuiz(quiz);
	}

	@Override
	public Question getQuestion(long questionsId) {
		// TODO Auto-generated method stub
		return questionRepo.findById(questionsId).get();
	}

	@Override
	public void deleteQuestions(long questions) {
		// TODO Auto-generated method stub
		questionRepo.deleteById(questions);
		
	}

}
