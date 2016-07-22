package com.agfa.sh.cris.dbtool.service;

import java.io.Serializable;
import java.sql.Timestamp;

import com.agfa.sh.cris.dbtool.domain.SimplePatient;
import com.agfa.sh.cris.dbtool.domain.SimpleVisit;
import com.fasterxml.jackson.annotation.JsonView;

public class SimplePatientVisit implements Serializable{

	private static final long serialVersionUID = 1898541696524827564L;
	
	private String id;
	
	private String patientId;

	private String name;
	
	private String pinyin;
	
	private String gender;
	
	private Timestamp birthdate;
	
	private String inpId;

	private String outpId;

	private String visitcardId;

	private String physicalChkId;	
	
	private String visitNumber;
	
	private String patientClass;
	
	private String nurseStation;
	
	private String room;
	
	private String bed;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}

	public String getInpId() {
		return inpId;
	}

	public void setInpId(String inpId) {
		this.inpId = inpId;
	}

	public String getOutpId() {
		return outpId;
	}

	public void setOutpId(String outpId) {
		this.outpId = outpId;
	}

	public String getVisitcardId() {
		return visitcardId;
	}

	public void setVisitcardId(String visitcardId) {
		this.visitcardId = visitcardId;
	}

	public String getPhysicalChkId() {
		return physicalChkId;
	}

	public void setPhysicalChkId(String physicalChkId) {
		this.physicalChkId = physicalChkId;
	}

	public String getVisitNumber() {
		return visitNumber;
	}

	public void setVisitNumber(String visitNumber) {
		this.visitNumber = visitNumber;
	}

	public String getPatientClass() {
		return patientClass;
	}

	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
	}

	public String getNurseStation() {
		return nurseStation;
	}

	public void setNurseStation(String nurseStation) {
		this.nurseStation = nurseStation;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}


	public SimplePatientVisit() {		
	}
	
	public SimplePatientVisit(SimplePatient p, SimpleVisit v) {
		this.id = p.getId();
		this.patientId = p.getPatientId();
		this.name = p.getName();
		this.pinyin = p.getPinyin();
		this.gender = p.getGender();
		this.birthdate = p.getBirthdate();
		this.inpId = p.getInpId();
		this.outpId = p.getOutpId();
		this.visitcardId = p.getVisitcardId();
		this.physicalChkId = p.getPhysicalChkId();
		this.visitNumber = v.getVisitNumber();
		this.patientClass = v.getPatientClass();
		this.nurseStation = v.getNurseStation();
		this.room = v.getRoom();
		this.bed = v.getBed();		
	}
	
	public SimplePatientVisit(String id, String pid, String pname, String py, String psex, Timestamp pbirth, String pinpid, String poutpid, String pvcid, String pcid, String visitnumber, String vpatcls, String vnursest, String vroom, String vbed) {
		this.id = id;
		this.patientId = pid;
		this.name = pname;
		this.pinyin = py;
		this.gender = psex;
		this.birthdate = pbirth;
		this.inpId = pinpid;
		this.outpId = poutpid;
		this.visitcardId = pvcid;
		this.physicalChkId = pcid;
		this.visitNumber = visitnumber;
		this.patientClass = vpatcls;
		this.nurseStation = vnursest;
		this.room = vroom;
		this.bed = vbed;
	}
	
	public SimplePatientVisit(Object[] values) {
		this(
			(String)values[0],
			(String)values[1],
			(String)values[2],
			(String)values[3],
			(String)values[4],
			(Timestamp)values[5],
			(String)values[6],
			(String)values[7],
			(String)values[8],
			(String)values[9],
			(String)values[10],
			(String)values[11],
			(String)values[12],
			(String)values[13],
			(String)values[14]
		);
	}
}
