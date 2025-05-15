package com.grupo.challenge_java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import jakarta.validation.Valid;




import com.grupo.challenge_java.model.User;
import com.grupo.challenge_java.repository.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserRepository repi;
	
	@GetMapping(value = "/todos")
	public List<User> retornaTodosUsers(){
		return repi.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> buscarPorId(@PathVariable Long id) {
	    return repi.findById(id)
	        .map(ResponseEntity::ok)
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<String> criarUsuario(@RequestBody @Valid User user) {
	    repi.save(user);
	    return ResponseEntity.status(HttpStatus.CREATED)
	        .body("Usuário criado com sucesso!");
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid User atualizacao) {
	    return repi.findById(id)
	        .map(user -> {
	            user.setNome(atualizacao.getNome());
	            user.setTipo_usuario(atualizacao.getTipo_usuario());
	            user.setEmail(atualizacao.getEmail());
	            repi.save(user);
	            return ResponseEntity.ok("Usuário atualizado com sucesso.");
	        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado."));
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
	    Optional<User> optional = repi.findById(id);
	    if (optional.isPresent()) {
	        repi.deleteById(id);
	        return ResponseEntity.ok("Usuário deletado com sucesso.");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
	    }
	}



}
