package com.sibentek.consumer.ws.model.request;

import com.sibentek.consumer.ejb.model.Sexo;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ConsumerRequest implements Serializable {

  private static final long serialVersionUID = 1L;
  @XmlElement(required = true)
  private Long cpf;
  @XmlElement(required = true)
  private Date dataNascimento;
  @XmlElement(required = true)
  private String nome;
  private Sexo sexo;
  @XmlElement(required = true)
  private String sobrenome;
  private CidadeRequest cidade;
  private ProfissaoRequest profissao;
  private UfRequest uf;
}