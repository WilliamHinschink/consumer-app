package com.sibentek.consumer.ejb.dao;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Collection;
import java.util.function.Consumer;

public interface BaseDao<T> extends Serializable {

    T find(Long id);

    Collection<T> findAll(String instruction);

    void update(Long id, Consumer<T>... updates);

    void save(T entity);

    void remove(Long id);

    TypedQuery<T> createCustomQuery(String query, Object... params);
}
