package com.wes.myssm.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.wes.myssm.entity.Student;
import com.wes.myssm.entity.Teacher;

public class User {
	private String no; //id
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bday;
	private Integer sex;
	private String mail;
	private String pwd;
	private String cpwd;
	
	
	
    public static User createUserByNo(String no, User user) {
        if ("T".equals(no)) {
            Teacher teacher = new Teacher();
            teacher.setNo(user.no);
            teacher.setName(user.name);
            teacher.setBday(user.bday);
            teacher.setSex(user.sex);
            teacher.setMail(user.mail);
            teacher.setPwd(user.pwd);
            teacher.setCpwd(user.cpwd);
            return teacher;
        } else if ("A".equals(no)) {
        	 Student student = new Student();
             student.setNo(user.no);
             student.setName(user.name);
             student.setBday(user.bday);
             student.setSex(user.sex);
             student.setMail(user.mail);
             student.setPwd(user.pwd);
             student.setCpwd(user.cpwd);
             return student;
        }
        return null;
    }
	
	
	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the bday
	 */
	public Date getBday() {
		return bday;
	}
	/**
	 * @param bday the bday to set
	 */
	public void setBday(Date bday) {
		this.bday = bday;
	}
	/**
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the cpwd
	 */
	public String getCpwd() {
		return cpwd;
	}
	/**
	 * @param cpwd the cpwd to set
	 */
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", bday=" + bday + ", sex=" + sex + ", mail=" + mail + ", pwd="
				+ pwd + ", cpwd=" + cpwd + "]";
	}
	
}
