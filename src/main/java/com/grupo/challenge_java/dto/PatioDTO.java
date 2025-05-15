package com.grupo.challenge_java.dto;

import jakarta.validation.constraints.NotBlank;

public class PatioDTO {

    private Long id;

    @NotBlank(message = "O nome do pátio é obrigatório.")
    private String nome;

    @NotBlank(message = "A cidade do pátio é obrigatória.")
    private String cidade;

    private String layout;


    public PatioDTO() {
    }

    
    public PatioDTO(Long id, String nome, String cidade, String layout) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.layout = layout;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getLayout() {
		return layout;
	}


	public void setLayout(String layout) {
		this.layout = layout;
	}

   
}

