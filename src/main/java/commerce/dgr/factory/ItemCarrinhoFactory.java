package commerce.dgr.factory;

import commerce.dgr.entities.produtos.ItemCarrinho;
import commerce.dgr.entities.produtos.Produto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemCarrinhoFactory {

    public static ItemCarrinho criaItemCarrinho(Long codigoCarrinho, Produto produto, Integer quantidade){
        return ItemCarrinho.builder()
                .idCarrinho(codigoCarrinho)
                .produto(produto.getId())
                .quantidade(quantidade)
                .build();
    }
}
