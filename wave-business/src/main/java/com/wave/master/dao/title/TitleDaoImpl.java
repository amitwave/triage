package com.wave.master.dao.title;

import com.wave.master.TitleData;

import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TitleDaoImpl  extends AbstractDao<TitleData> implements TitleDao{

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
        Query query = entityManager.createNamedQuery(TitleData.GET_ALL_TITLE);
        return query.getResultList();
    }
}