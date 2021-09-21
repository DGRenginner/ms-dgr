package commerce.dgr.services;

import commerce.dgr.entities.pedidos.Pedido;
import commerce.dgr.entities.personas.Cliente;
import commerce.dgr.repository.ClienteRepository;
import commerce.dgr.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuscarPedidosClienteService {

    @Autowired
    private final PedidoRepository pedidoRepository;
    @Autowired
    private final ClienteRepository clienteRepository;

    public Iterable<Pedido> consultarPedidosPorCliente(Long codigoCliente) {

        try {
            Optional<Cliente> clienteOptional = clienteRepository.findById(codigoCliente);
            Cliente cliente = clienteOptional.orElseThrow(NullPointerException::new);
            return pedidoRepository.findByCliente(cliente);

        } catch (Exception e) {
            log.error("[BUSCAR PEDIDOS CLIENTE SERVICE] Ocorreu um erro {} ao consultar os pedidos do cliente {} ", e.toString(), codigoCliente);
            return new ArrayList<>();
        }
    }
}
