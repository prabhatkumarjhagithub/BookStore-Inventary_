package com.cetpa.publisher.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cetpa.models.BookPublisher;

@Service
public interface PublisherService 
{
	List<BookPublisher> getList();
	void savePublisher(BookPublisher pub);
	void deletePublisher(int pid);
	BookPublisher getPublisher(int pid);
}
