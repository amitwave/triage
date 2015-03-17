package com.wave.locality;

import com.wave.locality.dao.LocalityData;

public interface LocalityService {

    public LocalityData getLocalityData(Long id);
    public void saveLocalityData(LocalityData itemData);
}
