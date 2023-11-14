package com.wes.myssm.entity;

import java.util.Date;
import java.util.List;

public class Teacher {
	private String tno; //Id
	private String tname;
	private Date tbday;
	private Integer tsex;
	private String tmail;
	private String tpwd;
	
	private List<Student> student;

	/**
	 * 
	 */
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param tno
	 * @param tname
	 * @param tbday
	 * @param tsex
	 * @param tmail
	 * @param tpwd
	 * @param student
	 */
	public Teacher(String tno, String tname, Date tbday, Integer tsex, String tmail, String tpwd,
			List<Student> student) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.tbday = tbday;
		this.tsex = tsex;
		this.tmail = tmail;
		this.tpwd = tpwd;
		this.student = student;
	}

	/**
	 * @return the tno
	 */
	public String getTno() {
		return tno;
	}

	/**
	 * @param tno the tno to set
	 */
	public void setTno(String tno) {
		this.tno = tno;
	}

	/**
	 * @return the tname
	 */
	public String getTname() {
		return tname;
	}

	/**
	 * @param tname the tname to set
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}

	/**
	 * @return the tbday
	 */
	public Date getTbday() {
		return tbday;
	}

	/**
	 * @param tbday the tbday to set
	 */
	public void setTbday(Date tbday) {
		this.tbday = tbday;
	}

	/**
	 * @return the tsex
	 */
	public Integer getTsex() {
		return tsex;
	}

	/**
	 * @param tsex the tsex to set
	 */
	public void setTsex(Integer tsex) {
		this.tsex = tsex;
	}

	/**
	 * @return the tmail
	 */
	public String getTmail() {
		return tmail;
	}

	/**
	 * @param tmail the tmail to set
	 */
	public void setTmail(String tmail) {
		this.tmail = tmail;
	}

	/**
	 * @return the tpwd
	 */
	public String getTpwd() {
		return tpwd;
	}

	/**
	 * @param tpwd the tpwd to set
	 */
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
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
		return "Teacher [tno=" + tno + ", tname=" + tname + ", tbday=" + tbday + ", tsex=" + tsex + ", tmail=" + tmail
				+ ", tpwd=" + tpwd + ", student=" + student + "]";
	}

}
