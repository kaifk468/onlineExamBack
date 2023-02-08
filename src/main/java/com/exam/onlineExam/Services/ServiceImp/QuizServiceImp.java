package com.exam.onlineExam.Services.ServiceImp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.onlineExam.Entities.Quizess.Quiz;
import com.exam.onlineExam.Repositories.Quizess.QuizeRepo;
import com.exam.onlineExam.Services.QuizService;

@Service
public class QuizServiceImp implements QuizService {

	@Autowired
	QuizeRepo quizeRepo;
	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizeRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizeRepo.save(quiz);
	}

	@Override
	public Set<Quiz> getAllQuiz() {
		// TODO Auto-generated method stub
		return new HashSet<>(quizeRepo.findAll());
	}

	@Override
	public Quiz getQuiz(long quizId) {
		// TODO Auto-generated method stub
		return quizeRepo.findById(quizId).get();
	}

	public Quiz deleteQuiz(long quizId) {
		// TODO Auto-generated method stub
//		quiz=quizeRepo.findById(quiz.getId()).get();
//		quiz.setDescription(null);
			quizeRepo.deletee(quizId);
        return null;
	}

}
