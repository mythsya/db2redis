package com.agfa.sh.cris.dbtool.web;

import java.util.Date;

import com.agfa.he.sh.common.util.DateUtil;
import com.agfa.sh.cris.dbtool.service.SimplePatientVisit;
import com.fasterxml.jackson.annotation.JsonView;

public class PatinfoJson {
	public static interface WithJsonView{}
	
	@JsonView(WithJsonView.class)
	public String id;
	
	@JsonView(WithJsonView.class)
	public String patientId;

	@JsonView(WithJsonView.class)
	public String name;
	
	@JsonView(WithJsonView.class)
	public String pinyin;
	
	@JsonView(WithJsonView.class)
	public String gender;
	
	@JsonView(WithJsonView.class)
	public String birthdate;
	
	@JsonView(WithJsonView.class)
	public String inpId;

	@JsonView(WithJsonView.class)
	public String outpId;

	@JsonView(WithJsonView.class)
	public String visitcardId;

	@JsonView(WithJsonView.class)
	public String physicalChkId;	
	
	@JsonView(WithJsonView.class)
	public String visitNumber;
	
	@JsonView(WithJsonView.class)
	public String patientClass;
	
	@JsonView(WithJsonView.class)
	public String nurseStation;
	
	@JsonView(WithJsonView.class)
	public String room;
	
	@JsonView(WithJsonView.class)
	public String bed;
	
	@JsonView(WithJsonView.class)
	public String accessionNumber;
	
	public PatinfoJson() {	
	}
	
	public PatinfoJson(SimplePatientVisit p) {
		this.id = p.getId();
		this.patientId = p.getPatientId();
		this.name = p.getName();
		this.pinyin = null2Empty(p.getPinyin());
		this.gender = null2Empty(p.getGender());
		this.birthdate = fmtDate(p.getBirthdate());
		this.inpId = null2Empty(p.getInpId());
		this.outpId = null2Empty(p.getOutpId());
		this.visitcardId = null2Empty(p.getVisitcardId());
		this.physicalChkId = null2Empty(p.getPhysicalChkId());
		this.visitNumber = null2Empty(p.getVisitNumber());
		this.patientClass = null2Empty(p.getPatientClass());
		this.nurseStation = null2Empty(p.getNurseStation());
		this.room = null2Empty(p.getRoom());
		this.bed = null2Empty(p.getBed());
		this.accessionNumber = null2Empty(p.getAccessionNumber());
	}
	
	private String null2Empty(String v) {
		return v== null ? "" : v;
	}

	private String fmtDate(Date dt) {
		return dt == null? "" : DateUtil.format(dt, DateUtil.DATE_FORMAT_YYYYMMDD);
	}
}
