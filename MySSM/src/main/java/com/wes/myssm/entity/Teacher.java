package com.wes.myssm.entity;

import java.util.List;

import com.wes.myssm.bean.User;

public class Teacher extends User {
	
	private List<Student> student;

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
	    return "Teacher[" + super.toString() + "], students=" + student;
	}

	

}
