package com.cetpa.publisher.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.BookPublisher;
import com.cetpa.repositories.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService 
{
	@Autowired
	private PublisherRepository repo;

	public List<BookPublisher> getList() 
	{
		return repo.findAll();
	}
	public void savePublisher(BookPublisher pub) 
	{
		repo.save(pub);
	}
	public void deletePublisher(int pid) 
	{
		repo.deleteById(pid);
	}
	public BookPublisher getPublisher(int pid) 
	{
		return repo.findById(pid).orElse(null);
	}
	
}
