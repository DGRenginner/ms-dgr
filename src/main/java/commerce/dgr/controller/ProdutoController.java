package commerce.dgr.controller;

import commerce.dgr.entities.produtos.Produto;
import commerce.dgr.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(produto.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        Iterable<Produto> produtos = produtoRepository.findAll();
        if (!produtos.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>((List<Produto>) produtos, HttpStatus.OK);
    }

    @PostMapping(path = "/criarProduto")
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.OK);
    }

    @PostMapping(path = "/atualizarProduto")
    public ResponseEntity<?> atualizarProduto(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/excluirProduto")
    public ResponseEntity<?> excluirProduto(@PathVariable("id") Long id) {
        produtoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
