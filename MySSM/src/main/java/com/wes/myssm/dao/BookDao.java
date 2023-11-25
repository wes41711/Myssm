package com.wes.myssm.dao;

import java.util.List;

import com.wes.myssm.entity.Book;

public interface BookDao {
	
	/**
	 * 通过ID查询單本圖書
	 * 
	 * @param id
	 * @return
	 */
	public Book queryById(String id);

	/**
	 * 查詢所有圖書
	 * 
	 * @param offset 查詢起始位置
	 * @param limit 查询條數
	 * @return
	 */
	public List<Book> queryAllBook();

	public void insertBook(Book b);
	
	public void updateBook(Book b);
	
	public void deleteBook(long b);
	
	/**
	 * 减少馆藏数量
	 * 
	 * @param bookId
	 * @return 如果影响行数等于>1，表示更新的记录行数
	 */
	public int reduceNumber(long bookId);
}
