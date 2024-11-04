package br.com.fiap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {
    @JsonProperty
    private String login;
    @JsonProperty
    private String senha;

    public Login(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Login() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
