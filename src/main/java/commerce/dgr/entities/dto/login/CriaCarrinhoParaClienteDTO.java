package commerce.dgr.entities.dto.login;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class CriaCarrinhoParaClienteDTO {
    private String email;
    private Integer quantidade;
    private Long idProduto;
}
