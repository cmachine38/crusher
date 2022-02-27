package com.construction.crusher.controller;

import com.construction.crusher.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {


	//private UserService2 userService;

	private UserService userService;

//	public GreetingController(UserService2 userService) {
//		this.userService = userService;
//	}

	public GreetingController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/login")
	public String login(@RequestParam(name="username", required=true) String username,
						   @RequestParam(name="password", required=true) String password,
						   Model model) {
//		if(username.isBlank() || password.isBlank()){
//			model.addAttribute("error", "username or password is blank");
//			return "login";
//		}
//		model.addAttribute("name", username);
		System.out.println(username);
		System.out.println(password);
		return "Admin_Main";
	}


	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		UserDetails user = userService.loadUserByUsername("guest");
		System.out.println(user.getUsername());
		return "greeting";
	}

	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Authentication authentication) {
		return authentication.getName();
	}

}
