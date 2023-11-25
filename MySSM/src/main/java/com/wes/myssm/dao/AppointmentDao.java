package com.wes.myssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wes.myssm.entity.Appointment;

public interface AppointmentDao {

	public List<Appointment> queryById(String pka);
	
	public List<Appointment> queryAll();
	
	public boolean insertAppointment(Appointment a);
	
	public boolean insertManyAppointment(List<Appointment> a);
	
	public boolean updateAppointment(Appointment a);
	
	public boolean deleteAppointment(String s);
	
	public boolean deleteManyAppointment(List<String> s);
	
	/**
	 * 插入預约圖書紀錄
	 * 
	 * @param bookId
	 * @param studentId
	 * @return 插入的行数
	 */
	
	public int insertAppointmentTest(@Param("bookId") long bookId, @Param("studentId") long studentId);

	/**
	 * 通过主键查询预约图书记录，并且携带图书实体
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	public Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);

}
