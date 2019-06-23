package com.sibentek.consumer.ws.model.request;

import com.sibentek.consumer.ejb.entity.Consumer;
import com.sibentek.consumer.ejb.entity.Uf;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CidadeRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descricao;
    private Uf uf;
    private List<Consumer> consumers;
}