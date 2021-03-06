package commerce.dgr.factory;

import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.entities.produtos.Carrinho;
import commerce.dgr.entities.produtos.ItemCarrinho;
import commerce.dgr.representation.CarrinhoRepresentation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.IteratorUtils;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarrinhoRepresentationFactory {

    public static CarrinhoRepresentation criaItensCarrinho(Pessoa pessoa, Iterable<ItemCarrinho> itensCarrinho, BigDecimal valorTotal, Carrinho carrinho) {
        return CarrinhoRepresentation.builder()
                .codigoCarrinho(carrinho.getId())
                .pessoa(pessoa)
                .itensCarrinho(IteratorUtils.toList(itensCarrinho.iterator()))
                .valorTotal(valorTotal).build();
    }

    public static CarrinhoRepresentation criaItemCarrinho(Pessoa pessoa, List itemCarrinho, BigDecimal valorTotal, Carrinho carrinho) {
        return CarrinhoRepresentation.builder()
                .codigoCarrinho(carrinho.getId())
                .pessoa(pessoa)
                .itensCarrinho(itemCarrinho)
                .valorTotal(valorTotal).build();
    }

}
