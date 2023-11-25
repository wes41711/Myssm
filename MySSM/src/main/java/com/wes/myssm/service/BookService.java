package com.wes.myssm.service;

import java.util.List;

import com.wes.myssm.entity.Appointment;
import com.wes.myssm.entity.Book;

public interface BookService {
	public List<Book> queryAllBook();
	public List<Appointment> queryAppointmentById(String s);
	public boolean insertAppoint(Appointment app);
	public List<Appointment> deleteAppointments(List<String> a);
}
