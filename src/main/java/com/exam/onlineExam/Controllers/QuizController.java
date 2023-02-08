package com.exam.onlineExam.Controllers;

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

import com.exam.onlineExam.Entities.Quizess.Quiz;
import com.exam.onlineExam.Services.ServiceImp.QuizServiceImp;

@RestController
@CrossOrigin
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizServiceImp quizService;
	
	//add quiz to db
	@PostMapping("/")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(quizService.addQuiz(quiz));
	}
	//get a quiz by its Id
	@RequestMapping("/{quizId}")
	public ResponseEntity<Quiz> getQuiz(@PathVariable long quizId)
	{
		return ResponseEntity.ok(quizService.getQuiz(quizId));
	}
	//get all quiz 
	@GetMapping("/")
	public ResponseEntity<?> getAllQuiz()
	{
		return ResponseEntity.ok(quizService.getAllQuiz());
	}
	//updtae quiz make sure to give same id that u want to update
	@PutMapping("/")
	public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(quizService.updateQuiz(quiz));
	} 
	
	//delete quiz by its id
	@DeleteMapping("/{quizId}")
	public ResponseEntity<?> deleteQuiz(@PathVariable long quizId)
	{
		Quiz quiz=new Quiz();
		quiz.setId(quizId);
		return ResponseEntity.ok(quizService.deleteQuiz(quizId));
	}

}
