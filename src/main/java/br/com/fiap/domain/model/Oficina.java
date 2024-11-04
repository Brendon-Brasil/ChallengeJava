package br.com.fiap.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Oficina {
    @JsonProperty
    private String enderecoOficina;
    @JsonProperty
    private Integer avaliacaoOficina;

    public Oficina(String enderecoOficina, Integer avaliacaoOficina) {
        this.enderecoOficina = enderecoOficina;
        this.avaliacaoOficina = avaliacaoOficina;
    }

    public Oficina() {
    }

    public String getEnderecoOficina() {
        return enderecoOficina;
    }

    public void setEnderecoOficina(String enderecoOficina) {
        this.enderecoOficina = enderecoOficina;
    }

    public Integer getAvaliacaoOficina() {
        return avaliacaoOficina;
    }

    public void setAvaliacaoOficina(Integer avaliacaoOficina) {
        this.avaliacaoOficina = avaliacaoOficina;
    }
}
