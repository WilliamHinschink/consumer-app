package com.sibentek.consumer.ws.model.response;

import com.sibentek.consumer.ejb.model.CustomersList;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "GetCustomersResponseMessage",
        propOrder = {
                "customers"
        }
)
public class GetCustomersResponseMessage implements Serializable {

    @XmlElement(required = true)
    private CustomersList customers;
}
