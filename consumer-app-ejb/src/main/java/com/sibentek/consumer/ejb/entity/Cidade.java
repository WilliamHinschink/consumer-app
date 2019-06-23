package com.sibentek.consumer.ejb.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the cidade database table.
 */
@Data
@Entity
@Table(name = "cidade")
@NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String descricao;

    //bi-directional many-to-one association to Uf
    @ManyToOne
    @JoinColumn(name = "id_uf")
    private Uf uf;

    //bi-directional many-to-one association to Consumer
    @OneToMany(mappedBy = "cidade")
    private List<Consumer> consumers;
}