package commerce.dgr.component;

import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaComponent {
    private final PessoaRepository pessoaRepository;

    public Pessoa getPessoaPorEmail(String email){
        return pessoaRepository.getPessoaByEmail(email);
    }

    public boolean existePessoaPorEmail(String email){
        return pessoaRepository.existsPessoaByEmail(email);
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

}
