package com.wes.myssm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wes.myssm.service.UserService;

@Controller
public class ForgotPassword {
	
	@Autowired
	private UserService userService;
	
	private String message;
	
	
	@RequestMapping("/returnForgotPassword")
	public String returnForgotPassword() {
		System.out.println("進入Controller");
		return "forgotPassword";
	}
	
	@RequestMapping("/forgotPassword")
	public ModelAndView forgotPassword(@RequestParam("id") String id, @RequestParam("mail") String mail) {
		System.out.println("in forgotPassword");
		
		ModelAndView mv = new ModelAndView("login");
		
		if(userService.checkIdMail(id, mail)) {
			message = "密碼信件已發送,請查收";
			mv.addObject("message", message);
		}else{
			message = "查無帳號與信箱";
			mv.addObject("message", message);
		}
		
		return mv;
	}
}
