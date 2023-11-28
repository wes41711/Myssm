package com.wes.myssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wes.myssm.bean.AppointmentWrapper;
import com.wes.myssm.entity.Appointment;
import com.wes.myssm.entity.Book;
import com.wes.myssm.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/returnBook")
	public ModelAndView returnBook(@RequestParam("no") String no, 
			@RequestParam("name") String name, @RequestParam("pwd") String pwd){
		System.out.println("in bookController");
		
		ModelAndView mv = new ModelAndView("bookSystem");
		mv.addObject("no", no);
		mv.addObject("name", name);
		mv.addObject("pwd", pwd);
		
		List<Book> books = bookService.queryAllBook();
		List<Appointment> appointments = bookService.queryAppointmentById(no);
		
		mv.addObject("books", books);
		mv.addObject("appointments", appointments);
		
		return mv;
	}
	
	@RequestMapping("/appointment")
	public ModelAndView appointmentBook(@ModelAttribute("appointmentsWrapper") AppointmentWrapper appointmentsWrapper,
			@RequestParam("no") String no, @RequestParam("name") String name, @RequestParam("pwd") String pwd) {
	    System.out.println("in appointment");
	    
	    bookService.insertAppoint(appointmentsWrapper.getAppointments());
	    
	    List<Book> books = bookService.queryAllBook();
		List<Appointment> appointments = bookService.queryAppointmentById(no);

	    ModelAndView mv = new ModelAndView("bookSystem");


	    mv.addObject("books", books);
		mv.addObject("appointments", appointments);
	    
	    mv.addObject("no", no);
		mv.addObject("name", name);
		mv.addObject("pwd", pwd);
		
	    return mv;
	}
	
	@RequestMapping("/deleteAppointment")
	public ModelAndView deleteAppointment(@RequestParam("pka") List<String> pka,
			@RequestParam("no") String no, @RequestParam("name") String name, @RequestParam("pwd") String pwd) {
		
		ModelAndView mv = new ModelAndView("bookSystem");
		mv.addObject("no", no);
		mv.addObject("name", name);
		mv.addObject("pwd", pwd);
		
		bookService.deleteAppointments(pka);
		
		List<Book> books = bookService.queryAllBook();
		List<Appointment> appointments = bookService.queryAppointmentById(no);
		
		mv.addObject("books", books);
		mv.addObject("appointments", appointments);
		return mv;
	}
	
}
