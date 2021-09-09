package commerce.dgr.controller;

import commerce.dgr.entities.personas.Cliente;
import commerce.dgr.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping(path = "/criarCliente")
    public ResponseEntity<?> criarCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteRepository.save(cliente), HttpStatus.OK);
    }

    @PostMapping(path = "/atualizarCliente")
    public ResponseEntity<?> atualizarCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteRepository.save(cliente), HttpStatus.OK);
    }

    @DeleteMapping(path = "/excluirCliente")
    public ResponseEntity<?> excluirCliente(@PathVariable("id") Long id) {
        clienteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
