package commerce.dgr.entities.pagamento;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class CartaoCredito {
    private String codigoBarras;
    private String nomeTitular;
    private String numeroCartao;
    private String cvv;
    private BigDecimal limiteDisponivel;
    private Date dataVencimento;
}
