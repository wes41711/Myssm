package com.wes.myssm.service;

import com.wes.myssm.bean.User;
import com.wes.myssm.entity.Student;
import com.wes.myssm.entity.Teacher;

public interface UserService {
	
	public User checkIdRole(String id, String pwd);
	public String createId(String id);
	public boolean creatAccount(User user);
	public boolean checkIdMail(String id, String mail);
	public void resetPassword(Teacher teacher);
	public void resetPassword(Student student);
}
