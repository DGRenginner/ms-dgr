package commerce.dgr.entities.produtos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_itens_carrinho")
public class ItemCarrinho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PrimaryKeyJoinColumn(name = "id")
    private Long id;

    @Column(name = "id_produto")
    private Long produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @JoinColumn(name = "id_carrinho")
    private Long idCarrinho;
    // se ja existe registro com o codProduto, atualiza a quantidade

    public ItemCarrinho(Produto produto, Integer quantidade, Long idCarrinho) {
        this.produto = produto.getId();
        this.idCarrinho = idCarrinho;
        this.quantidade = quantidade;
    }
}