package commerce.dgr.entities.pagamento;

import commerce.dgr.entities.AbstractEntity;
import commerce.dgr.enums.FormaPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Pagamento extends AbstractEntity {
    private String codigoBarras;
    private Integer numParcelas;
    private Date dataVencimento;
    private CartaoCredito cartaoCredito;
    private FormaPagamentoEnum formaPagamento;
}
