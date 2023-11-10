package com.wes.myssm.entity;

public class Book {
	private long bookId;// 圖書ID

	private String bName;// 圖書名稱

	private int bNumber;// 館藏數量

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
