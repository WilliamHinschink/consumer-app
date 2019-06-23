package com.sibentek.consumer.ejb.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the profissao database table.
 */
@Data
@Entity
@Table(name = "profissao")
@NamedQuery(name = "Profissao.findAll", query = "SELECT p FROM Profissao p")
public class Profissao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String descricao;

    private BigDecimal salario;

    //bi-directional many-to-one association to Consumer
    @OneToMany(mappedBy = "profissao")
    private List<Consumer> consumers;
}