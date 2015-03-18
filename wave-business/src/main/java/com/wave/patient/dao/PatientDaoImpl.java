package com.wave.patient.dao;


import com.wave.name.NameData;
import com.wave.patient.PatientData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class PatientDaoImpl extends AbstractDao<PatientData> implements PatientDao {

    @Override
    public PatientData getPatientData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
         Query query = entityManager.createNamedQuery(PatientData.FIND_PATIENT_BY_ID);
        query.setParameter("id", id);
        return (PatientData) query.getResultList().get(0);
    }

    @Override
    @Transactional
    public void savePatientData(PatientData itemData) {
        if(null == itemData.getId()) {
            save(itemData);
        }else{
            update(itemData);
        }
        entityManager.flush();
        entityManager.flush();
    }
}
