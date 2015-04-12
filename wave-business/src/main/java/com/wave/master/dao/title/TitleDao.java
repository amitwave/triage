package com.wave.master.dao.title;

import com.wave.master.TitleData;

import java.util.List;

public interface TitleDao {

    public TitleData getTitleData(Long id);
    public List<TitleData> getAllTitleData();
    
}
