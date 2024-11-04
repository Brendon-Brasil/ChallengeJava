package br.com.fiap.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Guincho {
    @JsonProperty
    private String carroCliente;
    @JsonProperty
    private String placaGuincho;
    @JsonProperty
    private Long idOficina;

    public Guincho(String carroCliente, String placaGuincho, Long idOficina) {
        this.carroCliente = carroCliente;
        this.placaGuincho = placaGuincho;
        this.idOficina = idOficina;
    }

    public Guincho() {
    }

    public String getCarroCliente() {
        return carroCliente;
    }

    public void setCarroCliente(String carroCliente) {
        this.carroCliente = carroCliente;
    }

    public String getPlacaGuincho() {
        return placaGuincho;
    }

    public void setPlacaGuincho(String placaGuincho) {
        this.placaGuincho = placaGuincho;
    }

    public Long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
    }
}
