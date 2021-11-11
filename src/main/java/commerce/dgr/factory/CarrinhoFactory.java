package commerce.dgr.factory;

import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.entities.produtos.Carrinho;
import commerce.dgr.entities.produtos.Produto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarrinhoFactory {

    public static Carrinho criaCarrinho(Pessoa pessoa, Produto produto) {
        return Carrinho.builder().idPessoa(pessoa.getId()).valorTotal(produto.getPreco()).build();
    }

}
