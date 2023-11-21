package com.wes.myssm.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wes.myssm.bean.User;
import com.wes.myssm.dao.StudentDao;
import com.wes.myssm.dao.TeacherDao;
import com.wes.myssm.entity.Student;
import com.wes.myssm.entity.Teacher;
import com.wes.myssm.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private StudentDao studentDao;
	
	private User user;
	
	public String createId(String id) {
		
		String no = "";
		int num = 0;
		
		if(id.equalsIgnoreCase("T")) {
			
			List<Teacher> teachers = teacherDao.queryAll();
			num = teachers.size();
			num++;
			if(num < 10) {
				no = "T00" + num;
			}
			else if(num < 100) {
				no = "T0" + num;
			}
		}else{
			List<Student> students = studentDao.queryAll();
			num = students.size();
			num++;
			if(num < 10) {
				no = "A0" + num;
			}
			else{
				no = "A" + num;
			}
		}
		return no;
	}
	
	public User checkIdRole(String id, String pwd) {
		
		String idFirst[] = id.split("");

		if(idFirst[0].equals("T")) {
			Teacher t = teacherDao.queryById(id);
			user = t;
		}else if(idFirst[0].equals("A")) {
			Student s = studentDao.queryById(id);
			user = s;
		}
		
		if (user != null) {
			user.setCpwd(md5(user.getCpwd()));
		
			if(pwd.equals(user.getCpwd())){
				return user;
			}
		}
		return null;
	}
	
	public boolean creatAccount(User user) {
		
		 String idFirst[] = user.getNo().split("");
		 boolean re = false;
		 
		 user.setPwd(convertMD5(user.getPwd()));
		 user.setCpwd(md5(user.getCpwd()));
		 
		 User userType = User.createUserByNo(idFirst[0],user);

		 if (userType instanceof Teacher) {
			 System.out.println("Teacher");
			 Teacher teacher = (Teacher) userType;
			 re = teacherDao.insertTeacher(teacher);
		 }
		 else if(userType instanceof Student) {
			 System.out.println("Student");
			 Student student = (Student) userType;
			 re = studentDao.insertStudent(student);
		    }

		 return re;
	}
	

	public static String convertMD5(String password) {

		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
		// 如果生成数字未满32位，需要前面补0
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		
		return md5code;

	}

	public static String md5(String inStr) {

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;

	}
	
}
