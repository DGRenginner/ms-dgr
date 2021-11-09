package commerce.dgr.repository;

import commerce.dgr.entities.produtos.ItemCarrinho;
import org.springframework.data.repository.CrudRepository;

public interface ItemCarrinhoRepository extends CrudRepository<ItemCarrinho, Long> {

    Iterable<ItemCarrinho> findByIdCarrinho(Long codigo);

    void deleteByIdCarrinho(Long codigo);
}
