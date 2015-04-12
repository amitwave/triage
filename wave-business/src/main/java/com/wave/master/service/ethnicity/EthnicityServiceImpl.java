package com.wave.master.service.ethnicity;

import com.wave.master.EthnicityData;
import com.wave.master.TitleData;
import com.wave.master.dao.ethnicity.EthnicityDao;
import com.wave.master.dao.title.TitleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EthnicityServiceImpl implements EthnicityService {
	
	@Autowired
	EthnicityDao ethnicityDao;
	
	@Override
	public EthnicityData getEthnicityData(Long id){
		return ethnicityDao.getEthnicityData(id);
	}
	
	@Override
    public List<EthnicityData> getAllEthnicityData(){
    	return ethnicityDao.getAllEthnicityData();
    }
}