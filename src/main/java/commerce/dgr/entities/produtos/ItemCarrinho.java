package commerce.dgr.entities.produtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCarrinho {
    private Long codigoProduto;
    private Integer quantidade;
}
