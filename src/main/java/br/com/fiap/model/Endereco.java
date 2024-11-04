package br.com.fiap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Endereco {
    @JsonProperty
    private String cepEndereco;
    @JsonProperty
    private Integer numEndereco;
    @JsonProperty
    private String ruaEndereco;

    public Endereco(String cepEndereco, Integer numEndereco, String ruaEndereco) {
        this.cepEndereco = cepEndereco;
        this.numEndereco = numEndereco;
        this.ruaEndereco = ruaEndereco;
    }

    public Endereco() {
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public Integer getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(Integer numEndereco) {
        this.numEndereco = numEndereco;
    }

    public String getRuaEndereco() {
        return ruaEndereco;
    }

    public void setRuaEndereco(String ruaEndereco) {
        this.ruaEndereco = ruaEndereco;
    }
}
