package com.wes.myssm.entity;

import java.util.Date;
import java.util.List;

import com.wes.myssm.bean.User;

public class Teacher extends User {
	private String no; //Id
	private String name;
	private Date bday;
	private Integer sex;
	private String mail;
	private String pwd;
	
	private List<Student> student;

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
	 * @return the student
	 */
	public List<Student> getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Teacher [no=" + no + ", name=" + name + ", bday=" + bday + ", sex=" + sex + ", mail=" + mail + ", pwd="
				+ pwd + ", student=" + student + "]";
	}

	

}
