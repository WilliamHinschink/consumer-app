package com.sibentek.consumer.ws.model.request;

import com.sibentek.consumer.ejb.entity.Usuario;
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

@Data
public class GrupoRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descricao;
    private List<UsuarioRequest> usuarios;
}