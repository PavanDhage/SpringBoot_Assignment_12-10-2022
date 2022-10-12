package com.gl.SpringAssignment12102022.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.SpringAssignment12102022.bean.CompanyShare;
import com.gl.SpringAssignment12102022.service.ShareService;


@RestController
public class ShareController {
	@Autowired
	private ShareService service;
	
	@GetMapping("/index")
	public ModelAndView showIndexPage() {
	ModelAndView mv=new ModelAndView("index");
	List<CompanyShare> companyList=service.findAll();
	mv.addObject("companyList",companyList);
	return mv;
	}
	@GetMapping("/enlist-company")
	public ModelAndView showCompanyEnlistPage() {
		CompanyShare company = new CompanyShare();
		ModelAndView mv = new ModelAndView("CompanyEnlist");
		mv.addObject("companyRecord",company);
		return mv;
	}
	
	@PostMapping("/company")
	public ModelAndView saveNewCompany(@ModelAttribute("companyRecord") CompanyShare company) {
		Long id = service.generateCompanyId();
		company.setCompanyId(id);
		service.save(company);
		return new ModelAndView("redirect:/index");
	}
	
	
	@GetMapping("/delete-company/{id}")
	public ModelAndView deleteACompanys(@PathVariable long id) {
		service.deleteCompany(id);
		return new ModelAndView("redirect:/index");
	}
	
	@GetMapping("/edit-sharePrice/{id}")
	public ModelAndView showCourseEditPage(@PathVariable long id) {
		CompanyShare company=service.findById(id);
		ModelAndView mv=new ModelAndView("CompanyEditSharePage");
		mv.addObject("companyRecord",company);
		return mv;
	}
	
	@PostMapping("/edit-sharePrice/company")
	public ModelAndView editCompany(@ModelAttribute("courseRecord") CompanyShare company) {
		service.save(company);
		return new ModelAndView("redirect:/index");
	}
}
