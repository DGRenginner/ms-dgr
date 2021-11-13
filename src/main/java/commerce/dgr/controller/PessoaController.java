package commerce.dgr.controller;

import commerce.dgr.entities.dto.login.LoginDTO;
import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.exception.LoginNaoEncontradoException;
import commerce.dgr.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @CrossOrigin
    @GetMapping(path = "/consultarPessoa")
    public ResponseEntity<Pessoa> consultarPessoaPorEmail(@RequestBody LoginDTO loginDTO) throws LoginNaoEncontradoException {
        return new ResponseEntity<>(pessoaService.consultarPessoa(loginDTO), HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(path = "/criarPessoa")
    public ResponseEntity<?> criarPessoa(@RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(pessoaService.criarPessoa(pessoa), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(path = "/atualizarPessoa")
    public ResponseEntity<?> atualizarPessoa(@RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(pessoaService.criarPessoa(pessoa), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(path = "/excluirPessoa")
    public ResponseEntity<?> excluirPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.excluirPessoa(pessoa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(path = "/efetuarLogin")
    @ResponseBody
    public ResponseEntity<Pessoa> efetuarLogin(@RequestBody LoginDTO loginDTO) {
        return new ResponseEntity<>(pessoaService.efetuarLoginPessoa(loginDTO), HttpStatus.OK);
    }
}