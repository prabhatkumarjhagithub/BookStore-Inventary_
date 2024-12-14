package com.cetpa.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cetpa.models.Book;
import com.cetpa.repositories.BookRepository;


@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
	private BookRepository repo;

	public Page<Book> getList(int pn) 
	{
		Pageable page=PageRequest.of(pn,3);
		return repo.findAll(page);
	}
	public void saveBook(Book book) 
	{
		repo.save(book);
	}	
	public void deleteBook(int bid)
	{
		repo.deleteById(bid);
	}
	public Book getBook(int bid)
	{
		return repo.findById(bid).orElse(null);
	}
	public List<Book> getBookListByCategory(int cid)
	{
		return repo.findByCatid(cid);
	}
	public List<Book> getBookListByPublisher(int pid)
	{
		return repo.findByPubid(pid);
	}
	public List<Book> getBookListByAuthor(String author)
	{
		return repo.findByAuthor(author);
	}
	public List<Book> getBookListByTitle(String title)
	{
		return repo.findByTitle(title);
	}
	public List<Book> getBookListByBookid(int bid)
	{
		return repo.findByBookid(bid);
	}
}
