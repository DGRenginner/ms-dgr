package commerce.dgr.enums;

public enum StatusEnvioEnum {
    EM_PROCESSAMENTO("EM_PROCESSAMENTO"),
    ENVIADO("ENVIADO"),
    ENTREGUE("ENTREGUE");

    public String tipo;

    StatusEnvioEnum(String tipo) {
        this.tipo = tipo;
    }
}
