package commerce.dgr.controller;

import commerce.dgr.component.LoginComponent;
import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    private final PessoaRepository pessoaRepository;
    private final LoginComponent loginComponent;

    @Autowired
    public PessoaController(PessoaRepository pessoaRepository, LoginComponent loginComponent) {
        this.pessoaRepository = pessoaRepository;
        this.loginComponent = loginComponent;
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable("id") Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @CrossOrigin
    @PostMapping(path = "/criarPessoa")
    public ResponseEntity<?> criarPessoa(@RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(path = "/atualizarPessoa")
    public ResponseEntity<?> atualizarPessoa(@RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(path = "/excluirPessoa/{id}")
    public ResponseEntity<?> excluirPessoa(@PathVariable("id") Long id) {
        pessoaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/efetuarLogin")
    public ResponseEntity<Pessoa> efetuarLogin(@RequestParam("email") String email, @RequestParam("senha") String senha) {
        return new ResponseEntity<>(loginComponent.efetuarLoginPessoa(email, senha), HttpStatus.OK);
    }
}