package commerce.dgr.entities.produtos;

import commerce.dgr.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_promocoes")
@Getter
@Setter
public class Promocao extends AbstractEntity {
    private String cupom;
    private String descricao;

    private Double percentual;

    private Date dataInicio;
    private Date dataFim;
}
