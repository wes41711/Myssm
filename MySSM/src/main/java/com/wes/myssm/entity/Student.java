package com.wes.myssm.entity;

import java.util.Date;

import com.wes.myssm.bean.User;

public class Student extends User {

	private String no; // Id
	private String name;
	private Date bday;
	private Integer sex;
	private String mail;
	private String pwd;
	private Teacher teacher; // fk
	private String cpwd;

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
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
		return "Student [no=" + no + ", name=" + name + ", bday=" + bday + ", sex=" + sex + ", mail=" + mail + ", pwd="
				+ pwd + ", teacher=" + teacher + ", cpwd=" + cpwd + "]";
	}

}
