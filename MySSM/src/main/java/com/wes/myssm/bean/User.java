package com.wes.myssm.bean;

import java.util.Date;

public class User {
	private String no; //id
	private String name;
	private Date bday;
	private Integer sex;
	private String mail;
	private String pwd;
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
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", bday=" + bday + ", sex=" + sex + ", mail=" + mail + ", pwd="
				+ pwd + "]";
	}
	
	
}
