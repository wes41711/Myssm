package com.wes.myssm.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

public class Appointment {
	private String pka; // PK

	private String bookId;// 圖書ID

	private String noId;// 學號
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date appointDate;// 預約時間

	private Book book;// 一對一

	/**
	 * 
	 */
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pka
	 * @param bookId
	 * @param noId
	 * @param appointDate
	 * @param book
	 */
	public Appointment(String pka, String bookId, String noId, Date appointDate, Book book) {
		super();
		this.pka = pka;
		this.bookId = bookId;
		this.noId = noId;
		this.appointDate = appointDate;
		this.book = book;
	}

	/**
	 * @return the pka
	 */
	public String getPka() {
		return pka;
	}

	/**
	 * @param pka the pka to set
	 */
	public void setPka(String pka) {
		this.pka = pka;
	}

	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the noId
	 */
	public String getNoId() {
		return noId;
	}

	/**
	 * @param noId the noId to set
	 */
	public void setNoId(String noId) {
		this.noId = noId;
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
		return "Appointment [pka=" + pka + ", bookId=" + bookId + ", noId=" + noId + ", appointDate=" + appointDate
				+ ", book=" + book + "]";
	}

}
