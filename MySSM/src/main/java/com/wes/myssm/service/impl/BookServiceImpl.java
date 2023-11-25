package com.wes.myssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wes.myssm.bean.JavaMail;
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
	
	@Autowired
    private ArrayList<Appointment> appointments;
	

	public List<Book> queryAllBook() {
		List<Book> Books = bookDao.queryAllBook();
		return Books;
	}

	public List<Appointment> queryAppointmentById(String s) {
		List<Appointment> appointments = appointmentDao.queryById(s);
		return appointments;
	}

	public boolean insertAppoint(Appointment app) {
		String apps[] = app.getBookId().split(",");
		
		for(String s : apps) {
			app.setBookId(s);
			appointments.add(app);
		}
		
		return appointmentDao.insertManyAppointment(appointments);
	}

	public List<Appointment> deleteAppointments(List<String> a) {
		// TODO Auto-generated method stub
		return null;
	}

}
