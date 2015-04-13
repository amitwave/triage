package com.wave.master.service.title;

import com.wave.master.TitleData;
import com.wave.master.dao.title.TitleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleServiceImpl implements TitleService{
	
	@Autowired
	TitleDao titleDao;
	
	@Override
	public TitleData getTitleData(Long id){
		return titleDao.getTitleData(id);
	}
	
	@Override
    public List<TitleData> getAllTitleData(){
    	return titleDao.getAllTitleData();
    }
}