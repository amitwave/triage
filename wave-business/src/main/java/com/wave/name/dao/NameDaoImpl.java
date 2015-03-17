package com.wave.name.dao;


import com.wave.address.AddressData;
import com.wave.contact.ContactData;
import com.wave.name.NameData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class NameDaoImpl extends AbstractDao<NameData> implements NameDao {

    @Override
    public NameData getNameData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
         Query query = entityManager.createNamedQuery(NameData.FIND_NAME_BY_ID);
        query.setParameter("id", id);
        return (NameData) query.getResultList().get(0);
    }

    @Override
    public void saveNameData(NameData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
