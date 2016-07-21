package com.agfa.sh.cris.dbtool.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.agfa.sh.cris.dbtool.domain.SimplePatient;

public interface SimplePatientRepository extends Repository<SimplePatient, String>{
	
	@Query(value="SELECT op.id, op.p_patient_id,　op.p_name, op.p_pinyin, op.p_gender_code, op.p_birthdate, op.p_inpatient_id, op.p_outpatient_id, op.p_visitcard_id, op.p_physicalchk_id FROM act_obs_patient op, act_obs o WHERE op.id = o.id AND o.availabilitytime >= ?1 AND o.availabilitytime  < ?2 ", nativeQuery=true)
	List<SimplePatient> findSimplePatientInfosWithinOneday(Timestamp start, Timestamp end);
	
	@Query(value="select min(availabilitytime) from act_obs", nativeQuery=true)
	Timestamp findMinStartPoint();

}
