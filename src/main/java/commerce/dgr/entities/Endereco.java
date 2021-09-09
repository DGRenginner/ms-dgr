package commerce.dgr.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table (name = "tb_enderecos")
public class Endereco extends AbstractEntity {

    private String logradouro;
    private String numeroResidencia;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
