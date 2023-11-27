package com.wes.myssm.dao;

import java.util.List;

import com.wes.myssm.entity.Book;

public interface BookDao {
	
	public Book queryById(String id);

	public List<Book> queryAllBook();
	
	public int updateManyBook(List<Book> a);

	public void insertBook(Book b);
	
	public int updateBook(Book b);
	
	public void deleteBook(long b);
	
}
