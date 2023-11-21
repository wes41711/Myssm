package com.wes.myssm.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wes.myssm.BaseTest;
import com.wes.myssm.bean.User;
import com.wes.myssm.entity.Student;
import com.wes.myssm.entity.Teacher;

public class StudentDaoTest extends BaseTest {
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Test
	public void Test() throws Exception{
		Student student = new Student();
		
		student.toString();
	}

	@Test
	public void testQueryById() throws Exception {
		System.out.println("查詢結果為:" + studentDao.queryById("A02"));
		
		User user = studentDao.queryById("A02");
		
		System.out.println();
		System.out.println("user:" + user);
		System.out.println("中斷點");
		Teacher teacher = (Teacher)user;
		System.out.println("teacher:"+teacher);
		
	}

	@Test
	public void testQueryAll() throws Exception {
		System.out.println("2---------------");
		List<Student> students = studentDao.queryAll();
		System.out.println("queryAll結果:");
		for (Student s : students) {
			System.out.println(s);
		}
	}

	@Test
	public void testInsertStudent() throws Exception {
		Student student = new Student();
		Teacher teacher = teacherDao.queryById("T001");
		student.setNo("A07");
		student.setName("楊大帥");
		Date currentDate = new Date();
		student.setBday(currentDate); //Date
		student.setMail("jao41711@gmail.com");
		student.setSex(1);
		student.setPwd("1234");
		student.setTeacher(teacher);
		System.out.println("新增結果為:" + studentDao.insertStudent(student));
	}
	
	@Test
	public void testUpdateStudent() throws Exception {
		Student student = new Student();
		Teacher teacher = teacherDao.queryById("T002");
		student.setNo("A06");
		student.setName("張大帥帥");
		Date currentDate = new Date();
		student.setBday(currentDate); //Date
		student.setMail("jao41711@gmail.com");
		student.setSex(0);
		student.setPwd("1234");
		student.setTeacher(teacher);
		System.out.println("修改結果為:" + studentDao.updateStudent(student));
	}
	
	@Test
	public void testDeleteStudent() throws Exception {
		System.out.println("刪除結果:" + studentDao.deleteStudent("A08"));
	}
}
