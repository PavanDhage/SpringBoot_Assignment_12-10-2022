package com.gl.SpringAssignment12102022.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.SpringAssignment12102022.bean.CompanyShare;
import com.gl.SpringAssignment12102022.repository.ShareRepository;


@Service
public class ShareService {
	@Autowired
	private ShareRepository repository;
	
	public void save(CompanyShare companyShare) {
		repository.save(companyShare);
	}
	
	public List<CompanyShare> findAll(){
		return repository.findAll();
	}
	
	public CompanyShare findById(Long id){
		return repository.getById(id);
	}
	
	public Long generateCompanyId(){
		Long val=  repository.findMaxCourseId();
		if(val == null)
			val=100L;
		else
			val=val+1;
		return val;
	}
	
	public void deleteCompany(Long id) {
		repository.deleteById(id);
	}
}
