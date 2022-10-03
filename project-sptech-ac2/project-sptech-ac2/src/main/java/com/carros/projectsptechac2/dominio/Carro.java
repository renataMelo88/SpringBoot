package com.carros.projectsptechac2.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
public class Carro {

    @Id  // do javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarro;

    @Size(min = 2, max = 12) // "modelo": é obrigatório e deve ter pelo menos 2 e no máximo 12 letras
    private String modelo;

    @Size(min = 2, max = 10)
    private String fabricante;  // "fabricante": é obrigatório e deve ter pelo menos 2 e no máximo 10 letras

    @PastOrPresent
    private LocalDate dataFabricacao;  //"dataFabricacao": data com valor de hoje ou data passada. Não é obrigatório


    @Min(1960) @Max(2021)
    private LocalDate anoFabricacao;  // "anoFabricacao": valor inteiro, com valor mínimo de 1960 e máximo de 2021. Campo obrigatório

    @DecimalMin("0.2") @DecimalMax("7.0")
    private Double potenciaMotor;   // "potenciaMotor": valor real, com mínimo 0.2 e máximo 7.0. Campo obrigatório

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(LocalDate anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Double getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(Double potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }
}
