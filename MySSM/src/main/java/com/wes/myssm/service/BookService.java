package com.wes.myssm.service;

import java.util.List;

import com.wes.myssm.entity.Appointment;
import com.wes.myssm.entity.Book;

public interface BookService {
	public List<Book> queryAllBook();
	public List<Appointment> queryAppointmentById(String s);
	public boolean insertAppoint(List<Appointment> app);
	public boolean deleteAppointments(List<String> s);
}
