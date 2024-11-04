package br.com.fiap.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cliente {
    @JsonProperty
    private String nomeCliente;
    @JsonProperty
    private String emailCliente;
    @JsonProperty
    private String cpfCliente;

    public Cliente(String nomeCliente, String emailCliente, String cpfCliente) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.cpfCliente = cpfCliente;
    }

    public Cliente() {
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

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", emailCliente='" + emailCliente + '\'' +
                ", cpfCliente='" + cpfCliente + '\'' +
                '}';
    }
}
