package com.agfa.sh.cris.dbtool.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.agfa.sh.cris.dbtool.domain.SimpleVisit;

public interface SimpleVisitRepository extends Repository<SimpleVisit, String>{

	@Query(value="select v from SimpleVisit v where v.id = ?1 ")
	SimpleVisit get(String id);
	
}
