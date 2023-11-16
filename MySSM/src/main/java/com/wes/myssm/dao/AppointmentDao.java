package com.wes.myssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wes.myssm.entity.Appointment;

public interface AppointmentDao {

	Appointment queryById(String pka);
	
	List<Appointment> queryAll();
	
	boolean insertAppointment(Appointment a);
	
	boolean updateAppointment(Appointment a);
	
	boolean deleteAppointment(String s);
	
	
	/**
	 * 插入預约圖書紀錄
	 * 
	 * @param bookId
	 * @param studentId
	 * @return 插入的行数
	 */
	
	int insertAppointmentTest(@Param("bookId") long bookId, @Param("studentId") long studentId);

	/**
	 * 通过主键查询预约图书记录，并且携带图书实体
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);

}
