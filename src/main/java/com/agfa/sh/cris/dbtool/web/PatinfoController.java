package com.agfa.sh.cris.dbtool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agfa.sh.cris.dbtool.service.PatinfoService;
import com.agfa.sh.cris.dbtool.service.SimplePatientVisit;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class PatinfoController {

	@Autowired
	private PatinfoService patinfoService;
	
	@RequestMapping("/patient")
	@JsonView(PatinfoJson.WithJsonView.class)
	public PatinfoJson getPatInfo(@RequestParam(name="pid", required=true) String pid) {
		SimplePatientVisit pv = patinfoService.get(pid);
		PatinfoJson json = new PatinfoJson();
		if (pv != null) {
			json = new PatinfoJson(pv);
		}
		return json;	
	}
	
	@RequestMapping("/patient/random")
	@JsonView(PatinfoJson.WithJsonView.class)
	public PatinfoJson randomPatInfo() {
		SimplePatientVisit pv = patinfoService.random();
		if (pv == null) {
			pv = patinfoService.random();
		}
		PatinfoJson json = new PatinfoJson();
		if (pv != null) {
			json = new PatinfoJson(pv);
		}
		return json;
	}
}
