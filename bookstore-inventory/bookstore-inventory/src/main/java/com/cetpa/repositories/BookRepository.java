package com.cetpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.models.Book;

public interface BookRepository extends JpaRepository<Book,Integer> 
{
	List<Book> findByCatid(int cid);
	List<Book> findByPubid(int pid);
	List<Book> findByAuthor(String author);
	List<Book> findByTitle(String title);
	List<Book> findByBookid(int bid);
}
