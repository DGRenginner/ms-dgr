package commerce.dgr.entities.produtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Estoque {
    private List<Produto> produtosList;
}
