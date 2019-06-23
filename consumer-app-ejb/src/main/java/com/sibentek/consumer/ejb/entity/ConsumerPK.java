package com.sibentek.consumer.ejb.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The primary key class for the consumer database table.
 */
@Data
@Embeddable
public class ConsumerPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    private int id;

    private String cpf;
}