package commerce.dgr.controller;

import commerce.dgr.entities.dto.login.CriaCarrinhoParaClienteDTO;
import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.services.CarrinhoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carrinhos")
@Slf4j
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    @Autowired
    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @CrossOrigin
    @PostMapping(path = "/criarAtualizarCarrinho")
    public ResponseEntity<?> criarAtualizarCarrinho(@RequestBody CriaCarrinhoParaClienteDTO dto) {
        log.info("[CARRINHO CONTROLLER] Iniciando criação/atualizacao de carrinho com objeto {}", dto);
        return new ResponseEntity<>(carrinhoService.criaAtualizaCarrinho(dto), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(path = "/deletarCarrinho")
    public ResponseEntity<?> deletarCarrinho(@RequestBody Pessoa pessoa) {
        log.info("[CARRINHO CONTROLLER] Deletando carrinho para pessoa {}", pessoa);
        carrinhoService.deletarCarrinho(pessoa);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @CrossOrigin
    @PostMapping(path = "/consultarCarrinho")
    public ResponseEntity<?> consultarCarrinho(@RequestBody Pessoa pessoa) {
        log.info("[CARRINHO CONTROLLER] Iniciando consulta de carrinho para pessoa {}", pessoa);
        return new ResponseEntity<>(carrinhoService.consultarCarrinho(pessoa), HttpStatus.OK);
    }



}
