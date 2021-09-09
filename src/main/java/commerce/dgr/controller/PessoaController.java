package commerce.dgr.controller;

import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pessoas/")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable("id") Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pessoa.get(), HttpStatus.OK);
    }

    @PostMapping(path = "/criarPessoa")
    public ResponseEntity<?> criarPessoa(@RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.OK);
    }

    @PostMapping(path = "/atualizarPessoa")
    public ResponseEntity<?> atualizarPessoa(@RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.OK);
    }

    @DeleteMapping(path = "/excluirPessoa/{id}")
    public ResponseEntity<?> excluirPessoa(@PathVariable("id") Long id) {
        pessoaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}