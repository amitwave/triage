package com.wave.master.dao.ethnicity;

import com.wave.master.EthnicityData;
import com.wave.master.TitleData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EthnicityDaoImpl extends AbstractDao<EthnicityData> implements EthnicityDao {

    @Override
    public EthnicityData getEthnicityData(Long id){
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        Query query = entityManager.createNamedQuery(EthnicityData.FIND_ETHNICITY_BY_ID);
        query.setParameter("id", id);
        return (EthnicityData) query.getResultList().get(0);
    }

    @Override
    public List<EthnicityData> getAllEthnicityData(){
        Query query = entityManager.createNamedQuery(EthnicityData.GET_ALL_ETHNICITY);
        return query.getResultList();
    }
}