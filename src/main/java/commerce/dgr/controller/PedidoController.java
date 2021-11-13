package commerce.dgr.controller;

import commerce.dgr.entities.pedidos.Pedido;
import commerce.dgr.repository.PedidoRepository;
import commerce.dgr.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private final PedidosService pedidosService;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoController(PedidosService pedidosService, PedidoRepository pedidoRepository) {
        this.pedidosService = pedidosService;
        this.pedidoRepository = pedidoRepository;
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable("id") Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @CrossOrigin
    @GetMapping(path = "/buscarPedidosCliente/{codigoCliente}")
    public ResponseEntity<List<Pedido>> buscarPedidosCliente(@PathVariable("codigoCliente") Long codigoCliente) {
        Iterable<Pedido> pedidos = pedidosService.consultarPedidosPorCliente(codigoCliente);
        if (!pedidos.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>((List<Pedido>) pedidos, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodosPedidos() {
        Iterable<Pedido> pedido = pedidoRepository.findAll();
        if (!pedido.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>((List<Pedido>) pedido, HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(path = "/criarPedido")
    public ResponseEntity<?> criarPedido(@RequestBody Pedido pedido) {
        return new ResponseEntity<>(pedidoRepository.save(pedido), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(path = "/atualizarPedido")
    public ResponseEntity<?> atualizarPedido(@RequestBody Pedido pedido) {
        return new ResponseEntity<>(pedidoRepository.save(pedido), HttpStatus.OK);
    }
}