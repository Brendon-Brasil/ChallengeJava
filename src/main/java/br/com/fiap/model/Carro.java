package br.com.fiap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Carro {
    @JsonProperty
    private String modeloCarro;
    @JsonProperty
    private Integer anoCarro;
    @JsonProperty
    private String marcaCarro;
    @JsonProperty
    private String placaCarro;
    @JsonProperty
    private Long idCliente;

    public Carro(String modeloCarro, Integer anoCarro, String marcaCarro, String placaCarro, Long idCliente) {
        this.modeloCarro = modeloCarro;
        this.anoCarro = anoCarro;
        this.marcaCarro = marcaCarro;
        this.placaCarro = placaCarro;
        this.idCliente = idCliente;
    }

    public Carro() {
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public Integer getAnoCarro() {
        return anoCarro;
    }

    public void setAnoCarro(Integer anoCarro) {
        this.anoCarro = anoCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
