package br.com.fiap.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteInput {
    @JsonProperty
    private String nomeCliente;
    @JsonProperty
    private String emailCliente;
    @JsonProperty
    private String cpfCliente;
    @JsonProperty
    private String senha;

    public ClienteInput(String nomeCliente, String emailCliente, String cpfCliente, String senha) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.cpfCliente = cpfCliente;
        this.senha = senha;
    }

    public ClienteInput() {
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
