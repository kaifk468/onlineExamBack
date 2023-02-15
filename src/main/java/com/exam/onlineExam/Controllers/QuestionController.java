package com.exam.onlineExam.Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.onlineExam.Entities.Quizess.Question;
import com.exam.onlineExam.Entities.Quizess.Quiz;
import com.exam.onlineExam.Services.ServiceImp.QuestionServiceImp;
import com.exam.onlineExam.Services.ServiceImp.QuizServiceImp;

@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionServiceImp questionService;
	@Autowired
	QuizServiceImp quizService;
	//add question 
	@PostMapping("/")
	public ResponseEntity<?> addQuestion(@RequestBody Question question)
	{
		return ResponseEntity.ok(questionService.addQuestion(question));
	}
    //get question by Id
	@RequestMapping("/{questionId}")
	public ResponseEntity<Question> getQuestion(@PathVariable long questionId)
	{
		return ResponseEntity.ok(questionService.getQuestion(questionId));
	}
	
	//geting ques of a particular of quiz of size maxNoOfQuestion
	@GetMapping("/quiz/{qId}")
	public ResponseEntity<?> getQuestionByQuiz(@PathVariable("qId")long qId)
	{
		Quiz quiz=quizService.getQuiz(qId);
		int noOfQues=(int)quiz.getNoOfQuestion();
		List<Question> list=new ArrayList<>(quiz.getQuestions());
		Collections.shuffle(list);
		if(list.size()>noOfQues)
		{
			list=list.subList(0, noOfQues+1);
		}
		return  ResponseEntity.ok(list);
		
	}
	
	//geting all ques of a particular of quiz 
	@GetMapping("/quiz/all/{qId}")
	public ResponseEntity<?> getAllQuestionByQuiz(@PathVariable("qId")long qId)
	{
		Quiz quiz=quizService.getQuiz(qId);
		//int noOfQues=(int)quiz.getNoOfQuestion();
		List<Question> list=new ArrayList<>(quiz.getQuestions());
//		Collections.shuffle(list);
//		if(list.size()>noOfQues)
//		{
//			list=list.subList(0, noOfQues+1);
//		}
		return  ResponseEntity.ok(list);
		
	}
	//update question
	@PutMapping("/")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question)
	{
		return ResponseEntity.ok(questionService.updateQuestion(question));
	} 
	//delete question 
	@DeleteMapping("/{questionId}")
	public void deleteQuestion(@PathVariable long questionId)
	{
		questionService.deleteQuestions(questionId);
	}

}
