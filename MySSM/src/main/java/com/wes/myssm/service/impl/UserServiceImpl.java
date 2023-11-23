package com.wes.myssm.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wes.myssm.bean.JavaMail;
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
	
	private JavaMail javaMail;
	
	@Autowired
    public void setJavaMail(JavaMail javaMail) {
        this.javaMail = javaMail;
        javaMail.setUserName("techLink1020@gmail.com");
        javaMail.setPassword("wndtsglmwieswvms");
        javaMail.setSubject("密碼信件");
    }
	
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
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		user.setFormatDate(dateFormat.format(user.getBday()));
		
		if (user != null) {
			user.setCpwd(md5(user.getCpwd()));
		
			if(pwd.equals(user.getCpwd()) && convertMD5(pwd).equals(user.getPwd())){
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
	
	public boolean checkIdMail(String id, String mail) {
		String idFirst[] = id.split("");

		if(idFirst[0].equals("T")) {
			Teacher teacher = teacherDao.queryById(id);

			if (teacher != null) {
				if(mail.equals(teacher.getMail())){
					resetPassword(teacher);

					return true;
				}
			}
		}else if(idFirst[0].equals("A")) {
			Student student = studentDao.queryById(id);
			
			if (student != null) {
				if(mail.equals(student.getMail())){
					resetPassword(student);
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void resetPassword(Teacher teacher) {
		teacher.setPwd(convertMD5(teacher.getNo()));
		teacher.setCpwd(md5(teacher.getNo()));
		teacherDao.updateTeacher(teacher);
		javaMail.setCustomer(teacher.getMail());
		javaMail.SendMail();
	}
	
	public void resetPassword(Student student) {
		student.setPwd(convertMD5(student.getNo()));
		student.setCpwd(md5(student.getNo()));
		studentDao.updateStudent(student);
		javaMail.setCustomer(student.getMail());
		javaMail.SendMail();
	}
	
	public String convertMD5(String password) {

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

	public String md5(String inStr) {

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;

	}


	
}
