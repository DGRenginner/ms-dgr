package commerce.dgr.entities.produtos;

import commerce.dgr.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_carrinhos")
public class Carrinho extends AbstractEntity {

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<ItemCarrinho> itensCarrinho;
}
