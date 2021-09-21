package commerce.dgr.enums;

public enum TipoAcessoEnum {
    FUNCIONARIO("F"),
    CLIENTE("C"),
    ADMINISTRADOR("ADM");

    public String tipo;

    TipoAcessoEnum(String tipo) {
        this.tipo = tipo;
    }
}
