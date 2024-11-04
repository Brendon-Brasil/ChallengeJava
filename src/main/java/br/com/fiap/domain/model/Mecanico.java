package br.com.fiap.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mecanico {
    @JsonProperty
    private String nomeMecanico;
    @JsonProperty
    private Long idOficina;

    public Mecanico(String nomeMecanico, Long idOficina) {
        this.nomeMecanico = nomeMecanico;
        this.idOficina = idOficina;
    }

    public Mecanico() {
    }

    public String getNomeMecanico() {
        return nomeMecanico;
    }

    public void setNomeMecanico(String nomeMecanico) {
        this.nomeMecanico = nomeMecanico;
    }

    public Long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
    }
}
