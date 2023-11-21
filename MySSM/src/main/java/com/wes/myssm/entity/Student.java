package com.wes.myssm.entity;

import com.wes.myssm.bean.User;

public class Student extends User {

	private Teacher teacher; //fk


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

	@Override
	public String toString() {
		return "Student[" + super.toString() + "], teacher=" + teacher;
	}


	

}
