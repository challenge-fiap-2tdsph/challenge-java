package com.grupo.challenge_java.dto;

import jakarta.validation.constraints.NotBlank;

public class StatusMotoDTO {

    private Long id;

    @NotBlank(message = "A descrição do status é obrigatória.")
    private String descricao;

  
    public StatusMotoDTO() {
    }

   
    public StatusMotoDTO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    
}
