package commerce.dgr.enums;

public enum StatusPagamentoEnum {
    EM_ANALISE(1),
    APROVADO(2),
    RECUSADO(3);

    public Integer tipo;

    StatusPagamentoEnum(Integer tipo) {
        this.tipo = tipo;
    }
}
