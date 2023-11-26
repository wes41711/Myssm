package com.wes.myssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.AttributeList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
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
	

	public List<Book> queryAllBook() {
		List<Book> Books = bookDao.queryAllBook();
		return Books;
	}

	public List<Appointment> queryAppointmentById(String s) {
		List<Appointment> appointments = appointmentDao.queryById(s);
		return appointments;
	}

	public boolean insertAppoint(List<Appointment> app) {
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		for(Appointment a : app) {
			if(a.getBookId() != null && !a.getBookId().isEmpty()) {
				a.setPka(a.getBookId() + a.getNoId());
				appointments.add(a);
			}
		}
		
		return appointmentDao.insertManyAppointment(appointments);
	}

	public List<Appointment> deleteAppointments(List<String> a) {
		// TODO Auto-generated method stub
		return null;
	}

}
