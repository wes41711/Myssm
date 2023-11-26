package com.wes.myssm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wes.myssm.BaseTest;
import com.wes.myssm.entity.Appointment;

public class AppointmentDaoTest extends BaseTest {

	@Autowired
	private AppointmentDao appointmentDao;
		
	@Test
	public void testQueryById() throws Exception {
		System.out.println(appointmentDao.queryById("T005"));
	}
	
	@Test
	public void testQueryAll() throws Exception {
		List<Appointment> appointments = appointmentDao.queryAll();
		for(Appointment a : appointments) {
			System.out.println(a);
		}
	}
		
	@Test
	public void testInsertAppointment() throws Exception {
		Date date = new Date();
		Appointment appointment = new Appointment("A011000", "1000", "A01", date, null);
		System.out.println("新增結果為:" + appointmentDao.insertAppointment(appointment));
	}
	
	@Test
	public void testUpdateAppointment() throws Exception{
		Date date = new Date();
		Appointment appointment = new Appointment("A011000", "1002", "T001", date, null);
		System.out.println("修改結果為:" + appointmentDao.updateAppointment(appointment));
	}
	
	@Test
	public void testDeleteAppointment() throws Exception{
		System.out.println("刪除結果為:" + appointmentDao.deleteAppointment("A011000"));
	}
	
	@Test
	public void testInsertManyAppointment() throws Exception{
		List<Appointment> appointments = new ArrayList<Appointment>();
		Appointment a = new Appointment();
		Appointment b = new Appointment();
		a.setPka("1");
		a.setBookId("1000");
		a.setNoId("T005");
		b.setPka("2");
		b.setBookId("1000");
		b.setNoId("T005");
		appointments.add(a);
		appointments.add(b);
		appointmentDao.insertManyAppointment(appointments);
	}
	
	@Test
	public void testInsertAppointmentTest() throws Exception {
		long bookId = 1000;
		long studentId = 12345678910L;
		int insert = appointmentDao.insertAppointmentTest(bookId, studentId);
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
