package com.exam.onlineExam.Controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.onlineExam.Entities.Role;
import com.exam.onlineExam.Entities.User;
import com.exam.onlineExam.Entities.User_Role;
import com.exam.onlineExam.Repositories.RoleRepo;
import com.exam.onlineExam.Services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    
   @Autowired
   UserService userService;
   @Autowired
   RoleRepo roleRepo;

   // used to add new user to the database
   @GetMapping("/test")
   public String test()
   {
    return "this is testing";
   }
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception
    {
        user.setProfilePic("default.png");
        Role role=new Role(11, "Normal");//creating a role for new user
		roleRepo.save(role);//saving that role to db

        
		User_Role user_Role=new User_Role();//creating  set of user_roles 
		user_Role.setRoleName(role);
		user_Role.setUser(user);
		// //adding userRoles for user
		Set<User_Role> userRoles=new HashSet<>();
		userRoles.add(user_Role);//adding all user_roles to the set for the user


		user.getUserRole().addAll(userRoles);//adding the set to users
        User createdUser=userService.createUser(user,userRoles);//saving user to the db
        return createdUser;
    }

    
    //to get the detail of user withi userName
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username")String userName)
    {
        User User=userService.findUserByUserName(userName);
        return User;
    }
}
