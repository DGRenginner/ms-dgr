package commerce.dgr.enums;

public enum TipoAcesso {
    FUNCIONARIO("F"),
    CLIENTE("C"),
    ADMINISTRADOR("ADM");

    public String tipo;

    TipoAcesso(String tipo) {
        this.tipo = tipo;
    }
}
