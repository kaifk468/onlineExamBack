package com.exam.onlineExam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.onlineExam.Entities.Quizess.Quiz;
import com.exam.onlineExam.Repositories.RoleRepo;
import com.exam.onlineExam.Repositories.Quizess.CategoryRepo;
import com.exam.onlineExam.Repositories.Quizess.QuizeRepo;
import com.exam.onlineExam.Services.CategoryService;
import com.exam.onlineExam.Services.UserService;

@SpringBootApplication
public class OnlineExamApplication  implements CommandLineRunner{

	@Autowired
	CategoryRepo categoryRepo;
	public static void main(String[] args) {
		SpringApplication.run(OnlineExamApplication.class, args);
		System.out.println("system is running smothely -------------------------------------");
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
