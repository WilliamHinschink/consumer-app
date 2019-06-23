package com.sibentek.consumer.ejb.service;

import com.sibentek.consumer.ejb.model.Customer;
import com.sibentek.consumer.ejb.model.CustomersList;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomersList searchCustomer() {
        Customer customer1 = new Customer();
        customer1.setId("1");
        customer1.setFirstName("John");
        customer1.setLastName("Doe");

        Customer customer2 = new Customer();
        customer2.setId("2");
        customer2.setFirstName("Alice");
        customer2.setLastName("Cooper");

        Customer customer3 = new Customer();
        customer3.setId("3");
        customer3.setFirstName("Bob");
        customer3.setLastName("Builder");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        CustomersList customersList = new CustomersList();
        customersList.setCustomer(customers);
        return customersList;
    }
}
