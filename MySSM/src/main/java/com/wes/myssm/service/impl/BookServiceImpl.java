package com.wes.myssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wes.myssm.dao.BookDao;
import com.wes.myssm.entity.Book;
import com.wes.myssm.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	public List<Book> queryAllBook() {
		List<Book> Books = bookDao.queryAllBook();
		return Books;
	}

}
