package commerce.dgr.entities.pagamento;

import commerce.dgr.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_promocoes")
@Getter
@Setter
public class Promocao extends AbstractEntity {
    @Column(name = "cupom")
    private String cupom;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "percentual")
    private Double percentual;

    @Column(name = "dataInicio")
    private Date dataInicio;

    @Column(name = "dataFim")
    private Date dataFim;
}
