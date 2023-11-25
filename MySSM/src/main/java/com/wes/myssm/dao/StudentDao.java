package com.wes.myssm.dao;

import java.util.List;

import com.wes.myssm.entity.Student;

public interface StudentDao {
	public Student queryById(String s);
	public List<Student> queryAll();
	public boolean insertStudent(Student student);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(String s);
}
