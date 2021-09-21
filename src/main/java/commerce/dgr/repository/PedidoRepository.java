package commerce.dgr.repository;

import commerce.dgr.entities.pedidos.Pedido;
import commerce.dgr.entities.personas.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

    Iterable<Pedido> findByCliente(Cliente cliente);
}
