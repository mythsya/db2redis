package com.agfa.sh.cris.dbtool.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.agfa.he.sh.common.util.DateUtil;
import com.agfa.sh.cris.dbtool.AppConstants;
import com.agfa.sh.cris.dbtool.domain.SimplePatient;


@Component
public class DataTransferServiceImpl implements DataTransferService{
	
	private final static Logger logger = LoggerFactory.getLogger(DataTransferServiceImpl.class);
	
	@Autowired
	private SimplePatientRepository simplePatientRepository; 
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Scheduled(cron="0/5 * * * * ?")
	@Override
	public void transfer() {
		String startstr = getCurrentStartPoint();
		Timestamp start= DateUtil.parse(startstr, DateUtil.DATE_FORMAT_YYYY_MM_DD);
		Timestamp end= DateUtil.addDays(start, 1);		
		String ends = DateUtil.format(end, DateUtil.DATE_FORMAT_YYYY_MM_DD);
		if (logger.isInfoEnabled()) {
			logger.info("=======================================================================================");
			logger.info("parameters : start => "+startstr+" , end => "+ends);
		}
		List<SimplePatient> pinfos = simplePatientRepository.findSimplePatientInfosWithinOneday(start, end);
		int total = pinfos.size();
		long patientCount = getPatientCount();
		if (total > 0) {
			try {
				for(SimplePatient pat : pinfos) {
					String prefix = "pat:"+pat.getPatientId()+":";
					if (!isKeyExists(prefix+"id")) { 
						setKeyValue("pat:"+patientCount, pat.getPatientId());
						setKeyValue(prefix+"id", pat.getId());
						setKeyValue(prefix+"idx", String.valueOf(patientCount));
						setKeyValue(prefix+"pid", pat.getPatientId());
						setKeyValue(prefix+"name", pat.getName());
						setKeyValue(prefix+"py", pat.getPinyin());
						setKeyValue(prefix+"sex", pat.getGender());
						setKeyValue(prefix+"bhd", DateUtil.format(pat.getBirthdate(), DateUtil.DATE_FORMAT_YYYYMMDD));
						setKeyValue(prefix+"inpid", pat.getInpId());
						setKeyValue(prefix+"outpid", pat.getOutpId());
						setKeyValue(prefix+"vcid", pat.getVisitcardId());
						
						patientCount ++;
					}
				}
			} finally {
				updateRedisPatientCount(patientCount);
			}
			updateRedisStartPoint(end);
		} else {
			Date now = DateUtil.getDateCurrent();
			if (DateUtil.getDaysBetween(start, now) <= 1) {
				updateRedisStartPoint(DateUtil.addDays(start, -1));
			} else {
				updateRedisStartPoint(end);
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("retrieved "+total+" patients!");
		}
	}
	
	private boolean isKeyExists(String key) {
		return stringRedisTemplate.hasKey(key);
	}
	
	private void setKeyValue(String key, String val) {
		if (key!=null && !key.isEmpty() && val != null && !val.isEmpty()) {
			stringRedisTemplate.opsForValue().set(key, val);
		}
	}
	
	private String getValue(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}
	
	private String getCurrentStartPoint() {
		String st = getValue(AppConstants.KEY_PATIENT_SYNC_TS);
		if (st == null || st.isEmpty()) {
			Timestamp min = simplePatientRepository.findMinStartPoint();
			st = DateUtil.format(min, DateUtil.DATE_FORMAT_YYYY_MM_DD);
		}
		return st;
	}
	
	private long getPatientCount() {
		String st = getValue(AppConstants.KEY_PATIENT_COUNT);
		if (st == null || st.isEmpty()) {
			return 1L;
		}
		return Long.parseLong(st);
	}
	
	private void updateRedisStartPoint(Timestamp ts) {
		setKeyValue(AppConstants.KEY_PATIENT_SYNC_TS, DateUtil.format(ts, DateUtil.DATE_FORMAT_YYYY_MM_DD));
	}
	
	private void updateRedisPatientCount(long cnt) {
		setKeyValue(AppConstants.KEY_PATIENT_COUNT, String.valueOf(cnt));
	}

}
