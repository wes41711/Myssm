package com.wes.myssm.entity;

import java.util.Date;

public class Student {
	private String sno; //id
	private String sname;
	private Date sbday;
	private Integer ssex;
	private String smail;
	private String spwd;
	private Teacher tno; //fk

	/**
	 * 
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param sno
	 * @param sname
	 * @param sbday
	 * @param ssex
	 * @param smail
	 * @param spwd
	 * @param tno
	 */
	public Student(String sno, String sname, Date sbday, Integer ssex, String smail, String spwd, Teacher tno) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sbday = sbday;
		this.ssex = ssex;
		this.smail = smail;
		this.spwd = spwd;
		this.tno = tno;
	}

	/**
	 * @return the sno
	 */
	public String getSno() {
		return sno;
	}

	/**
	 * @param sno the sno to set
	 */
	public void setSno(String sno) {
		this.sno = sno;
	}

	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * @return the sbday
	 */
	public Date getSbday() {
		return sbday;
	}

	/**
	 * @param sbday the sbday to set
	 */
	public void setSbday(Date sbday) {
		this.sbday = sbday;
	}

	/**
	 * @return the ssex
	 */
	public Integer getSsex() {
		return ssex;
	}

	/**
	 * @param ssex the ssex to set
	 */
	public void setSsex(Integer ssex) {
		this.ssex = ssex;
	}

	/**
	 * @return the smail
	 */
	public String getSmail() {
		return smail;
	}

	/**
	 * @param smail the smail to set
	 */
	public void setSmail(String smail) {
		this.smail = smail;
	}

	/**
	 * @return the spwd
	 */
	public String getSpwd() {
		return spwd;
	}

	/**
	 * @param spwd the spwd to set
	 */
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	/**
	 * @return the tno
	 */
	public Teacher getTno() {
		return tno;
	}

	/**
	 * @param tno the tno to set
	 */
	public void setTno(Teacher tno) {
		this.tno = tno;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sbday=" + sbday + ", ssex=" + ssex + ", smail=" + smail
				+ ", spwd=" + spwd + ", tno=" + tno + "]";
	}

}
