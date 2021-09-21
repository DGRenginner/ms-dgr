package commerce.dgr.entities.pagamento;

import commerce.dgr.entities.AbstractEntity;
import commerce.dgr.enums.FormaPagamentoEnum;
import commerce.dgr.enums.StatusPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_pagamentos")
public class Pagamento extends AbstractEntity {

    @Column(name = "codigoBarras")
    private String codigoBarras;

    @Column(name = "numParcelas")
    private Integer numParcelas;

    @Column(name = "dataVencimento")
    private Date dataVencimento;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<CartaoCredito> cartaoCredito;

    @Column(name = "formaPagamento")
    @Enumerated(EnumType.STRING)
    private FormaPagamentoEnum formaPagamento;

    @Column(name = "statusPagamento")
    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum statusPagamento;
}
