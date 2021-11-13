package commerce.dgr.entities.produtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import commerce.dgr.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Produto extends AbstractEntity {

    @NotNull
    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @Column(name = "marca")
    private String marca;

    @Column(name = "preco")
    @NotNull
    private BigDecimal preco;

    @Column(name = "promocao")
    private boolean promocao;

    @Column(name = "urlImagem")
    private String urlImagem;

    @Column(name = "quantidade")
    private Integer quantidade;
}
