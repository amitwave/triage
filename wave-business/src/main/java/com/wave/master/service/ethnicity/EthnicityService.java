package com.wave.master.service.ethnicity;


import com.wave.master.EthnicityData;
import com.wave.master.TitleData;

import java.util.List;

public interface EthnicityService {
    public EthnicityData getEthnicityData(Long id);
    public List<EthnicityData> getAllEthnicityData();
}