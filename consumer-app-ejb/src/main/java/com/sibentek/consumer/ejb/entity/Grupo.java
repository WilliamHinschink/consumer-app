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
 * The persistent class for the grupo database table.
 */
@Data
@Entity
@Table(name = "grupo")
@NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g")
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String descricao;

    //bi-directional many-to-one association to Usuario
    @OneToMany(mappedBy = "grupo")
    private List<Usuario> usuarios;
}