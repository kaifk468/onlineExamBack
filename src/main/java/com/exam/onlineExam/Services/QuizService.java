package com.exam.onlineExam.Services;

import java.util.Set;
import com.exam.onlineExam.Entities.Quizess.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz); 
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getAllQuiz();
	
	//public Quiz getQuizByName(String CategoryTitle);
	
	public Quiz getQuiz(long catId);
	
	public Quiz deleteQuiz(long quiz);
}
