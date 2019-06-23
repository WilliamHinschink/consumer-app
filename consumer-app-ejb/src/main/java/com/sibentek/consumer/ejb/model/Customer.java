package com.sibentek.consumer.ejb.model;

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
        name = "Customer",
        propOrder = {
                "id",
                "firstName",
                "lastName"
        }
)
public class Customer implements Serializable {

    @XmlElement(required = true)
    private String id;
    @XmlElement(required = true)
    private String firstName;
    @XmlElement(required = true)
    private String lastName;

}
