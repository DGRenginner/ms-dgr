package commerce.dgr.entities.pedidos;

import commerce.dgr.entities.AbstractEntity;
import commerce.dgr.enums.StatusEnvioEnum;
import commerce.dgr.enums.TipoEnvioEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FormaEnvio extends AbstractEntity {
    private BigDecimal valorFrete;
    private TipoEnvioEnum tipoEnvio;
    private StatusEnvioEnum statusEnvio;
}
