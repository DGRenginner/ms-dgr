package commerce.dgr.entities;

public enum ServiceConstants {
    ERRO_USUARIO_NAO_ENCONTRADO("Não foi encontrado nenhum usuário com email"),
    ERRO_EMAIL_JA_POSSUI_CADASTRO("Email já possui cadastro"),
    ERRO_SENHA_INCORRETA("Senha incorreta!"),
    ERRO_EMAIL_NAO_ENCONTRADO("Email não encontrado. Faça seu cadastro!");


    public String mensagemErro;

    ServiceConstants(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

}
