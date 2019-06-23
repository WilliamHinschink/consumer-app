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
import java.util.List;


/**
 * The persistent class for the uf database table.
 */
@Data
@Entity
@Table(name = "uf")
@NamedQuery(name = "Uf.findAll", query = "SELECT u FROM Uf u")
public class Uf implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String descricao;

    //bi-directional many-to-one association to Cidade
    @OneToMany(mappedBy = "uf")
    private List<Cidade> cidades;

    //bi-directional many-to-one association to Consumer
    @OneToMany(mappedBy = "uf")
    private List<Consumer> consumers;
}