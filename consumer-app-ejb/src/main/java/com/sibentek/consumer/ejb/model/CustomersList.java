package com.sibentek.consumer.ejb.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "CustomersList",
        propOrder = {
                "customer"
        }
)
public class CustomersList implements Serializable {

    @XmlElement(required = true)
    private List<Customer> customer;
}
