package commerce.dgr.services;

import commerce.dgr.entities.dto.login.CriaCarrinhoParaClienteDTO;
import commerce.dgr.entities.dto.login.ExcluirItemCarrinhoDTO;
import commerce.dgr.entities.dto.login.LoginDTO;
import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.entities.produtos.Carrinho;
import commerce.dgr.entities.produtos.ItemCarrinho;
import commerce.dgr.entities.produtos.Produto;
import commerce.dgr.factory.CarrinhoFactory;
import commerce.dgr.factory.CarrinhoRepresentationFactory;
import commerce.dgr.factory.ItemCarrinhoFactory;
import commerce.dgr.repository.CarrinhoRepository;
import commerce.dgr.repository.ItemCarrinhoRepository;
import commerce.dgr.representation.CarrinhoRepresentation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final PessoaService pessoaService;
    private final ItemCarrinhoRepository itemCarrinhoRepository;
    private final ProdutoService produtoService;

    public boolean consultaExisteCarrinhoPorCliente(LoginDTO dto) {

        Pessoa pessoa = pessoaService.consultarPessoaPorEmail(dto.getEmail());
        log.info("[CARRINHO SERVICE] Iniciando consulta de existencia de carrinho para pessoa {}", pessoa);

        Carrinho carrinho = carrinhoRepository.findByIdPessoa(pessoa.getId());

        if (nonNull(carrinho)) {
            log.info("[CARRINHO SERVICE] Carrinho {} encontrado para pessoa {}", carrinho, pessoa);
            return true;
        }
        return false;
    }

    @Transactional
    public CarrinhoRepresentation criaAtualizaCarrinho(CriaCarrinhoParaClienteDTO dto) {

        Pessoa pessoa = pessoaService.consultarPessoaPorEmail(dto.getEmail());
        Carrinho carrinho = carrinhoRepository.findByIdPessoa(pessoa.getId());

        Produto produto = produtoService.getProdutoPorId(dto.getIdProduto());
        if (isNull(carrinho)) {
            carrinho = CarrinhoFactory.criaCarrinho(pessoa, produto);

            carrinhoRepository.save(carrinho);
            ItemCarrinho itemCarrinho = ItemCarrinhoFactory.criaItemCarrinho(carrinho.getId(), produto, dto.getQuantidade());
            itemCarrinhoRepository.save(itemCarrinho);

            return CarrinhoRepresentationFactory.criaItemCarrinho(pessoa, Collections.singletonList(itemCarrinho), produto.getPreco());

        } else {
            return adicionarItemCarrinho(dto, carrinho, pessoa, produto);
        }
    }

    @Transactional
    public CarrinhoRepresentation adicionarItemCarrinho(CriaCarrinhoParaClienteDTO dto, Carrinho carrinho, Pessoa pessoa, Produto produto) {

        Iterable<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findByIdCarrinho(carrinho.getId());

        Map<Produto, Integer> mapProdutoQtd = converterParaMap(itensCarrinho);

        verificaDadosProdutoMap(new ItemCarrinho(produto, dto.getQuantidade(), carrinho.getId()), mapProdutoQtd);

        atualizarItensCarrinho(mapProdutoQtd, carrinho);
        atualizarValorTotalCarrinho(mapProdutoQtd, carrinho);

        return CarrinhoRepresentation.builder().codigoCarrinho(carrinho.getId()).itensCarrinho(converterMapParaList(mapProdutoQtd, carrinho))
                .valorTotal(carrinho.getValorTotal()).pessoa(pessoa).build();
    }

    private Carrinho atualizarValorTotalCarrinho(Map<Produto, Integer> mapProdutoQtd, Carrinho carrinho) {
        BigDecimal valorTotal = somarValorTotalItens(mapProdutoQtd);
        carrinho.setValorTotal(valorTotal);
        return carrinhoRepository.save(carrinho);
    }

    private void atualizarItensCarrinho(Map<Produto, Integer> mapProdutoQtd, Carrinho carrinho) {
        mapProdutoQtd.forEach((produto, quantidade) -> verificaItensCarrinho(produto, quantidade, carrinho)
        );
    }

    private void verificaItensCarrinho(Produto produto, Integer quantidade, Carrinho carrinho) {
        ItemCarrinho itemCarrinho = itemCarrinhoRepository.findByIdCarrinhoAndProduto(carrinho.getId(), produto.getId());
        if (nonNull(itemCarrinho)) {
            itemCarrinho.setQuantidade(quantidade);
            itemCarrinhoRepository.save(itemCarrinho);
        } else {
            itemCarrinhoRepository.save(new ItemCarrinho(produto, quantidade, carrinho.getId()));
        }
    }

    private List<ItemCarrinho> converterMapParaList(Map<Produto, Integer> mapProdutoQtd, Carrinho carrinho) {
        List<ItemCarrinho> itemCarrinhoList = new ArrayList<>();
        mapProdutoQtd.forEach((produto, integer) -> itemCarrinhoList.add(new ItemCarrinho(produto, integer, carrinho.getId())));
        return itemCarrinhoList;
    }


    private Map<Produto, Integer> converterParaMap(Iterable<ItemCarrinho> itensCarrinho) {

        Map<Produto, Integer> mapProdutoQtd = new HashMap<>();
        itensCarrinho.forEach(itemCarrinho -> verificaDadosProdutoMap(itemCarrinho, mapProdutoQtd));

        return mapProdutoQtd;
    }

    private void verificaDadosProdutoMap(ItemCarrinho itemCarrinho, Map<Produto, Integer> mapProdutoQtd) {
        Produto produto = produtoService.getProdutoPorId(itemCarrinho.getProduto());
        if (mapProdutoQtd.containsKey(produto)) {
            mapProdutoQtd.replace(produto, mapProdutoQtd.get(produto) + itemCarrinho.getQuantidade());
        } else {
            mapProdutoQtd.put(produto, itemCarrinho.getQuantidade());
        }
    }


    private void adicionaQtd(CriaCarrinhoParaClienteDTO dto, ItemCarrinho itemCarrinho) {
        itemCarrinho.setQuantidade(itemCarrinho.getQuantidade() + dto.getQuantidade());
    }

    @Transactional
    public void deletarCarrinho(Pessoa pessoa) {
        Iterable<Carrinho> iterable = carrinhoRepository.findAllByIdPessoa(pessoa.getId());
        iterable.forEach(carrinho ->
                deletarCarrinhoEItens(carrinho.getId())
        );
    }

    private void deletarCarrinhoEItens(Long idCarrinho) {
        itemCarrinhoRepository.deleteByIdCarrinho(idCarrinho);
        carrinhoRepository.deleteById(idCarrinho);
    }

    public CarrinhoRepresentation consultarCarrinho(Pessoa pessoa) {
        Carrinho carrinho = carrinhoRepository.findByIdPessoa(pessoa.getId());
        if (nonNull(carrinho)) {
            Iterable<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findByIdCarrinho(carrinho.getId());
            List list = IteratorUtils.toList(itensCarrinho.iterator());
            return CarrinhoRepresentation.builder().pessoa(pessoa).valorTotal(carrinho.getValorTotal()).itensCarrinho(list).build();
        }

        return null;
    }

    public CarrinhoRepresentation excluirItemCarrinho(ExcluirItemCarrinhoDTO dto) {
        Pessoa pessoa = pessoaService.consultarPessoaPorEmail(dto.getEmail());

        Carrinho carrinho = carrinhoRepository.findByIdPessoa(pessoa.getId());
        Iterable<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findByIdCarrinho(carrinho.getId());
        for (ItemCarrinho item : itensCarrinho) {
            if (item.getProduto().equals(dto.getProduto().getId())) {
                diminuiQtd(dto, item);
                if (item.getQuantidade() < dto.getQuantidade()) {
                    itemCarrinhoRepository.deleteById(item.getId());
                }
            }
        }

        List list = IteratorUtils.toList(itensCarrinho.iterator());
        return CarrinhoRepresentation.builder().pessoa(pessoa).itensCarrinho(list).build();
    }

    private void diminuiQtd(ExcluirItemCarrinhoDTO dto, ItemCarrinho itemCarrinho) {
        itemCarrinho.setQuantidade(itemCarrinho.getQuantidade() - dto.getQuantidade());
    }

    private BigDecimal somarValorTotalItens(Map<Produto, Integer> mapProdutoQtd) {

        final BigDecimal[] valorTotal = {BigDecimal.ZERO};

        mapProdutoQtd.forEach((produto, integer) -> valorTotal[0] = valorTotal[0].add(produto.getPreco().multiply(BigDecimal.valueOf(integer))));
        return valorTotal[0];
    }
}