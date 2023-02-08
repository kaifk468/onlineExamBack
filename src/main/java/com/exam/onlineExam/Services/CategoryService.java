package com.exam.onlineExam.Services;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.onlineExam.Entities.Quizess.Category;

@Service
public interface CategoryService {
	
	public Category addCategory(Category cat); 
	
	public Category updateCategory(Category cat);
	
	public Set<Category> getAllCategory();
	
	public Category getCategoryByName(String CategoryTitle);
	
	public Category getCategory(long catId);
	
	public Category deleteCategory(long catId);
	

}
