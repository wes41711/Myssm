package com.wes.myssm.dao;

import java.util.List;

import com.wes.myssm.entity.Teacher;

public interface TeacherDao {
	public Teacher queryById(String s);
	public List<Teacher> queryAll();
	public boolean insertTeacher(Teacher t);
	public boolean updateTeacher(Teacher t);
	public boolean deleteTeacher(String s);
}
