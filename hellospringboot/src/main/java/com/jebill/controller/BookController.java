package com.jebill.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jebill.dao.BookDao;
import com.jebill.entity.Book;

/**
 * @project  Book控制器层
 * @author   JeBillChen
 * @timer    2018-03-08 17:40
 */

@Controller
@RequestMapping("/book-sys")
public class BookController {
	
	@Resource
	private BookDao bookDao;
	
	@RequestMapping(value="/list")
	public ModelAndView bookList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("bookList", bookDao.findAll());
		mav.setViewName("allbook");
		return mav;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String insert(Book book) {
		bookDao.save(book);
		return "redirect:/book-sys/list";
	}
	
	@RequestMapping(value="/preUpdate")
	public ModelAndView preUpdate(Integer ID) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("bookOne", bookDao.getOne(ID));
		mav.setViewName("bookUpdate");
		return mav;
	}
	
	@RequestMapping(value="/update")
	public String update(Book book) {
		bookDao.save(book);
		return "redirect:/book-sys/list";
	}
	
//	@RequestMapping(value="/delete", method=RequestMethod.POST)
	/**
	 * method=RequestMethod.POST会报错：请求方式GET不支持POST
	 * @param		ID
	 * @return		String
	 */
	@RequestMapping(value="/delete")
	public String delete(Integer ID) {
		bookDao.delete(ID);
		return "redirect:/book-sys/list";
	}

}
