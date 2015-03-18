package com.wave.role;


import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class RoleDaoImpl extends AbstractDao<RoleData> implements RoleDao {

    @Override
    public RoleData getRoleData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
        Query query = entityManager.createNamedQuery(RoleData.FIND_ROLE_BY_ID);
        query.setParameter("id", id);
        return (RoleData) query.getResultList().get(0);
    }

    @Override
    @Transactional
    public void saveRoleData(RoleData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
