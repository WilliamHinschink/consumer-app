package com.sibentek.consumer.ws.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UfRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descricao;
    private List<CidadeRequest> cidades;
    private List<ConsumerRequest> consumers;
}