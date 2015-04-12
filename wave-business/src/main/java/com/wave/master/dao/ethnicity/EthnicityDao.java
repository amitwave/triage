package com.wave.master.dao.ethnicity;

import com.wave.master.EthnicityData;
import com.wave.master.TitleData;

import java.util.List;

public interface EthnicityDao {

    public EthnicityData getEthnicityData(Long id);
    public List<EthnicityData> getAllEthnicityData();
    
}
