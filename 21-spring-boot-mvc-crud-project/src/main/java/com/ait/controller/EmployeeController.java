package com.ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ait.dto.EmployeeDto;
import com.ait.dto.LoginDto;
import com.ait.service.EmployeeService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@GetMapping(value = "/register")
	public String loadRegistrationPage(Model model,HttpSession session,RedirectAttributes res) {
		Long sessionValue = (Long) session.getAttribute("userid");
		if(sessionValue!=null) {
			model.addAttribute("employee", new EmployeeDto());
			return "employee_registration";
		}else {
			 res.addFlashAttribute("msg", "please try to login.....!");
       	  return "redirect:/login";
		}
		
		
	}
@GetMapping(value = "/login")
	public String loadLoginPage(Model model) {
		model.addAttribute("login", new LoginDto());
		return "login";
	}
@GetMapping(value = "/logout")
public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/login";
}
	@PostMapping(value = "/login")
public String loginEmployee(@Valid @ModelAttribute(value ="login") LoginDto dto, BindingResult result, 
        HttpSession session, 
        RedirectAttributes res, 
        Model model ) {
		
		if(result.hasErrors()) {			
			return "login";
		}
		String loginEmployee = empService.loginEmployee(dto.getEmail(), dto.getPassword());
              if(Integer.parseInt(loginEmployee)>0) {
           empService.handleHttpSession(Long.parseLong(loginEmployee), session); 	
           return "redirect:/list";
              }else {
           res.addFlashAttribute("msg", "username and password not matched.....!");
            	  return "redirect:/login";
              }
	}
	
	@PostMapping(value = "/save")
	public String saveEmployee(@ModelAttribute(value = "employee") EmployeeDto employeeDto, Model model) {
		if (employeeDto.isAgreeToTerms()) {
			EmployeeDto registerEmployee = empService.registerEmployee(employeeDto);
			model.addAttribute("employee", new EmployeeDto());
			model.addAttribute("msg", "employee Register sucessfylly and ID is: " + registerEmployee.getEmpId());
		} else {
			model.addAttribute("employee", employeeDto);

		}
		return "redirect:/login";
		//return "employee_registration";
	}
	
	//to fetch all employee
	@GetMapping(value="/list")
	public ModelAndView listEmployee(HttpSession session) {
		Long sessionValue = (Long) session.getAttribute("userid");
		ModelAndView mav=new ModelAndView();
		if(sessionValue!=null) {
		List<EmployeeDto> fetchAllEmployee = empService.fetchAllEmployee();
		mav.addObject("employees", fetchAllEmployee);
		mav.setViewName("employee_list");
		return mav;
		}else {
			mav.addObject("login", new LoginDto());
			mav.addObject("msg", "please try to login.....!");
			mav.setViewName("login");
			return mav;
		}
	}
	@GetMapping(value = "/edit/{id}")
	public String showEditEmployeeForm
	                                               (@PathVariable("id")Long id, Model model) {
		EmployeeDto employee = empService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "employee_registration";
		
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteEmployee
	                                               (@PathVariable("id")Long id, Model model) {
          empService.deleteEmployee(id);
		
		return "redirect:/list";
		
	}

	
}
