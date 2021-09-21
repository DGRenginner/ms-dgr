package commerce.dgr.entities.pagamento;

import commerce.dgr.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class CartaoCredito extends AbstractEntity {

    @Column(name = "codigoBarras")
    private String codigoBarras;

    @Column(name = "codigoBarras")
    private String nomeTitular;

    @Column(name = "codigoBarras")
    private String numeroCartao;

    @Column(name = "codigoBarras")
    @Nullable
    private String cvv;

    @Column(name = "codigoBarras")
    private BigDecimal limiteDisponivel;

    @Column(name = "codigoBarras")
    private Date dataVencimento;
}
