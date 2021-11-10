package commerce.dgr.factory;

import commerce.dgr.entities.dto.login.CriaCarrinhoParaClienteDTO;
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
public class CarrinhoFactory {

    public static Carrinho criaCarrinho(Pessoa pessoa, CriaCarrinhoParaClienteDTO dto) {
        return Carrinho.builder().idPessoa(pessoa.getId()).valorTotal(dto.getProduto().getPreco()).build();
    }

}
