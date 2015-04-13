package com.wave.role.dao;


import com.wave.role.RoleData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class RoleDaoImpl extends AbstractDao<RoleData> implements RoleDao {

    @Override
    public RoleData getRoleData(Long id) {

        Query query = entityManager.createNamedQuery(RoleData.FIND_ROLE_BY_ID);
        query.setParameter("id", id);
        return (RoleData) query.getResultList().get(0);
    }

    @Override
    public List<RoleData> getAllRoles() {
        Query query = entityManager.createNamedQuery(RoleData.FIND_ALL_ROLES);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveRoleData(RoleData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
