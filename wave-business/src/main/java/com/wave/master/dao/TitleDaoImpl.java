package com.wave.master.dao;

import com.wave.master.TitleData;
import com.wave.master.dao.TitleDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TitleDaoImpl implements TitleDao{
	
	@Override
	public TitleData getTitleData(Long id){
		 Map<String, Long> params = new HashMap<String, Long>();
	     params.put("id", id);
	     Query query = entityManager.createNamedQuery(TitleData.FIND_TITLE_BY_ID);
	     query.setParameter("id", id);
	     return (TitleData) query.getResultList().get(0);
	}
	
	@Override
    public List<TitleData> getAllTitleData(){
		Query query = entityManager.createNamedQuery(ReferralData.GET_ALL_TITLE);
        return query.getResultList();
    }
}