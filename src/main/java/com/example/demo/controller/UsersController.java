package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class UsersController {
@Autowired
UsersService  uService;

@PostMapping("/register")
public String addUser(@ModelAttribute Users user) {
	boolean usersatus=uService.emailExists(user.getEmail());
	if(usersatus==false) {
		uService.addUser(user);
		return "registersuccess";
	}
	else {
		return "registerfail";
	}


}
@PostMapping("/login" )
public String validateUser(@RequestParam  String  email,  @RequestParam String  password) {
if(uService.validateUser(email,password)==true) {
	

  if (uService.getRole(email).equals("admin")) {
	return "adminhome";
}
  else {
	return "customerhome";
}
    }
else {
	return "loginfail";
}
}
}
	
	


