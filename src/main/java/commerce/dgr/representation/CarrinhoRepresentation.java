package commerce.dgr.representation;

import commerce.dgr.entities.personas.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CarrinhoRepresentation {

    private Long codigoCarrinho;
    private Pessoa pessoa;
    private List itensCarrinho;
    private BigDecimal valorTotal;
}
