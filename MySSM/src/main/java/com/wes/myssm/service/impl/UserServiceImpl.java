package com.wes.myssm.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	private Object obj;
	
	public Object checkId(String id, String pwd) {
		
		String idFirst[] = id.split("");
		
		if(idFirst[0].equals("T")) {
			Teacher t = teacherDao.queryById(id);
			return t;
		}else if(idFirst[0].equals("A")) {
			Student s = studentDao.queryById(id);
			return s;
		}
		
//		if(userPassword.equals(sysUser.getUserPassword())
//				|| convertMD5(userPassword).equals(sysUser.getUserPassword())) {
//			message = "Sign in suceesfully!";
//			loginMessage = "Congratulations!";
//			sysUser.setPassword(md5(sysUser.getPassword()));
		
		return obj;
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
