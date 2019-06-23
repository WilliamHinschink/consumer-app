package com.sibentek.consumer.ejb.service;

import com.sibentek.consumer.ejb.dao.BaseDao;
import com.sibentek.consumer.ejb.entity.Consumer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
public class ConsumerServiceImpl implements ConsumerService {

    @Inject
    private BaseDao<Consumer> baseDao;

    @Override
    public Collection<Consumer> search() {
        return baseDao.findAll("Consumer.findAll");
    }

    @Override
    public Consumer create() {
        return null;
    }

    @Override
    public Consumer remove() {
        return null;
    }

    @Override
    public Consumer update() {
        return null;
    }
}
