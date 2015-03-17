package com.wave.locality;


import com.wave.locality.dao.LocalityDao;
import com.wave.locality.dao.LocalityData;

public class LocalityServiceImpl implements LocalityService {

    private LocalityDao localityDao;

    @Override
    public LocalityData getLocalityData(Long id) {
        return localityDao.getLocalityData(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveLocalityData(LocalityData itemData) {
        localityDao.saveLocalityData(itemData);
    }
}
