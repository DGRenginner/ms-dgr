package commerce.dgr.entities.pedidos;

import commerce.dgr.entities.AbstractEntity;
import commerce.dgr.entities.produtos.Carrinho;
import commerce.dgr.enums.TipoEnvioEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tb_pedidos")
public class Pedido extends AbstractEntity {

    private Long codigoCliente;
    private Carrinho carrinho;
    private TipoEnvioEnum tipoEnvioEnum;
    //forma pagamento
    //dataHora
}
