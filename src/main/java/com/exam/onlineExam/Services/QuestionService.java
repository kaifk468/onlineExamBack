package com.exam.onlineExam.Services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.onlineExam.Entities.Quizess.Question;
import com.exam.onlineExam.Entities.Quizess.Quiz;

@Service
public interface QuestionService {
	
    public Question addQuestion(Question question); 
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getAllQuestion();
	
	public Set<Question> getQuestionsByQuiz(Quiz quiz);
	
	public Question getQuestion(long questionsId);
	
	public void deleteQuestions(long questions);

}
