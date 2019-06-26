package com.sibentek.consumer.ws.endpoint;

import com.sibentek.consumer.ejb.service.CustomerService;
import com.sibentek.consumer.ws.model.request.ConsumerRequest;
import com.sibentek.consumer.ws.model.response.GetCustomersResponseMessage;
import com.sibentek.consumer.ws.validator.JaxbValidator;
import com.sibentek.consumer.ws.validator.JaxbValidator.ValidationException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebService;

@Stateless
@WebService(targetNamespace = "http://sibentek.com/samples/jax-ws/customers/v1",
    serviceName = "Consumer", portName = "ConsumerPort",
    endpointInterface = "com.sibentek.consumer.ws.endpoint.ConsumerEndpoint")
//@Interceptors(JaxbValidator.class)
public class ConsumerWebService implements ConsumerEndpoint {

  @EJB
  private CustomerService service;

  @Override
  public GetCustomersResponseMessage getCustomers() {
    GetCustomersResponseMessage message = new GetCustomersResponseMessage();

    message.setCustomers(service.searchCustomer());

    return message;
  }

  @Override
  public GetCustomersResponseMessage postConsumer(ConsumerRequest request)
      throws ValidationException {
      JaxbValidator.validateRequired(request, ConsumerRequest.class);
    return null;
  }
}
