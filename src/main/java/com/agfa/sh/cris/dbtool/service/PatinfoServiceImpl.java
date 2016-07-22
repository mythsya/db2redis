package com.agfa.sh.cris.dbtool.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.agfa.he.sh.common.util.DateUtil;
import com.agfa.sh.cris.dbtool.AppConstants;

@Component
public class PatinfoServiceImpl implements PatinfoService {

	private final static Logger logger = LoggerFactory.getLogger(PatinfoServiceImpl.class);
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	public SimplePatientVisit get(String pid) {
		String prefix = "pat:"+pid+":";
		if (isKeyExists(prefix+"pid")) {
			SimplePatientVisit pv = new SimplePatientVisit();
			pv.setId(getValue(prefix+"id"));
			pv.setPatientId(getValue(prefix+"pid"));
			pv.setName(getValue(prefix+"name"));
			pv.setPinyin(getValue(prefix+"py"));
			pv.setGender(getValue(prefix+"sex"));
			pv.setBirthdate(DateUtil.parse(getValue(prefix+"bhd"),DateUtil.DATE_FORMAT_YYYYMMDD));
			pv.setInpId(getValue(prefix+"inpid"));
			pv.setOutpId(getValue(prefix+"outpid"));
			pv.setVisitcardId(getValue(prefix+"vcid"));
			pv.setPhysicalChkId(getValue(prefix+"phid"));
			pv.setVisitNumber(getValue(prefix+"vno"));
			pv.setPatientClass(getValue(prefix+"pcls"));
			pv.setNurseStation(getValue(prefix+"nsst"));
			pv.setRoom(getValue(prefix+"room"));
			pv.setBed(getValue(prefix+"bed"));
			
			return pv;
			
		} else {
			return null;
		}
	}
	
	public SimplePatientVisit random() {
		int total = (int) getPatientCount();
		if (total > 0) {
			Random rnd = new Random();
			int idx = rnd.nextInt(total)+1; // [1, total]
			String key = "pat:"+idx;
			if (logger.isInfoEnabled()) {
				logger.info("random patient index -> "+idx);
			}
			if (isKeyExists(key)) {
				String pid =getValue(key);
				if (logger.isInfoEnabled()) {
					logger.info("random patient id -> "+pid);
				}
				return get(pid);
			}
		}
		return null;		
	}
	
	private long getPatientCount() {
		String st = getValue(AppConstants.KEY_PATIENT_COUNT);
		if (st == null || st.isEmpty()) {
			return 0L;
		}
		return Long.parseLong(st);
	}

	
	private boolean isKeyExists(String key) {
		return stringRedisTemplate.hasKey(key);
	}
	
	private String getValue(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}
}
