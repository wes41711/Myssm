package com.wes.myssm.dao;



import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wes.myssm.BaseTest;
import com.wes.myssm.entity.Teacher;

public class TeacherDaoTest extends BaseTest {
	@Autowired
	private TeacherDao teacherDao;

	@Test
	public void testQueryById() throws Exception {
		System.out.println("1.查詢結果為:" + teacherDao.queryById("T002"));
	}

	@Test
	public void testQueryAll() throws Exception {
		System.out.println("2.查詢全部:");
		List<Teacher> teachers = teacherDao.queryAll();
		for (Teacher t : teachers) {
			System.out.println(t);
		}
	}

	@Test
	public void testInsertTeacher() throws Exception {
		Teacher teacher = new Teacher();
		teacher.setNo("T006");
		teacher.setName("張老師");
		Date currentDate = new Date();
		teacher.setBday(currentDate);//Date
		teacher.setSex(1);
		teacher.setMail("jao41711@gmail.com");
		teacher.setPwd("123456789");
		System.out.println("3.新增結果為:" + teacherDao.insertTeacher(teacher));
	}
	
	@Test
	public void testUpdateTeacher() throws Exception {
		Teacher teacher = new Teacher();
		teacher.setNo("T006");
		teacher.setName("楊老師");
		Date currentDate = new Date();
		teacher.setBday(currentDate);//Date
		teacher.setSex(0);
		teacher.setMail("jao41711@gmail.com");
		teacher.setPwd("123456789");
		System.out.println("4.修改結果為:" + teacherDao.updateTeacher(teacher));
	}
	
	@Test
	public void testDeleteTeacher() throws Exception{
		System.out.println("5.刪除結果為:" + teacherDao.deleteTeacher("T006"));
	}
}
