package com.sibentek.consumer.ws.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {
                "output"
        }
)
@XmlRootElement(name = "GetCustomersResponse")
public class GetCustomersResponse implements Serializable {

    @XmlElement(required = true)
    private GetCustomersResponseMessage output;
}
