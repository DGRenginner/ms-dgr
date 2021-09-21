package commerce.dgr.enums;

public enum StatusPedidoEnum {
    EM_SEPARACAO(1),
    POSTADO(2),
    ENTREGUE(3);

    public Integer tipo;

    StatusPedidoEnum(Integer tipo) {
        this.tipo = tipo;
    }
}
