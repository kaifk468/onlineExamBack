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

import com.exam.onlineExam.Entities.Quizess.Category;
import com.exam.onlineExam.Services.ServiceImp.CategoryServiceImp;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

	@Autowired
	CategoryServiceImp categoryService;
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category)
	{
		return ResponseEntity.ok(categoryService.addCategory(category));
	}
	
	@RequestMapping("/{categoryId}")
	public ResponseEntity<Category> getCategory(@PathVariable long categoryId)
	{
		return ResponseEntity.ok(categoryService.getCategory(categoryId));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory()
	{
		return ResponseEntity.ok(categoryService.getAllCategory());
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateCategory(@RequestBody Category category)
	{
		return ResponseEntity.ok(categoryService.updateCategory(category));
	} 
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable long categoryId)
	{
		return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
	}
	
	
	
	
	
	
	

}
