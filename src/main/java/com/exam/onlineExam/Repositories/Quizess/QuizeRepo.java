package com.exam.onlineExam.Repositories.Quizess;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.exam.onlineExam.Entities.Quizess.Category;
import com.exam.onlineExam.Entities.Quizess.Quiz;

@Transactional
public interface QuizeRepo extends JpaRepository<Quiz,Long>{

	@Modifying
	@Query("delete from Quiz t where t.id = ?1")
	void deletee(Long entityId);
	List<Quiz> findByCategoryAndActive(Category category,boolean active);
	List<Quiz> findByActive(boolean active);
}
