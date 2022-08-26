package com.exam.onlineExam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.onlineExam.Entities.Role;
import com.exam.onlineExam.Entities.User;
import com.exam.onlineExam.Entities.User_Role;
import com.exam.onlineExam.Repositories.RoleRepo;
import com.exam.onlineExam.Services.UserService;

@SpringBootApplication
public class OnlineExamApplication  implements CommandLineRunner{

	@Autowired
	UserService userService;

	@Autowired
	RoleRepo roleRepo;
	public static void main(String[] args) {
		SpringApplication.run(OnlineExamApplication.class, args);
		System.out.println("system is running smothely -------------------------------------");
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//setting up user data;
		User user=new User();
		user.setEmail("kaifk468@gmail.com");
		user.setEnabled(true);
		user.setLastName("siiddique");
		user.setUserName("kaifk468");
		user.setPhone("87878789809");

		// //creating a role for user
		Role role=new Role(10, "Normal");
		// //

		roleRepo.save(role);
		User_Role user_Role=new User_Role();
		user_Role.setRoleName(role);
		user_Role.setUser(user);

		// //adding userRole for user
		Set<User_Role> userRoles=new HashSet<>();
		userRoles.add(user_Role);

		 //user.setUserRole(userRoles);
		
		 userService.createUser(user, userRoles);

		//user data with user role completed
		

		System.out.println("commandLineRunner is  running");
		
	}

}
