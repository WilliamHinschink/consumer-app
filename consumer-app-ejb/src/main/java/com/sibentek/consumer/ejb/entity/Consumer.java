package com.sibentek.consumer.ejb.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the consumer database table.
 */
@Data
@Entity
@Table(name = "consumer")
@NamedQuery(name = "Consumer.findAll", query = "SELECT c FROM Consumer c")
public class Consumer implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ConsumerPK id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_insercao")
    private Date dataInsercao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    private String nome;

    private int sexo;

    private String sobrenome;

    //bi-directional many-to-one association to Cidade
    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    //bi-directional many-to-one association to Profissao
    @ManyToOne
    @JoinColumn(name = "id_profissao")
    private Profissao profissao;

    //bi-directional many-to-one association to Uf
    @ManyToOne
    @JoinColumn(name = "id_uf")
    private Uf uf;
}