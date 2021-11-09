package commerce.dgr.services;

import commerce.dgr.entities.dto.login.CriaCarrinhoParaClienteDTO;
import commerce.dgr.entities.dto.login.ExcluirItemCarrinhoDTO;
import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.entities.produtos.Carrinho;
import commerce.dgr.entities.produtos.ItemCarrinho;
import commerce.dgr.factory.ItemCarrinhoFactory;
import commerce.dgr.repository.CarrinhoRepository;
import commerce.dgr.repository.ItemCarrinhoRepository;
import commerce.dgr.representation.CarrinhoRepresentation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final PessoaService pessoaService;
    private final ItemCarrinhoRepository itemCarrinhoRepository;

    public boolean consultaExisteCarrinhoPorCliente(String email) {

        Pessoa pessoa = pessoaService.consultarPessoaPorEmail(email);
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

        if (isNull(carrinho)) {
            carrinho = Carrinho.builder().idPessoa(pessoa.getId()).build();
            carrinho = carrinhoRepository.save(carrinho);

            ItemCarrinho itemCarrinho = ItemCarrinhoFactory.criaItemCarrinho(carrinho.getId(), dto.getProduto(), dto.getQuantidade());
            itemCarrinhoRepository.save(itemCarrinho);

            return CarrinhoRepresentation.builder().pessoa(pessoa).itensCarrinho(Collections.singletonList(itemCarrinho)).build();
        } else {
            Iterable<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findByIdCarrinho(carrinho.getId());
            for (ItemCarrinho item : itensCarrinho) {
                if (item.getProduto().equals(dto.getProduto().getId())) {
                    adicionaQtd(dto, item);
                }
                if(item.getQuantidade() < dto.getQuantidade()){
                    itemCarrinhoRepository.deleteById(item.getId());
                    Iterator iterator = itensCarrinho.iterator();
                    iterator.remove();
                }
            }
            List list = IteratorUtils.toList(itensCarrinho.iterator());
            return CarrinhoRepresentation.builder().pessoa(pessoa).itensCarrinho(list).build();
        }

    }

    private void adicionaQtd(CriaCarrinhoParaClienteDTO dto, ItemCarrinho itemCarrinho) {
        itemCarrinho.setQuantidade(itemCarrinho.getQuantidade() + dto.getQuantidade());
    }

    @Transactional
    public void deletarCarrinho(Pessoa pessoa) {
        Carrinho carrinho = carrinhoRepository.findByIdPessoa(pessoa.getId());
        if (nonNull(carrinho)) {
            itemCarrinhoRepository.deleteByIdCarrinho(carrinho.getId());
            carrinhoRepository.deleteById(carrinho.getId());
        }
    }

    public CarrinhoRepresentation consultarCarrinho(Pessoa pessoa){
        Carrinho carrinho = carrinhoRepository.findByIdPessoa(pessoa.getId());
        if(nonNull(carrinho)){
            Iterable<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findByIdCarrinho(carrinho.getId());
            List list = IteratorUtils.toList(itensCarrinho.iterator());
            return CarrinhoRepresentation.builder().pessoa(pessoa).itensCarrinho(list).build();
        }
        return null;
    }

    public CarrinhoRepresentation excluirItemCarrinho(ExcluirItemCarrinhoDTO dto){
        Pessoa pessoa = pessoaService.consultarPessoaPorEmail(dto.getEmail());

        Carrinho carrinho = carrinhoRepository.findByIdPessoa(pessoa.getId());
        Iterable<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findByIdCarrinho(carrinho.getId());
        for (ItemCarrinho item : itensCarrinho) {
            if (item.getProduto().equals(dto.getProduto().getId())) {
                diminuiQtd(dto, item);
                if(item.getQuantidade() < dto.getQuantidade()){
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
}
