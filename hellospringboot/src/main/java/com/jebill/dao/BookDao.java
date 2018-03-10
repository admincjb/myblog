package com.jebill.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jebill.entity.*;


/**
 * @project 图书接口，用来增删改查图书信息
 * @timer   2018-03-08 17:21
 * @author  JeBillChen
 *
 */
public interface BookDao extends JpaRepository<Book, Integer> {
	
//	public Book findAllBook();
	
//	public void insert(Book book);
//	
//	public Book findOneById(Integer id);
//	
//	public void update(Book book);
//	
//	public void delete(Integer id);

}
