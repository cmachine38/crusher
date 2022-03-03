package com.construction.crusher.controller;

import com.construction.crusher.model.Employee;
import com.construction.crusher.repo.EmployeeRepository;
import com.construction.crusher.service.EmployeeService;
import com.construction.crusher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {


	//private UserService2 userService;

	private UserService userService;

	@Autowired
	private EmployeeService employeeService;


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



	@GetMapping("/employees")
	public String all(Model model) {
		System.out.println("***************************inside controller");
		model.addAttribute("employees", employeeService.findAll());
		return "employee_master";
	}


	@GetMapping("/employee_create")
	public String create(Model model) {
		model.addAttribute("newEmployee",new Employee());
		return "employee_create";
	}

	@PostMapping("/employee_create_add")
	public String addEmployee(@ModelAttribute Employee newEmployee, Model model) {
		employeeService.create(newEmployee);

		model.addAttribute("employees", employeeService.findAll());
		return "employee_master";
	}

	@GetMapping("/employee_delete")
	public String deleteEmployee(@RequestParam(value = "employeeAadhar", required = true) String employeeAadhar, Model model) {
		Employee employee = employeeService.find(employeeAadhar);
		employeeService.delete(employee);

		model.addAttribute("employees", employeeService.findAll());
		return "employee_master";
	}

	@GetMapping("/employee_edit")
	public String editEmployee(@RequestParam(value = "employeeAadhar", required = true) String employeeAadhar, Model model) {
		Employee employee = employeeService.find(employeeAadhar);

		model.addAttribute("newEmployee", employee);
		return "employee_create";
	}

}
