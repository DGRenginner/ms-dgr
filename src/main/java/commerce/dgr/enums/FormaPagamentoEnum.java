package commerce.dgr.enums;

public enum FormaPagamentoEnum {
    DEBITO("DEBITO"),
    CREDITO("CREDITO"),
    BOLETO("BOLETO"),
    PIX("PIX");

    public String tipo;

    FormaPagamentoEnum(String tipo) {
        this.tipo = tipo;
    }
}
