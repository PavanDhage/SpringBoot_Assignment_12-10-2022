package com.gl.SpringAssignment12102022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.SpringAssignment12102022.bean.CompanyShare;

@Repository
public interface ShareRepository extends JpaRepository<CompanyShare, Long>{
	@Query("select max(companyId) from CompanyShare")
	public Long findMaxCourseId();
}
