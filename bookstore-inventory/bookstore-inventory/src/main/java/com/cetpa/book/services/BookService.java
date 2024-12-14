package com.cetpa.book.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cetpa.models.Book;

@Service
public interface BookService 
{
	Page<Book> getList(int pn); 
	void saveBook(Book book);
	void deleteBook(int bid);
	Book getBook(int bid);
	List<Book> getBookListByCategory(int cid);
	List<Book> getBookListByPublisher(int pid);
	List<Book> getBookListByAuthor(String author);
	List<Book> getBookListByTitle(String title);
	List<Book> getBookListByBookid(int bid);
}
