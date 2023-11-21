package com.wes.myssm.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wes.myssm.BaseTest;
import com.wes.myssm.entity.Book;

public class BookDaoTest extends BaseTest {
	@Autowired
	private BookDao bookDao;	

	@Test
	public void testQueryById() throws Exception {
		String bookId = "1003";
		System.out.println("查詢結果為:" + bookDao.queryById(bookId));
	}

	@Test
	public void testQueryAll() throws Exception {
		List<Book> books = bookDao.queryAllBook();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	@Test
	public void testInsertBook() throws Exception {
		Book book = new Book("1004", "自學的100種方法", 10);
		bookDao.insertBook(book);
	}
	
	@Test
	public void testUpdateBook() throws Exception{
		Book book = new Book("1004", "自學的200種方法", 10);
		bookDao.updateBook(book);
	}
	
	@Test
	public void testDeleteBook() throws Exception{
		bookDao.deleteBook(1004);
	}

	@Test
	public void testReduceNumber() throws Exception {
		System.out.println("3---------------");
		long bookId = 1000;
		int update = bookDao.reduceNumber(bookId);
		System.out.println("update=" + update);
	}
}
