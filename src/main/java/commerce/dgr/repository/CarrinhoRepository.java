package commerce.dgr.repository;

import commerce.dgr.entities.personas.Cliente;
import commerce.dgr.entities.produtos.Carrinho;
import org.springframework.data.repository.CrudRepository;

public interface CarrinhoRepository extends CrudRepository<Carrinho, Long> {

   // Iterable<Carrinho> findByCliente(Cliente cliente);
}
