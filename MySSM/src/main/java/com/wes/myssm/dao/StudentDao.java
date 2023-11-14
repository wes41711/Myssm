package com.wes.myssm.dao;

import java.util.List;

import com.wes.myssm.entity.Student;

public interface StudentDao {
	Student queryById(String s);
	List<Student> queryAll();
	boolean insertStudent(Student student);
	boolean updateStudent(Student s);
	boolean deleteStudent(String s);
}
