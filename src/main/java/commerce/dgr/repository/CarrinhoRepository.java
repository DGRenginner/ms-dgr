package commerce.dgr.repository;

import commerce.dgr.entities.produtos.Carrinho;
import org.springframework.data.repository.CrudRepository;

public interface CarrinhoRepository extends CrudRepository<Carrinho, Long> {

    Carrinho findByIdPessoa(Long idPessoa);
}
