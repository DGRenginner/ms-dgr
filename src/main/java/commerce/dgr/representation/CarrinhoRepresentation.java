package commerce.dgr.representation;

import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.entities.produtos.ItemCarrinho;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CarrinhoRepresentation {

    private Pessoa pessoa;
    private List<ItemCarrinho> itensCarrinho;
}
