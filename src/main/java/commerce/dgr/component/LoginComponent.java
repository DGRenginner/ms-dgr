package commerce.dgr.component;

import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class LoginComponent {

    private final PessoaRepository pessoaRepository;

    @SneakyThrows
    public Pessoa efetuarLoginPessoa(String email, String senha) {
        Pessoa pessoaTemp = pessoaRepository.getPessoaByEmail(email);

        if (pessoaTemp == null) {
            throw new Exception("Email não encontrado. Faça seu cadastro!");
        }

        if (senha.equals(pessoaTemp.getSenha())) {
            return pessoaTemp;
        } else {
            throw new Exception("Senhas não coincidem!");
        }
    }


}