package commerce.dgr.enums;

public enum TipoGeneroEnum {
    MASCULINO("M"),
    FEMININO("F"),
    OUTROS("O");

    public String tipo;

    TipoGeneroEnum(String tipo) {
        this.tipo = tipo;
    }
}
