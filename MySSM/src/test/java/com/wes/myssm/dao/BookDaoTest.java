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
	public void testInsertBook()throws Exception {
		bookDao.insertBook();
	}
	

	@Test
	public void testQueryById() throws Exception {
		System.out.println("1---------------");
		long bookId = 1003;
		Book book = bookDao.queryById(bookId);
		System.out.println(book);
	}

	@Test
	public void testQueryAll() throws Exception {
		System.out.println("2---------------");
		List<Book> books = bookDao.queryAll(0, 4);
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void testReduceNumber() throws Exception {
		System.out.println("3---------------");
		long bookId = 1000;
		int update = bookDao.reduceNumber(bookId);
		System.out.println("update=" + update);
	}
}
