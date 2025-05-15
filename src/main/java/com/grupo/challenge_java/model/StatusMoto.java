package com.grupo.challenge_java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "STATUS_MOTO")
public class StatusMoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STATUS")
	private Long id;
    
    @NotBlank(message = "A descrição do status é obrigatória.")
    @Column(name = "DESCRICAO", length = 50)
    private String descricao;
    
  
    public StatusMoto () {}

	public StatusMoto(Long id, @NotBlank(message = "A descrição do status é obrigatória.") String descricao) {
		super();
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
	
	
    
    
    
    

   
