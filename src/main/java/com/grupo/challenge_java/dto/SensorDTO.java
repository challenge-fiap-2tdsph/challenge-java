package com.grupo.challenge_java.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class SensorDTO {

    private Long id;

    @NotNull(message = "O ID da moto é obrigatório.")
    private Long idMoto;

    private Double temperatura;

    @Pattern(regexp = "S|N", message = "O valor de ligada deve ser 'S' ou 'N'.")
    private String ligada;

    
    public SensorDTO() {
    }

   
    public SensorDTO(Long id, Long idMoto, Double temperatura, String ligada) {
        this.id = id;
        this.idMoto = idMoto;
        this.temperatura = temperatura;
        this.ligada = ligada;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdMoto() {
		return idMoto;
	}


	public void setIdMoto(Long idMoto) {
		this.idMoto = idMoto;
	}


	public Double getTemperatura() {
		return temperatura;
	}


	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}


	public String getLigada() {
		return ligada;
	}


	public void setLigada(String ligada) {
		this.ligada = ligada;
	}

    
    
}
