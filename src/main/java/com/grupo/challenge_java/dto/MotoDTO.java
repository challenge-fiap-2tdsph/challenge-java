package com.grupo.challenge_java.dto;

public class MotoDTO {

    private String placa;
    private String modelo;
    private Long idPatio;
    private Long idStatusMoto;
    private Integer posX;
    private Integer posY;

    public MotoDTO() {}

    public MotoDTO(String placa, String modelo, Long idPatio, Long idStatusMoto, Integer posX, Integer posY) {
        this.placa = placa;
        this.modelo = modelo;
        this.idPatio = idPatio;
        this.idStatusMoto = idStatusMoto;
        this.posX = posX;
        this.posY = posY;
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

	public Long getIdPatio() {
		return idPatio;
	}

	public void setIdPatio(Long idPatio) {
		this.idPatio = idPatio;
	}

	public Long getIdStatusMoto() {
		return idStatusMoto;
	}

	public void setIdStatusMoto(Long idStatusMoto) {
		this.idStatusMoto = idStatusMoto;
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
