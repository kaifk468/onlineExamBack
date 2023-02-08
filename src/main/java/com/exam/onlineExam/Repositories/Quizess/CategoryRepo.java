package com.exam.onlineExam.Repositories.Quizess;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exam.onlineExam.Entities.Quizess.Category;

public interface CategoryRepo extends JpaRepository<Category,Long>{
	public Category findByTitle(String CategoryTitle);

}
