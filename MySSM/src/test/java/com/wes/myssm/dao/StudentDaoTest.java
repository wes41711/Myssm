package com.wes.myssm.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wes.myssm.BaseTest;
import com.wes.myssm.entity.Student;
import com.wes.myssm.entity.Teacher;

public class StudentDaoTest extends BaseTest {
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private TeacherDao teacherDao;

	@Test
	public void testQueryById() throws Exception {
		System.out.println("查詢結果為:" + studentDao.queryById("A02"));
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
		student.setSno("A08");
		student.setSname("楊大帥");
		Date currentDate = new Date();
		student.setSbday(currentDate); //Date
		student.setSmail("jao41711@gmail.com");
		student.setSsex(1);
		student.setSpwd("1234");
		student.setTno(teacher);
		System.out.println("新增結果為:" + studentDao.insertStudent(student));
	}
	
	@Test
	public void testUpdateStudent() throws Exception {
		Student student = new Student();
		Teacher teacher = teacherDao.queryById("T002");
		student.setSno("A08");
		student.setSname("楊大帥帥");
		Date currentDate = new Date();
		student.setSbday(currentDate); //Date
		student.setSmail("jao41711@gmail.com");
		student.setSsex(0);
		student.setSpwd("1234");
		student.setTno(teacher);
		System.out.println("修改結果為:" + studentDao.updateStudent(student));
	}
	
	@Test
	public void testDeleteStudent() throws Exception {
		System.out.println("刪除結果:" + studentDao.deleteStudent("A08"));
	}
}
