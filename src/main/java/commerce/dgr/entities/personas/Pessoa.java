package commerce.dgr.entities.personas;

import commerce.dgr.entities.AbstractEntity;
import commerce.dgr.enums.TipoAcessoEnum;
import commerce.dgr.enums.TipoGeneroEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_pessoas")
@Getter
@Setter
public class Pessoa extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String email;
    private TipoGeneroEnum tipoGenero;

    private String login;
    private String senha;
    private TipoAcessoEnum tipoAcesso;
}