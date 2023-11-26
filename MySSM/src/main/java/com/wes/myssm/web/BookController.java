package com.wes.myssm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ModelAndView returnBook(@RequestParam("no") String no, @RequestParam("name") String name){
		System.out.println("in bookController");
		
		ModelAndView mv = new ModelAndView("bookSystem");
		mv.addObject("no", no);
		mv.addObject("name", name);
		
		List<Book> books = bookService.queryAllBook();
		List<Appointment> appointments = bookService.queryAppointmentById(no);
		
		mv.addObject("books", books);
		mv.addObject("appointments", appointments);
		
		return mv;
	}
	
	@RequestMapping("/appointment")
	@ResponseBody
	public List<Appointment> appointmentBook(@ModelAttribute("appointmentsWrapper") AppointmentWrapper appointmentsWrapper, @RequestParam("no") String no) {
	    System.out.println("in appointment");
	    
	    bookService.insertAppoint(appointmentsWrapper.getAppointments());
	    
	    List<Appointment> resultAppointments = bookService.queryAppointmentById(no);
	    
	    
	    return resultAppointments;
	}
}
