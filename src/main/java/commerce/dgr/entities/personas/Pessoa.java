package commerce.dgr.entities.personas;

import commerce.dgr.entities.AbstractEntity;
import commerce.dgr.enums.TipoAcessoEnum;
import commerce.dgr.enums.TipoGeneroEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_pessoas")
@Getter
@Setter
@ToString
public class Pessoa extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "cpfCnpj")
    private String cpfCnpj;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;

    @Column(name = "tipoGenero")
    @Enumerated(EnumType.STRING)
    private TipoGeneroEnum tipoGenero;

    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;

    @Column(name = "tipoAcesso")
    @Enumerated(EnumType.STRING)
    private TipoAcessoEnum tipoAcesso;
}