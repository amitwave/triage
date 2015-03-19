package com.wave.user.dao;


import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional(readOnly = true)
public class UserDaoImpl extends AbstractDao<UserData> implements UserDao {


    public UserData getUserData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
         Query query = entityManager.createNamedQuery(UserData.FIND_BY_USER_ID);
        query.setParameter("id", id);
        return (UserData) query.getResultList().get(0);
    }

    public UserData getUserByUserName(String name) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
        Query query = entityManager.createNamedQuery(UserData.FIND_BY_USER_NAME);
        query.setParameter("name", name);
        List resultList = query.getResultList();
        if(resultList.size() > 0) {
            return (UserData) resultList.get(0);
        }else{
            return null;
        }

    }


    @Transactional
    public void saveUserData(UserData userData) {
        entityManager.persist(userData);
    }
}
