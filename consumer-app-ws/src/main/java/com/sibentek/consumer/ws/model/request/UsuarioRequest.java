package com.sibentek.consumer.ws.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsuarioRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String login;
    private String nome;
    private String senha;
    private String sobrenome;
    private GrupoRequest grupo;
}