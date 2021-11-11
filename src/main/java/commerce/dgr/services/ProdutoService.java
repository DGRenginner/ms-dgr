package commerce.dgr.services;

import commerce.dgr.entities.produtos.Produto;
import commerce.dgr.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoService {

    private static final String PESSOA_SERVICE = "[PESSOA SERVICE] {}";
    private final ProdutoRepository produtoRepository;

    public Produto getProdutoPorId(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }
}