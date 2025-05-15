package com.grupo.challenge_java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "SENSOR")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SENSOR")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_MOTO")
    private Moto moto;

    @Column(name = "TEMPERATURA")
    private Double temperatura;

    @NotNull(message = "O estado ligada/desligada é obrigatório.")
    @Pattern(regexp = "S|N", message = "O valor de ligada deve ser 'S' ou 'N'.")
    @Column(name = "LIGADA", length = 1)
    private String ligada;

   public Sensor () {}

	public Sensor(Long id, Moto moto, Double temperatura,
			@NotNull(message = "O estado ligada/desligada é obrigatório.") @Pattern(regexp = "S|N", message = "O valor de ligada deve ser 'S' ou 'N'.") String ligada) {
		super();
		this.id = id;
		this.moto = moto;
		this.temperatura = temperatura;
		this.ligada = ligada;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Moto getMoto() {
		return moto;
	}
	
	public void setMoto(Moto moto) {
		this.moto = moto;
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
