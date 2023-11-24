package com.wes.myssm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wes.myssm.entity.Book;
import com.wes.myssm.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/returnBook")
	public ModelAndView returnBook(@RequestParam("no") String no, @RequestParam("name") String name){
		System.out.println("in bookController");
		
		ModelAndView mv = new ModelAndView("bookSystem");
		mv.addObject("no", no);
		mv.addObject("name", name);
		
		List<Book> books = bookService.queryAllBook();
		
		mv.addObject("books", books);
		
		return mv;
	}
	
	@RequestMapping("/appointment")
	public ModelAndView appointmentBook(@RequestParam("bookId") List<String> bookId) {
		System.out.println("in appointment");
		
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
}
