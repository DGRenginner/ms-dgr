package commerce.dgr.component;

import commerce.dgr.entities.dto.login.LoginDTO;
import commerce.dgr.entities.pedidos.Pedido;
import commerce.dgr.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoComponent {
    private final PedidoRepository pedidoRepository;

    public Pedido adicionarProdutosAoCarrinho(LoginDTO loginDTO){
        return new Pedido();
    }


}
