package com.sibentek.consumer.ejb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<C> implements BaseDao<C> {

    private static final long serialVersionUID = -3849916011537202461L;

    @PersistenceContext(unitName = "ConsumerPU")
    private EntityManager entityManager;
    private Class<C> entityClass;

    @Override
    public C find(Long id) {
        return this.entityManager.find(getEntityClass(), id);
    }

    @Override
    public Collection<C> findAll(String instruction) {
        TypedQuery<C> query = this.entityManager.createQuery(instruction, getEntityClass());
        return query.getResultList();
    }

    @Override
    public void update(Long id, Consumer[] updates) {
        Arrays.stream(updates).forEach(up -> up.accept(find(id)));
    }

    @Override
    public void save(C entity) {
        this.entityManager.persist(entity);
    }

    @Override
    public void remove(Long id) {
        this.entityManager.remove(find(id));
    }

    @Override
    public TypedQuery<C> createCustomQuery(String query, Object... params) {
        TypedQuery<C> sql = entityManager.createQuery(query, getEntityClass());

        for (int i = 1; i <= params.length; i++) {
            sql.setParameter(i, params[i]);
        }

        return sql;
    }

    public Class<C> getEntityClass() {
        if (entityClass == null) {
            //only works if one extends BaseDao, we will take care of it with CDI
            entityClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return entityClass;
    }

    public void setEntityClass(Class<C> entityClass) {
        this.entityClass = entityClass;
    }
}
