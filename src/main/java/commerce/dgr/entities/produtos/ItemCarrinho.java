package commerce.dgr.entities.produtos;

import commerce.dgr.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCarrinho extends AbstractEntity {
    private Long codigoProduto;
    private Integer quantidade;
}
