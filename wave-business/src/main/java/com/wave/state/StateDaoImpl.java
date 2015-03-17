package com.wave.state;



import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class StateDaoImpl extends AbstractDao<StateData> implements StateDao {

    @Override
    public StateData getStateData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
        Query query = entityManager.createNamedQuery(StateData.FIND_STATE_BY_ID);
        query.setParameter("id", id);
        return (StateData) query.getResultList().get(0);
    }

    @Override
    public void saveStateData(StateData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
