package com.sibentek.consumer.ws.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ConsumerRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cpf;
    private Date dataAtualizacao;
    private Date dataInsercao;
    private Date dataNascimento;
    private String nome;
    private int sexo;
    private String sobrenome;
    private CidadeRequest cidade;
    private ProfissaoRequest profissao;
    private UfRequest uf;
}