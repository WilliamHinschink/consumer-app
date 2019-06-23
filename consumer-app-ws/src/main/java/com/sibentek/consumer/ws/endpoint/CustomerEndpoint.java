package com.sibentek.consumer.ws.endpoint;

import com.sibentek.consumer.ws.model.request.ConsumerRequest;
import com.sibentek.consumer.ws.model.response.GetCustomersResponseMessage;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://sibentek.com/samples/jax-ws/customers/v1")
public interface CustomerEndpoint {

    @WebMethod(operationName = "GetCustomers", action = "http://sibentek.com/samples/jax-ws/customers/v1/GetCustomers")
    @WebResult(name = "output")
    @ResponseWrapper(
            localName = "GetCustomersResponse",
            targetNamespace = "http://sibentek.com/samples/jax-ws/customers/v1",
            className = "com.sibentek.conversorapp.ws.model.response.GetCustomersResponse"
    )
    GetCustomersResponseMessage getCustomers();

    @WebMethod(operationName = "CreateConsumer", action = "http://sibentek.com/samples/jax-ws/customers/v1/CreateConsumer")
    GetCustomersResponseMessage createConsumer(
            @WebParam(name = "consumerRequest", targetNamespace = "http://sibentek.com/samples/jax-ws/customers/v1") ConsumerRequest request);
}
