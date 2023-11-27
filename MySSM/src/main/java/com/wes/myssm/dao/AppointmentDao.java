package com.wes.myssm.dao;

import java.util.List;

import com.wes.myssm.entity.Appointment;

public interface AppointmentDao {

	public List<Appointment> queryById(String noId);
	
	public List<Appointment> queryAll();
	
	public Appointment query(String pka);
	
	public boolean insertAppointment(Appointment a);
	
	public boolean insertManyAppointment(List<Appointment> a);
	
	public boolean updateAppointment(Appointment a);
	
	public boolean deleteAppointment(String s);
	
	public boolean deleteManyAppointment(List<String> s);

}
