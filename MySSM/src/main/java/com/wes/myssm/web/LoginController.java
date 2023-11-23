package com.wes.myssm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wes.myssm.bean.User;
import com.wes.myssm.entity.Student;
import com.wes.myssm.entity.Teacher;
import com.wes.myssm.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	private String message;
	
	
	@RequestMapping("/returnLogin")
	public String returnLogin(){
		System.out.println("進入Controller");
		return "login";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		System.out.println("in login");
		
		ModelAndView mv = new ModelAndView("show");
		
		User user = userService.checkIdRole(id, pwd);
		
		if(user == null) {
			message = "查無帳號,請註冊";
			ModelAndView mvlogin = new ModelAndView("login");
			mvlogin.addObject("message", message);
			return mvlogin;
		}else{
			String idFirst[] = user.getNo().split("");
			
			if(idFirst[0].equals("T")){
				Teacher teacher = (Teacher)user;
				mv.addObject("message", teacher);
		}
			else if(idFirst[0].equals("A")) {
				Student student = (Student)user;
				mv.addObject("message", student);
			}
		}	
		return mv;
	}
	
}
