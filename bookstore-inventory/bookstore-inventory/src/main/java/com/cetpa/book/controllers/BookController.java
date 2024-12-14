package com.cetpa.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.book.services.BookService;
import com.cetpa.category.services.CategoryService;
import com.cetpa.models.Book;
import com.cetpa.models.BookCategory;
import com.cetpa.models.BookPublisher;
import com.cetpa.publisher.services.PublisherService;

@Controller
@RequestMapping("bookstore/inventory/books")
public class BookController 
{
	@Autowired private BookService bservice;
	@Autowired private CategoryService cservice;
	@Autowired private PublisherService pservice;
	
	@RequestMapping("manage")
	public String getBookList(Model model,int pn)
	{
		Page<Book> plist=bservice.getList(pn-1);
		List<Book> list=plist.toList();
		model.addAttribute("tp",plist.getTotalPages());
		model.addAttribute("pn",pn);
		model.addAttribute("blist",list);
		return "book/book-list";
	}
	@RequestMapping("add")
	public String getAddView(Model model)
	{
		List<BookCategory> list1=cservice.getList();
		List<BookPublisher> list2=pservice.getList();
		model.addAttribute("clist",list1);
		model.addAttribute("plist",list2);
		return "book/add-book";
	}
	@RequestMapping("save")
	public String saveBook(Book book)
	{
		//bservice.show();
		bservice.saveBook(book);
		return "redirect:manage?pn=1";
	}
	@RequestMapping("remove")
	public String removeBook(int bid)
	{
		bservice.deleteBook(bid);
		return "redirect:manage?pn=1";
	}
	@RequestMapping("edit")
	public String editBook(int bid,Model model)
	{
		Book book=bservice.getBook(bid);
		model.addAttribute("book",book);
		List<BookCategory> list1=cservice.getList();
		List<BookPublisher> list2=pservice.getList();
		model.addAttribute("clist",list1);
		model.addAttribute("plist",list2);
		return "book/edit-book";
	}
	@RequestMapping("update")
	public String updateBook(Book book)
	{
		bservice.saveBook(book);
		return "redirect:manage?pn=1";
	}
}
