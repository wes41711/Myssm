package com.wes.myssm.entity;

public class Book {
	private String bookId;// 圖書ID

	private String bName;// 圖書名稱

	private int bNumber;// 館藏數量

	/**
	 * 
	 */
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bookId
	 * @param bName
	 * @param bNumber
	 */
	public Book(String bookId, String bName, int bNumber) {
		super();
		this.bookId = bookId;
		this.bName = bName;
		this.bNumber = bNumber;
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
	 * @return the bName
	 */
	public String getbName() {
		return bName;
	}

	/**
	 * @param bName the bName to set
	 */
	public void setbName(String bName) {
		this.bName = bName;
	}

	/**
	 * @return the bNumber
	 */
	public int getbNumber() {
		return bNumber;
	}

	/**
	 * @param bNumber the bNumber to set
	 */
	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bName=" + bName + ", bNumber=" + bNumber + "]";
	}

}
