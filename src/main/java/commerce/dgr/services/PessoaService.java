package commerce.dgr.services;

import commerce.dgr.entities.ServiceConstants;
import commerce.dgr.entities.dto.login.LoginDTO;
import commerce.dgr.entities.personas.Pessoa;
import commerce.dgr.exception.CadastroJaExistenteException;
import commerce.dgr.exception.LoginNaoEncontradoException;
import commerce.dgr.exception.SenhaIncorretaException;
import commerce.dgr.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class PessoaService {

    private static final String PESSOA_SERVICE = "[PESSOA SERVICE] {}";
    private final PessoaRepository pessoaRepository;

    @SneakyThrows
    public Pessoa efetuarLoginPessoa(LoginDTO loginDTO) {

        log.info(PESSOA_SERVICE, format("Iniciando consulta para login com email %s", loginDTO.getEmail()));
        Pessoa pessoa = consultarPessoaPorEmail(loginDTO.getEmail());
        if (loginDTO.getSenha().equals(pessoa.getSenha())) {
            return pessoa;
        } else {
            String msgErro = ServiceConstants.ERRO_SENHA_INCORRETA.getMensagemErro();
            log.error(PESSOA_SERVICE, msgErro);
            throw new SenhaIncorretaException(msgErro);
        }
    }

    @SneakyThrows
    public Pessoa criarPessoa(Pessoa pessoa) {
        log.info(PESSOA_SERVICE, format("Iniciando cadastro de pessoa %s", pessoa));

        boolean existePessoa = pessoaRepository.existsPessoaByEmail(pessoa.getEmail());

        if (!existePessoa) {
            return pessoaRepository.save(pessoa);
        } else {
            String msgErro = ServiceConstants.ERRO_EMAIL_JA_POSSUI_CADASTRO.getMensagemErro();
            log.warn(PESSOA_SERVICE, msgErro);
            throw new CadastroJaExistenteException(msgErro);
        }
    }

    public Pessoa consultarPessoa(LoginDTO loginDTO) throws LoginNaoEncontradoException {
        String email = loginDTO.getEmail();
        log.info(PESSOA_SERVICE, format("Iniciando consulta de pessoa com email %s", email));

        Pessoa pessoa = pessoaRepository.getPessoaByEmail(loginDTO.getEmail());
        if (pessoa == null) {
            String msgErro = ServiceConstants.ERRO_USUARIO_NAO_ENCONTRADO.getMensagemErro();
            log.warn(PESSOA_SERVICE, msgErro);
            throw new LoginNaoEncontradoException(msgErro);
        } else {
            log.info(PESSOA_SERVICE, format("Usuário consultado com sucesso %s", pessoa));
            return pessoa;
        }
    }

    @SneakyThrows
    public Pessoa consultarPessoaPorEmail(String email) {
        Pessoa pessoaTemp = pessoaRepository.getPessoaByEmail(email);

        if (pessoaTemp == null) {
            log.warn(PESSOA_SERVICE, ServiceConstants.ERRO_EMAIL_NAO_ENCONTRADO.getMensagemErro());
            throw new LoginNaoEncontradoException(ServiceConstants.ERRO_EMAIL_NAO_ENCONTRADO.getMensagemErro());
        }
        return pessoaTemp;
    }

    @SneakyThrows
    public Pessoa excluirPessoa(Pessoa pessoa) {
        Pessoa pessoaTemp = pessoaRepository.getPessoaByEmail(pessoa.getEmail());

        if (pessoaTemp == null) {
            log.warn(PESSOA_SERVICE, ServiceConstants.ERRO_EMAIL_NAO_ENCONTRADO.getMensagemErro());
            throw new LoginNaoEncontradoException(ServiceConstants.ERRO_EMAIL_NAO_ENCONTRADO.getMensagemErro());
        }
        return pessoaTemp;
    }
}