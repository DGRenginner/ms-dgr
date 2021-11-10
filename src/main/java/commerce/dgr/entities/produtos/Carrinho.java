package commerce.dgr.entities.produtos;

import com.sun.istack.NotNull;
import commerce.dgr.entities.AbstractEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_carrinhos")
public class Carrinho extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JoinColumn(name = "id_pessoa")
    private Long idPessoa;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

}
