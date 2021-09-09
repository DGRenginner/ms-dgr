package commerce.dgr.entities.produtos;

import commerce.dgr.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Carrinho extends AbstractEntity {

    private Long codigoCliente;
    private List<ItemCarrinho> itensCarrinho;
}
