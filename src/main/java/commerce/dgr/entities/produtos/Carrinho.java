package commerce.dgr.entities.produtos;

import commerce.dgr.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "tb_carrinho")
public class Carrinho extends AbstractEntity {

    private Long codigoCliente;
    private Map<List<Produto>, Integer> produtosMap;
}
