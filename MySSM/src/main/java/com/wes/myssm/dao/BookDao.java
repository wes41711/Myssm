package com.wes.myssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wes.myssm.entity.Book;

public interface BookDao {
	
	void insertBook();
	
	/**
	 * 通过ID查询單本圖書
	 * 
	 * @param id
	 * @return
	 */
	Book queryById(long id);

	/**
	 * 查詢所有圖書
	 * 
	 * @param offset 查詢起始位置
	 * @param limit 查询條數
	 * @return
	 */
	List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

	/**
	 * 减少馆藏数量
	 * 
	 * @param bookId
	 * @return 如果影响行数等于>1，表示更新的记录行数
	 */
	int reduceNumber(long bookId);
}
