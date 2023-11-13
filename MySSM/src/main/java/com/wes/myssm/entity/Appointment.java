package com.wes.myssm.entity;

import java.util.Date;

import javax.persistence.Column;

public class Appointment {
	private long pka; // PK

	private long bookId;// 圖書ID

	private long studentId;// 學號

	@Column(name = "APPOINT_DATE")
	private Date appointDate;// 預約時間

	// 多對一
	private Book book;

	/**
	 * @return the pka
	 */
	public long getPka() {
		return pka;
	}

	/**
	 * @param pka the pka to set
	 */
	public void setPka(long pka) {
		this.pka = pka;
	}

	/**
	 * @return the bookId
	 */
	public long getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the studentId
	 */
	public long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the appointDate
	 */
	public Date getAppointDate() {
		return appointDate;
	}

	/**
	 * @param appointDate the appointDate to set
	 */
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Appointment [pka=" + pka + ", bookId=" + bookId + ", studentId=" + studentId + ", appointDate="
				+ appointDate + ", book=" + book + "]";
	}

}
