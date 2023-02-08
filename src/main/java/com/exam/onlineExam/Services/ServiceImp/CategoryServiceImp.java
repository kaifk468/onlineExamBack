package com.exam.onlineExam.Services.ServiceImp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.onlineExam.Entities.Quizess.Category;
import com.exam.onlineExam.Repositories.Quizess.CategoryRepo;
import com.exam.onlineExam.Services.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{

	@Autowired
	CategoryRepo categoryRepo;
	@Override
	public Category addCategory(Category cat) {
		// TODO Auto-generated method stub
		return categoryRepo.save(cat);
	}

	@Override
	public Category updateCategory(Category cat) {
		// TODO Auto-generated method stub
		return categoryRepo.save(cat);
	}

	@Override
	public Set<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return  new HashSet(categoryRepo.findAll());
	}

	@Override
	public Category getCategoryByName(String categoryTitle) {
		return categoryRepo.findByTitle(categoryTitle);
	}

	@Override
	public Category deleteCategory(long catId) {
		// TODO Auto-generated method stub
		if(categoryRepo.findById(catId)!=null)
			categoryRepo.deleteById(catId);
		return null;
	}

	@Override
	public Category getCategory(long catId) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(catId).get();
	}

	

}
