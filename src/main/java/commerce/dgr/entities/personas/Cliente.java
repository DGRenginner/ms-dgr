package commerce.dgr.entities.personas;

import commerce.dgr.enums.TipoAcessoEnum;
import commerce.dgr.enums.TipoGeneroEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "tb_clientes")
@Getter
@Setter
public class Cliente extends Pessoa {

    @OneToMany
    @JoinColumn(name = "endereco")
    private Set<Endereco> endereco;

}
