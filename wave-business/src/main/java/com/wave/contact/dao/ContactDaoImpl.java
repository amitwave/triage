package com.wave.contact.dao;


import com.wave.address.AddressData;
import com.wave.contact.ContactData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class ContactDaoImpl extends AbstractDao<AddressData> implements ContactDao {

    @Override
    public ContactData getContactData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
         Query query = entityManager.createNamedQuery(ContactData.FIND_CONTACT_BY_ID);
        query.setParameter("id", id);
        return (ContactData) query.getResultList().get(0);
    }

    @Override
    @Transactional
    public void saveContactData(ContactData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
