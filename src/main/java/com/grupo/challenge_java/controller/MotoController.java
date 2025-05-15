package com.grupo.challenge_java.controller;

import com.grupo.challenge_java.model.Moto;
import com.grupo.challenge_java.model.Patio;
import com.grupo.challenge_java.model.StatusMoto;
import com.grupo.challenge_java.dto.MotoDTO;
import com.grupo.challenge_java.repository.MotoRepository;
import com.grupo.challenge_java.repository.PatioRepository;
import com.grupo.challenge_java.repository.StatusMotoRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private PatioRepository patioRepository;

    @Autowired
    private StatusMotoRepository statusMotoRepository;

    
    @GetMapping
    public List<Moto> listarTodas() {
        return motoRepository.findAll();
    }

   
    @PostMapping
    public ResponseEntity<String> criarMoto(@RequestBody @Valid MotoDTO dto) {
        Patio patio = patioRepository.findById(dto.getIdPatio())
            .orElseThrow(() -> new RuntimeException("Pátio não encontrado"));
        StatusMoto status = statusMotoRepository.findById(dto.getIdStatusMoto())
            .orElseThrow(() -> new RuntimeException("Status da moto não encontrado"));

        Moto moto = new Moto();
        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setPatio(patio);
        moto.setStatusMoto(status);
        moto.setPosX(dto.getPosX());
        moto.setPosY(dto.getPosY());

        motoRepository.save(moto);

        return ResponseEntity.status(HttpStatus.CREATED).body("Moto criada com sucesso!");
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarMoto(@PathVariable Long id, @RequestBody @Valid MotoDTO atualizacao) {
        return motoRepository.findById(id)
            .map(moto -> {
                Patio patio = patioRepository.findById(atualizacao.getIdPatio())
                        .orElseThrow(() -> new RuntimeException("Pátio não encontrado"));
                StatusMoto status = statusMotoRepository.findById(atualizacao.getIdStatusMoto())
                        .orElseThrow(() -> new RuntimeException("Status da moto não encontrado"));
                
                moto.setPlaca(atualizacao.getPlaca());
                moto.setModelo(atualizacao.getModelo());
                moto.setPatio(patio);
                moto.setStatusMoto(status);
                moto.setPosX(atualizacao.getPosX());
                moto.setPosY(atualizacao.getPosY());

                motoRepository.save(moto);
                return ResponseEntity.ok("Moto atualizada com sucesso!");
            })
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Moto não encontrada."));
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMoto(@PathVariable Long id) {
        return motoRepository.findById(id)
            .map(_ -> {
                motoRepository.deleteById(id);
                return ResponseEntity.ok("Moto deletada com sucesso.");
            })
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Moto não encontrada."));
    }
    
    @GetMapping("/buscar")
    @Cacheable("motos") 
    public ResponseEntity<Page<Moto>> buscarMotos(
            @RequestParam(required = false) String placa,
            @RequestParam(defaultValue = "idMoto") String ordenarPor,
            @PageableDefault(sort = "idMoto", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Moto> motos;

        if (placa != null && !placa.isEmpty()) {
            motos = motoRepository.findByPlacaContainingIgnoreCase(placa, pageable);
        } else {
            motos = motoRepository.findAll(pageable);
        }

        return ResponseEntity.ok(motos);
    }
}
