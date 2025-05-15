package com.grupo.challenge_java.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MOTO")
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MOTO")
    private Long id;

    @Column(name = "PLACA", unique = true, nullable = false)
    private String placa;

    @Column(name = "MODELO")
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "ID_PATIO") 
    private Patio patio;

    @ManyToOne
    @JoinColumn(name = "ID_STATUS") 
    private StatusMoto statusMoto;

    @Column(name = "POS_X")
    private Integer posX;

    @Column(name = "POS_Y")
    private Integer posY;

    public Moto() {}

    public Moto(Long id, String placa, String modelo, Patio patio, StatusMoto statusMoto, Integer posX, Integer posY) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.patio = patio;
        this.statusMoto = statusMoto;
        this.posX = posX;
        this.posY = posY;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Patio getPatio() {
		return patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	public StatusMoto getStatusMoto() {
		return statusMoto;
	}

	public void setStatusMoto(StatusMoto statusMoto) {
		this.statusMoto = statusMoto;
	}

	public Integer getPosX() {
		return posX;
	}

	public void setPosX(Integer posX) {
		this.posX = posX;
	}

	public Integer getPosY() {
		return posY;
	}

	public void setPosY(Integer posY) {
		this.posY = posY;
	}

    
}
