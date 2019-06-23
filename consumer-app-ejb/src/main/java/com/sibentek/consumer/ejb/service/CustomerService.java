package com.sibentek.consumer.ejb.service;

import com.sibentek.consumer.ejb.model.CustomersList;

import javax.ejb.Local;

@Local
public interface CustomerService {

    CustomersList searchCustomer();
}
