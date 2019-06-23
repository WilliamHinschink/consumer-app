package com.sibentek.consumer.ejb.service;

import java.util.Collection;

public interface BaseService<T>  {

    Collection<T> search();

    T create();

    T remove();

    T update();
}
