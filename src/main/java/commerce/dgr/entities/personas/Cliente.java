package commerce.dgr.entities.personas;

import commerce.dgr.entities.AbstractEntity;
import commerce.dgr.entities.Endereco;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_clientes")
@Getter
@Setter
public class Cliente extends AbstractEntity {
	private Pessoa pessoa;
	private Endereco endereco;
}
