package com.exam.onlineExam.Repositories.Quizess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.onlineExam.Entities.Quizess.Question;
import com.exam.onlineExam.Entities.Quizess.Quiz;



public interface QuestionRepo extends JpaRepository<Question,Long>{
  public List<Question> findByQuiz(Quiz quiz);
}
