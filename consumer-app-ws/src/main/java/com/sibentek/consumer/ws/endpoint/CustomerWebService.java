package com.sibentek.consumer.ws.endpoint;

import com.sibentek.consumer.ejb.service.CustomerService;
import com.sibentek.consumer.ws.model.request.ConsumerRequest;
import com.sibentek.consumer.ws.model.response.GetCustomersResponseMessage;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(targetNamespace = "http://sibentek.com/samples/jax-ws/customers/v1",
        serviceName = "Customers", portName = "CustomerPort",
        endpointInterface = "com.sibentek.consumer.ws.endpoint.CustomerEndpoint")
public class CustomerWebService implements CustomerEndpoint {

    @EJB
    private CustomerService service;

    @Override
    public GetCustomersResponseMessage getCustomers() {
        GetCustomersResponseMessage message = new GetCustomersResponseMessage();

        message.setCustomers(service.searchCustomer());

        return message;
    }

    @Override
    public GetCustomersResponseMessage createConsumer(ConsumerRequest request) {
        return null;
    }
}
