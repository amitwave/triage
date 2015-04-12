package com.wave.master.service.title;


import com.wave.master.TitleData;

import java.util.List;

public interface TitleService{
	public TitleData getTitleData(Long id);
    public List<TitleData> getAllTitleData();
}