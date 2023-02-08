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
	UserService userService;

	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	QuizeRepo quizeRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	public static void main(String[] args) {
		SpringApplication.run(OnlineExamApplication.class, args);
		System.out.println("system is running smothely -------------------------------------");
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        Quiz q=new Quiz();
        q.setId(59);
        //categoryRepo.deleteById(49L);
        //quizeRepo.deletee(67L);;
       // System.out.print("deleted");
		//setting up user data;
		// User user=new User();
		// user.setEmail("kaifk468@gmail.com");
		// user.setEnabled(true);
		// user.setLastName("siiddique");
		// user.setUserName("kaifk456468");
		// user.setPhone("87878789809");
		// user.setPassword("helloe moto how do uo do");

		// // //creating a role for user
		// Role role=new Role(11, "Normal");
		// // //

		// roleRepo.save(role);
		// User_Role user_Role=new User_Role();
		// user_Role.setRoleName(role);
		// user_Role.setUser(user);

		// // //adding userRoles for user
		// Set<User_Role> userRoles=new HashSet<>();
		// userRoles.add(user_Role);

		// user.getUserRole().addAll(userRoles);
		
		//  userService.createUser(user,userRoles);//to seave thie to the datat base

		// //user data with user role completed
		

		// System.out.println("commandLineRunner is  running");
		
	}

}
