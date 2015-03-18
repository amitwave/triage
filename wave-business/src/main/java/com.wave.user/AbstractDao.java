package com.wave.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AbstractDao<E> {


    private Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;



    public Class<E> getEntityClass() {
        return entityClass;
    }

    public E findById(Object id) {
        return entityManager.find(entityClass, id);
    }

    public E newInstance() throws IllegalAccessException, InstantiationException {
        return entityClass.newInstance();
    }

    public void insert(E entity) {
        entityManager.persist(entity);
    }

    public void update(E entity) {
        entityManager.merge(entity);
    }


    public void save(E entity) {
        entityManager.persist(entity);
    }

    public void delete(E entity) {
        entityManager.remove(entity);
    }

    public List<E> findAll() {
        return entityManager.createQuery( "from " + entityClass.getName() )
                .getResultList();
    }



    /**
     * Returns the first item of a list or null if the list is empty
     */
    protected Object first(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

/*
    protected List findUsingSql(final String sql) {
        return findUsingSql(sql, getEntityClass());
    }

    protected List findUsingSql(final String sql) {
        return getJpaTemplate().executeFind(new JpaCallback() {
            public Object doInJpa(EntityManager entityManager) throws PersistenceException {
                return entityManager.createNativeQuery(sql).getResultList();
            }
        });
    }

    protected List findUsingSql(final String sql, final Class returnType) {
        return getJpaTemplate().executeFind(new JpaCallback() {
            public Object doInJpa(EntityManager entityManager) throws PersistenceException {
                return entityManager.createNativeQuery(sql, returnType).getResultList();
            }
        });
    }

    protected List findUsingSql(final String sql, final String resultSetMapping) {
        return getJpaTemplate().executeFind(new JpaCallback() {
            public Object doInJpa(EntityManager entityManager) throws PersistenceException {
                return entityManager.createNativeQuery(sql, resultSetMapping).getResultList();
            }
        });
    }

*/



}
