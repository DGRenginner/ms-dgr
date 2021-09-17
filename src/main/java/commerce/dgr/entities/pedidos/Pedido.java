package commerce.dgr.entities.pedidos;

import commerce.dgr.entities.AbstractEntity;
import commerce.dgr.entities.pagamento.Pagamento;
import commerce.dgr.entities.pagamento.Promocao;
import commerce.dgr.entities.produtos.Carrinho;
import commerce.dgr.enums.StatusPedidoEnum;
import commerce.dgr.enums.TipoEnvioEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_pedidos")
public class Pedido extends AbstractEntity {

    private Long codigoCliente;
    private Carrinho carrinho;
    private FormaEnvio formaEnvio;
    private StatusPedidoEnum statusPedido;
    private LocalDate dataHora;
    private Pagamento pagamento;
    private Promocao promocao;

}