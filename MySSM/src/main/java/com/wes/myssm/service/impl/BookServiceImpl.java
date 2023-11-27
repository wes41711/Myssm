package com.wes.myssm.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wes.myssm.dao.AppointmentDao;
import com.wes.myssm.dao.BookDao;
import com.wes.myssm.entity.Appointment;
import com.wes.myssm.entity.Book;
import com.wes.myssm.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private AppointmentDao appointmentDao;
	
	
	public List<Book> queryAllBook() {
		return bookDao.queryAllBook();
	}

	public List<Appointment> queryAppointmentById(String s) {
		List<Appointment> appointments = appointmentDao.queryById(s);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		for(Appointment a : appointments) {
			a.setFormatDate(dateFormat.format(a.getAppointDate()));
		}
		
		return appointments;
	}

	public boolean insertAppoint(List<Appointment> app) {
		
		List<Appointment> appointments = new ArrayList<Appointment>();
		List<Book> books = new ArrayList<Book>();
		
		for(Appointment a : app) {
			if(a.getBookId() != null && !a.getBookId().isEmpty()) {
				a.setPka(a.getBookId() + a.getNoId());
				appointments.add(a);
				books.add(bookDao.queryById(a.getBookId()));
			}
		}
		
		for(Book b : books) {
			if(b.getbNumber() >= 0) {
				b.setbNumber(b.getbNumber()-1);
			}
			else {
				return false;
			}
		}
			
		if(bookDao.updateManyBook(books) != 0){
			return appointmentDao.insertManyAppointment(appointments);
		}
		
		return false;
	}

	public boolean deleteAppointments(List<String> s) {
		
		List<Book> books = new ArrayList<Book>();
		
		for(String string : s) {
			Book book = new Book();
			Appointment appointment = new Appointment();
			
			appointment = appointmentDao.query(string);
			
			book =	bookDao.queryById(appointment.getBookId());
			book.setbNumber(book.getbNumber()+1);
			books.add(book);
		}
		
		if(bookDao.updateManyBook(books) != 0){
			return appointmentDao.deleteManyAppointment(s);
		}
		
		return false;
	}



	

}
