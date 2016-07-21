package com.agfa.sh.cris.dbtool.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="act_obs_visit")
public class SimpleVisit implements Serializable{

	private static final long serialVersionUID = -3744423046217303201L;
	
	@Id
	@Column(name = "id", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@Column(name = "v_visit_number")
	private String visitNumber;
	
	@Column(name = "v_patient_class_code")
	private String patientClass;
	
	@Column(name = "v_pointofcare_code")
	private String nurseStation;
	
	@Column(name = "v_room_number")
	private String room;
	
	@Column(name = "v_bed_number")
	private String bed;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
