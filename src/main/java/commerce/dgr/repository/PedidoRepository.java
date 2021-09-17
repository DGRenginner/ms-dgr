package commerce.dgr.repository;

import commerce.dgr.entities.pedidos.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {


    Iterable<Pedido> findByCodigoCliente(Long codigoCliente);
}
