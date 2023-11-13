package com.wes.myssm.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wes.myssm.BaseTest;
import com.wes.myssm.entity.Appointment;

public class AppointmentDaoTest extends BaseTest {

	@Autowired
	private AppointmentDao appointmentDao;
	
	
	@Test
	public void testInsertTest() throws Exception {
		System.out.println("進入insert");
		appointmentDao.insertTest();
	}
	
	
	@Test
	public void testQuertById() throws Exception {
		System.out.println("進入qyeryById");
//		Appointment a = appointmentDao.queryById(2);
//		System.out.println(a);
	}
	
	@Test
	public void testInsertAppointment() throws Exception {
		long bookId = 1000;
		long studentId = 12345678910L;
		int insert = appointmentDao.insertAppointment(bookId, studentId);
		System.out.println("insert=" + insert);
	}

	@Test
	public void testQueryByKeyWithBook() throws Exception {
		long bookId = 1000;
		long studentId = 12345678910L;
		Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
		System.out.println(appointment);
		System.out.println(appointment.getBook());
	}
}
