package com.wave.master.service;


import com.wave.master.TitleData;

import java.util.List;

public interface TitleService{
	public TitleData getTitleData(Long id);
    public List<TitleData> getAllTitleData();
}