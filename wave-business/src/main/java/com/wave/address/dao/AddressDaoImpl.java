package com.wave.address.dao;


import com.wave.address.AddressData;
import com.wave.city.dao.CityData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class AddressDaoImpl extends AbstractDao<AddressData> implements AddressDao {

    @Override
    public AddressData getAddressData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
         Query query = entityManager.createNamedQuery(AddressData.FIND_ADDRESS_BY_ID);
        query.setParameter("id", id);
        return (AddressData) query.getResultList().get(0);
    }

    @Override
    public void saveAddressData(AddressData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
