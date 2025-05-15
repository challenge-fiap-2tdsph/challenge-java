package com.grupo.challenge_java.controller;

import com.grupo.challenge_java.dto.StatusMotoDTO;
import com.grupo.challenge_java.model.StatusMoto;
import com.grupo.challenge_java.repository.StatusMotoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/status")
public class StatusMotoController {

    @Autowired
    private StatusMotoRepository repository;

    @GetMapping("/todos")
    public List<StatusMotoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusMotoDTO> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(status -> ResponseEntity.ok(toDTO(status)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> criarStatus(@RequestBody @Valid StatusMotoDTO statusDTO) {
        StatusMoto status = toEntity(statusDTO);
        repository.save(status);
        return ResponseEntity.status(HttpStatus.CREATED).body("Status de moto criado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarStatus(@PathVariable Long id, @RequestBody @Valid StatusMotoDTO statusDTO) {
        return repository.findById(id)
                .map(status -> {
                    status.setDescricao(statusDTO.getDescricao());
                    repository.save(status);
                    return ResponseEntity.ok("Status de moto atualizado com sucesso!");
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Status de moto não encontrado."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarStatus(@PathVariable Long id) {
        return repository.findById(id)
                .map(_ -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok("Status de moto deletado com sucesso.");
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Status de moto não encontrado."));
    }

 

    private StatusMotoDTO toDTO(StatusMoto status) {
        return new StatusMotoDTO(
                status.getId(),
                status.getDescricao()
        );
    }

    private StatusMoto toEntity(StatusMotoDTO dto) {
        StatusMoto status = new StatusMoto();
        status.setDescricao(dto.getDescricao());
        return status;
    }
}
