package com.cetpa.category.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.category.services.CategoryService;
import com.cetpa.models.BookCategory;

@Controller
@RequestMapping("bookstore/inventory/category")
public class CategoryController 
{
	@Autowired
	private CategoryService service;
	
	@RequestMapping("manage")
	public String getCategoryList(Model model)
	{
		List<BookCategory> list=service.getList();
		model.addAttribute("clist",list);
		return "category/category-list";
	}
	@RequestMapping("add")
	public String getAddView()
	{
		return "category/add-category";
	}
	@RequestMapping("save")
	public String saveCategory(BookCategory cat)
	{
		service.saveCategory(cat);
		return "redirect:manage";
	}
	@RequestMapping("remove")
	public String removeCategory(int cid)
	{
		service.deleteCategory(cid);
		return "redirect:manage";
	}
	@RequestMapping("edit")
	public String editCategory(int cid,Model model)
	{
		BookCategory cat=service.getCategory(cid);
		model.addAttribute("cat",cat);
		return "category/edit-category";
	}
	@RequestMapping("update")
	public String updateCategory(BookCategory cat)
	{
		service.saveCategory(cat);
		return "redirect:manage";
	}
	@RequestMapping("details")
	public String showCategory(int cid,Model model)
	{
		BookCategory cat=service.getCategory(cid);
		model.addAttribute("cat",cat);
		return "category/category-details";
	}
}
