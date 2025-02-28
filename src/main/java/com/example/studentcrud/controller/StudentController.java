package com.example.studentcrud.controller;

import java.util.List;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.studentcrud.domain.Student;
import com.example.studentcrud.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		List<Student> liststudent = service.listAll();
		model.addAttribute("liststudent", liststudent);
		System.out.println("Get / ");
		return "index";
	}
	@GetMapping("/new")
	public String add(Model model)
	{
		
		model.addAttribute("student", new Student());
		System.out.println("new / ");
		
		return "new";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student std )
	{
		service.save(std);
		System.out.println("save / ");
		return "redirect:/";
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id)
	{
		System.out.println("edit page / ");
		ModelAndView mav = new ModelAndView("new");
		Student std = service.get(id);
		mav.addObject("student",std);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deletestudent(@PathVariable(name = "id")  int id)
	{
		System.out.println("delete / ");
		service.delete(id);
		
		return "redirect:/";
	}
	

}
