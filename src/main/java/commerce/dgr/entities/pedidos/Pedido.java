package commerce.dgr.entities.pedidos;

import commerce.dgr.entities.AbstractEntity;
import commerce.dgr.entities.pagamento.Pagamento;
import commerce.dgr.entities.pagamento.Promocao;
import commerce.dgr.entities.personas.Cliente;
import commerce.dgr.entities.produtos.Carrinho;
import commerce.dgr.enums.StatusEnvioEnum;
import commerce.dgr.enums.StatusPedidoEnum;
import commerce.dgr.enums.TipoEnvioEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_pedidos")
public class Pedido extends AbstractEntity {

    @Column(name = "statusPedido")
    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum statusPedido;

    @Column(name = "dataHora")
    private LocalDate dataHora;

    @Column(name = "pagamento")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "promocaoCodigo")
    private Promocao promocao;

    @OneToOne
    @JoinColumn(name = "pedido_carrinho")
    private Carrinho carrinho;

    @Column(name = "valorFrete")
    private BigDecimal valorFrete;

    @Column(name = "tipoEnvio")
    @Enumerated(EnumType.STRING)
    private TipoEnvioEnum tipoEnvio;

    @Column(name = "statusEnvio")
    @Enumerated(EnumType.STRING)
    private StatusEnvioEnum statusEnvio;

    @ManyToOne
    @JoinColumn(name = "clienteCodigo")
    private Cliente cliente;
}