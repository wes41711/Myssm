package com.wes.myssm.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wes.myssm.BaseTest;
import com.wes.myssm.entity.Student;
import com.wes.myssm.entity.Teacher;

public class TeacherDaoTest extends BaseTest {
	@Autowired
	private TeacherDao teacherDao;

	@Test
	public void testQueryById() throws Exception {
		System.out.println("1---------------");
		String tno = "T002";
		Teacher t =  teacherDao.queryById(tno);
		System.out.println("查詢結果為:" + t);
	}

//	@Test
//	public void testQueryAll() throws Exception {
//		System.out.println("2---------------");
//		List<Book> books = bookDao.queryAll(0, 4);
//		for (Book book : books) {
//			System.out.println(book);
//		}
//	}
//
//	@Test
//	public void testInsertStudent() throws Exception {
//		studentDao.insertStudent();
//	}
}
