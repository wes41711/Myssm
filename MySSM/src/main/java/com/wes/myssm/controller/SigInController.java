package com.wes.myssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wes.myssm.bean.User;
import com.wes.myssm.service.UserService;

@Controller
public class SigInController {
	
	@Autowired
	private	UserService userService;
	
	@RequestMapping("/returnSignIn")
	public String returnSigIn() {
		System.out.println("進入Controller");
		return "sigIn";
	}
	
	@RequestMapping("/generateAccount")
	@ResponseBody
	public String creatId(@RequestParam("role") String role) {

	    String creatId = userService.createId(role);
	    
	    // 返回生成的帳號
	    return creatId;
	}
	
	@RequestMapping("/sigIn")
	public ModelAndView sigIn(@ModelAttribute User user) {
		System.out.println("in sigIn");
		String message = "";
		boolean re = userService.creatAccount(user);
		if(re == true) {
			message = "創建成功,趕緊登入試試吧~";
		}
		
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("message", message);
		
		return mv;
	}
}
