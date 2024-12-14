package com.cetpa.category.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cetpa.models.BookCategory;

@Service
public interface CategoryService 
{
	List<BookCategory> getList();
	void saveCategory(BookCategory cat);
	void deleteCategory(int cid);
	BookCategory getCategory(int cid);
}
