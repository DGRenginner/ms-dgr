package commerce.dgr.entities.produtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import commerce.dgr.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Produto extends AbstractEntity {

    @JsonProperty("nome")
    @NotNull
    private String nome;

    @JsonProperty("descricao")
    private String descricao;

    @NotNull
    @JsonProperty("marca")
    private String marca;

    @JsonProperty("preco")
    @NotNull
    private BigDecimal preco;

    @JsonProperty("promocao")
    private boolean promocao;

    @JsonProperty("urlImagem")
    @NotNull
    private String urlImagem;
}
