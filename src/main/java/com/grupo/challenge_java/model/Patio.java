package com.grupo.challenge_java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "PATIO")
public class Patio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PATIO")
    private Long id;

    @NotBlank(message = "O nome do pátio é obrigatório.")
    @Column(name = "NOME", length = 100)
    private String nome;

    @NotBlank(message = "A cidade é obrigatória.")
    @Column(name = "CIDADE", length = 100)
    private String cidade;

    @Lob
    @Column(name = "LAYOUT")
    private String layout; 
    
    public Patio () {}

	public Patio(Long id, @NotBlank(message = "O nome do pátio é obrigatório.") String nome,
			@NotBlank(message = "A cidade é obrigatória.") String cidade, String layout) {
		super();
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
