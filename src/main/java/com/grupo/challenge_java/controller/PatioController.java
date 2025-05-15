package com.grupo.challenge_java.controller;

import com.grupo.challenge_java.dto.PatioDTO;
import com.grupo.challenge_java.model.Patio;
import com.grupo.challenge_java.repository.PatioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patio")
public class PatioController {

    @Autowired
    private PatioRepository repository;

    @GetMapping("/todos")
    public List<PatioDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatioDTO> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(patio -> ResponseEntity.ok(toDTO(patio)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> criarPatio(@RequestBody @Valid PatioDTO patioDTO) {
        Patio patio = toEntity(patioDTO);
        repository.save(patio);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pátio criado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPatio(@PathVariable Long id, @RequestBody @Valid PatioDTO patioDTO) {
        return repository.findById(id)
                .map(patio -> {
                    patio.setNome(patioDTO.getNome());
                    patio.setCidade(patioDTO.getCidade());
                    patio.setLayout(patioDTO.getLayout());
                    repository.save(patio);
                    return ResponseEntity.ok("Pátio atualizado com sucesso!");
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pátio não encontrado."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPatio(@PathVariable Long id) {
        return repository.findById(id)
                .map(_ -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok("Pátio deletado com sucesso.");
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pátio não encontrado."));
    }


    private PatioDTO toDTO(Patio patio) {
        return new PatioDTO(
                patio.getId(),
                patio.getNome(),
                patio.getCidade(),
                patio.getLayout()
        );
    }

    private Patio toEntity(PatioDTO dto) {
        Patio patio = new Patio();
        patio.setNome(dto.getNome());
        patio.setCidade(dto.getCidade());
        patio.setLayout(dto.getLayout());
        return patio;
    }
}
