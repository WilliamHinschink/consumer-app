package com.sibentek.consumer.ejb.producer;

import com.sibentek.consumer.ejb.annotations.DAO;
import com.sibentek.consumer.ejb.dao.BaseDaoImpl;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionPoint;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericDaoProducer {

    @Produces
    @Dependent
    @DAO
    public <T> BaseDaoImpl<T> produce(InjectionPoint ip, BeanManager bm) {
        if (ip.getAnnotated().isAnnotationPresent(DAO.class)) {
            BaseDaoImpl<T> crudDao = (BaseDaoImpl<T>) this.getBeanByName("baseDaoImpl", bm);
            ParameterizedType type = (ParameterizedType) ip.getType();
            Type[] typeArgs = type.getActualTypeArguments();
            Class<T> entityClass = (Class<T>) typeArgs[0];
            crudDao.setEntityClass(entityClass);
            return crudDao;
        }
        throw new IllegalArgumentException("Annotation @Dao is required when injecting BaseDao");
    }

    public Object getBeanByName(String name, BeanManager bm) { // eg. name=availableCountryDao{
        Bean bean = bm.getBeans(name).iterator().next();
        CreationalContext ctx = bm.createCreationalContext(bean); // could be inlined below
        return bm.getReference(bean, bean.getBeanClass(), ctx); // could be inlined with return
    }

    public static Object getBeanByType(Type t, BeanManager bm) { // eg. name=availableCountryDao
        Bean bean = bm.getBeans(t).iterator().next();
        CreationalContext ctx = bm.createCreationalContext(bean); // could be inlined below
        return bm.getReference(bean, bean.getBeanClass(), ctx); // could be inlined with return
    }
}
