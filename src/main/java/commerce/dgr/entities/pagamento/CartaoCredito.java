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

    @Column(name = "nomeTitular")
    private String nomeTitular;

    @Column(name = "numeroCartao")
    private String numeroCartao;

    @Column(name = "cvv")
    @Nullable
    private String cvv;

    @Column(name = "limiteDisponivel")
    private BigDecimal limiteDisponivel;

    @Column(name = "dataVencimento")
    private Date dataVencimento;
}
