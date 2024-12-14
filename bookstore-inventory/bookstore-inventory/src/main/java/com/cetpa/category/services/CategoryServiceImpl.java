package com.cetpa.category.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.BookCategory;
import com.cetpa.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService 
{
	@Autowired
	private CategoryRepository repo;

	public List<BookCategory> getList() 
	{
		return repo.findAll();
	}
	public void saveCategory(BookCategory cat) 
	{
		repo.save(cat);
	}
	public void deleteCategory(int cid) 
	{
		repo.deleteById(cid);
	}
	public BookCategory getCategory(int cid) 
	{
		return repo.findById(cid).orElse(null);
	}
	
}
