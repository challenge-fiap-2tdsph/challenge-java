package com.grupo.challenge_java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "USUARIO")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "O nome não pode estar em branco.")
	private String nome;
	
	@NotBlank(message = "O tipo de usuário é obrigatório.")
	private String tipo_usuario;
	
	@Email(message = "O email deve estar em formato válido.")
	@NotBlank(message = "O email é obrigatório.")
	private String email;
	
	public User () {}

	public User(Long id, String nome, String tipo_usuario, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo_usuario = tipo_usuario;
		this.email = email;
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

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
