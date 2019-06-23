package com.sibentek.consumer.ws.model.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
public class ProfissaoRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descricao;

    private BigDecimal salario;
    private List<ConsumerRequest> consumers;
}