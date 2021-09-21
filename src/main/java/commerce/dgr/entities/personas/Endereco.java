package commerce.dgr.entities.personas;

import com.sun.istack.NotNull;
import commerce.dgr.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tb_enderecos")
public class Endereco extends AbstractEntity {

    @NotNull
    @Column(name = "logradouro")
    private String logradouro;

    @NotNull
    @Column(name = "numeroResidencia")
    private String numeroResidencia;

    @Column(name = "complemento")
    private String complemento;

    @NotNull
    @Column(name = "bairro")
    private String bairro;

    @NotNull
    @Column(name = "cidade")
    private String cidade;

    @NotNull
    @Column(name = "estado")
    private String estado;

    @NotNull
    @Column(name = "cep")
    private String cep;
}
