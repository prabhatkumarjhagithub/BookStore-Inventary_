package com.cetpa.publisher.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.BookCategory;
import com.cetpa.models.BookPublisher;
import com.cetpa.publisher.services.PublisherService;

@Controller
@RequestMapping("bookstore/inventory/publisher")
public class PublisherController 
{
	@Autowired
	private PublisherService service;
	
	@RequestMapping("manage")
	public String getPublisherList(Model model)
	{
		List<BookPublisher> list=service.getList();
		model.addAttribute("plist",list);
		return "publisher/publisher-list";
	}
	@RequestMapping("add")
	public String getAddView()
	{
		return "publisher/add-publisher";
	}
	@RequestMapping("save")
	public String savePublisher(BookPublisher pub)
	{
		service.savePublisher(pub);
		return "redirect:manage";
	}
	@RequestMapping("remove")
	public String removePublisher(int pid)
	{
		service.deletePublisher(pid);
		return "redirect:manage";
	}
	@RequestMapping("edit")
	public String editPublisher(int pid,Model model)
	{
		BookPublisher pub=service.getPublisher(pid);
		model.addAttribute("pub",pub);
		return "publisher/edit-publisher";
	}
	@RequestMapping("update")
	public String updatePublisher(BookPublisher pub)
	{
		service.savePublisher(pub);
		return "redirect:manage";
	}
}
