package commerce.dgr.entities.dto.login;

import commerce.dgr.entities.produtos.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class ExcluirItemCarrinhoDTO {
    private String email;
    private Produto produto;
    private Integer quantidade;

}
