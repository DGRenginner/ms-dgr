package commerce.dgr.entities.personas;

import commerce.dgr.enums.TipoAcesso;
import commerce.dgr.enums.TipoGenero;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_pessoas")
@Getter
@Setter
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String email;
    private TipoGenero tipoGenero;

    private String login;
    private String senha;
    private TipoAcesso tipoAcesso;
}