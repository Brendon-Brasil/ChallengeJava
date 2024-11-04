package br.com.fiap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Orcamento {
    @JsonProperty
    private Double valorOrcamento;
    @JsonProperty
    protected Long idOficina;

    public Orcamento(Double valorOrcamento, Long idOficina) {
        this.valorOrcamento = valorOrcamento;
        this.idOficina = idOficina;
    }

    public Orcamento() {
    }

    public Double getValorOrcamento() {
        return valorOrcamento;
    }

    public void setValorOrcamento(Double valorOrcamento) {
        this.valorOrcamento = valorOrcamento;
    }

    public Long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
    }
}
