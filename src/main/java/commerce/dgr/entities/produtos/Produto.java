package commerce.dgr.entities.produtos;

import commerce.dgr.entities.AbstractEntity;
import commerce.dgr.entities.Endereco;
import commerce.dgr.entities.personas.Pessoa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
public class Produto extends AbstractEntity {
	private String nome;
	private String descricao;
	private String marca;
	private BigDecimal preco;
	private boolean promocao;
	private String urlImagem;
}
