package com.agfa.sh.cris.dbtool.service;

public interface PatinfoService {

	SimplePatientVisit get(String pid);
	
	SimplePatientVisit random();
}
