package br.com.fiap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Solicitacao {
    @JsonProperty
    private Long idCliente;
    @JsonProperty
    private Long idOficina;

    public Solicitacao(Long idOficina, Long idCliente) {
        this.idOficina = idOficina;
        this.idCliente = idCliente;
    }

    public Solicitacao() {
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
    }
}
