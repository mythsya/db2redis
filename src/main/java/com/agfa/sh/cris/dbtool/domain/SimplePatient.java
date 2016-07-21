package com.agfa.sh.cris.dbtool.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="act_obs_patient")
public class SimplePatient implements Serializable{

	private static final long serialVersionUID = -5477156984657089389L;

	@Id
	@Column(name = "id", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name = "p_patient_id")
	private String patientId;

	@Column(name = "p_name")
	private String name;
	
	@Column(name = "p_pinyin")
	private String pinyin;
	
	@Column(name = "p_gender_code")
	private String gender;
	
	@Column(name = "p_birthdate")
	private Timestamp birthdate;
	
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

	@Column(name = "p_inpatient_id")
	private String inpId;
	
	@Column(name = "p_outpatient_id")
	private String outpId;
	
	@Column(name = "p_visitcard_id")
	private String visitcardId;
	
	@Column(name = "p_physicalchk_id")
	private String physicalChkId;
	
}
