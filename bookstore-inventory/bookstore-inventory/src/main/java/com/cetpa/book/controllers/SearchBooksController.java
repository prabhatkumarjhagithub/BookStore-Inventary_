package com.cetpa.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
@RequestMapping("bookstore/inventory/search")
public class SearchBooksController 
{
	@Autowired private BookService bservice;
	@Autowired private CategoryService cservice;
	@Autowired private PublisherService pservice;
	
	@RequestMapping("/books")
	public String getSearchBooksView(Model model)
	{
		List<BookCategory> list1=cservice.getList();
		List<BookPublisher> list2=pservice.getList();
		model.addAttribute("clist",list1);
		model.addAttribute("plist",list2);
		return "search/search-books";
	}
	@RequestMapping("/searchby/category")
	public String getBooksByCategory(int cid,Model model)
	{
		List<Book> list=bservice.getBookListByCategory(cid);
		model.addAttribute("blist",list);
		model.addAttribute("by","Category");
		return "search/search-book-list";
	}
	@RequestMapping("/searchby/publisher")
	public String getBooksByPublisher(int pid,Model model)
	{
		List<Book> list=bservice.getBookListByPublisher(pid);
		model.addAttribute("blist",list);
		model.addAttribute("by","Publisher");
		return "search/search-book-list";
	}
	@RequestMapping("/searchby/author")
	public String getBooksByAuthor(String author,Model model)
	{
		List<Book> list=bservice.getBookListByAuthor(author);
		model.addAttribute("blist",list);
		model.addAttribute("by","Author");
		return "search/search-book-list";
	}
	@RequestMapping("/searchby/title")
	public String getBooksByTitle(String title,Model model)
	{
		List<Book> list=bservice.getBookListByTitle(title);
		model.addAttribute("blist",list);
		model.addAttribute("by","Title");
		return "search/search-book-list";
	}
	@RequestMapping("/searchby/bookid")
	public String getBooksByBookid(int bid,Model model)
	{
		List<Book> list=bservice.getBookListByBookid(bid);
		model.addAttribute("blist",list);
		model.addAttribute("by","Bookid");
		return "search/search-book-list";
	}
	@RequestMapping("remove")
	public String removeBook(int bid,Model model)
	{
		bservice.deleteBook(bid);
		return "redirect:books";
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
		return "redirect:books";
	}
}
