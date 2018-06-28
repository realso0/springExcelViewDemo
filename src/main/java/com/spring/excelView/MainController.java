package com.spring.excelView;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/excel")
	public String viewHome(){
		return "home";
	}
	
	
	@RequestMapping("/downExcel")
	public ModelAndView downExcel(){
		List<Book> listBooks = new ArrayList<Book>();
		
		listBooks.add(new Book("스프링 프레임웍", "김말똥", "000001", "2012-05-21", 32000));
		listBooks.add(new Book("자바 기초", "김개똥", "000002", "2015-05-21", 20000));
		listBooks.add(new Book("자바 네트워킹", "이말똥", "000003", "2013-05-21", 35000));
		listBooks.add(new Book("스트럿츠", "고말똥", "000004", "2012-08-21", 24000));
		listBooks.add(new Book("자바 패턴", "홍말똥", "000005", "2011-11-21",22000));
		
		return new ModelAndView("excelView", "BookLists", listBooks);
		
	}
}
