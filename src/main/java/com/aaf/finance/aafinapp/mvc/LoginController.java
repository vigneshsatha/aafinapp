package com.aaf.finance.aafinapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaf.finance.aafinapp.service.UserService;

@RestController
@RequestMapping("/api")
public class LoginController {

	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/all")
	public String greeting() {
		this.userService.getUserByUserName("vignesh");
		return "Hello World..!";
	}

	@GetMapping("/auth/all")
	public String greetUser() {
		return "Hello, Welcome to app..!";
	}

}
