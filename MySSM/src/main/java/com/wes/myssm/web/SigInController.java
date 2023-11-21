package com.wes.myssm.web;

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
	    // 在这里编寫生成帳號的邏輯
	    // 你可以根據角色 (role) 生成相應的帳號
	    String creatId = userService.createId(role);
	    
	    // 返回生成的帳號
	    return creatId;
	}

	
	@RequestMapping("/sigIn")
	public ModelAndView sigIn(@ModelAttribute User user) {
		System.out.println("in sigIn");
		String message = "新增失敗";
		boolean re = userService.creatAccount(user);
		if(re == true) {
			message = "新增成功";
		}
		
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("message", message);
		
		return mv;
	}
	
}
