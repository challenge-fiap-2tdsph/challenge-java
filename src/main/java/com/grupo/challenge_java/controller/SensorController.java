package com.grupo.challenge_java.controller;

import com.grupo.challenge_java.dto.SensorDTO;
import com.grupo.challenge_java.model.Moto;
import com.grupo.challenge_java.model.Sensor;
import com.grupo.challenge_java.repository.SensorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    private SensorRepository repository;

    @GetMapping("/todos")
    public List<SensorDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorDTO> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(sensor -> ResponseEntity.ok(toDTO(sensor)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> criarSensor(@RequestBody @Valid SensorDTO sensorDTO) {
        Sensor sensor = toEntity(sensorDTO);
        repository.save(sensor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sensor criado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarSensor(@PathVariable Long id, @RequestBody @Valid SensorDTO sensorDTO) {
        return repository.findById(id)
                .map(sensor -> {
                    sensor.setTemperatura(sensorDTO.getTemperatura());
                    sensor.setLigada(sensorDTO.getLigada());
                    
                    Moto moto = new Moto();
                    moto.setId(sensorDTO.getIdMoto());
                    sensor.setMoto(moto);

                    repository.save(sensor);
                    return ResponseEntity.ok("Sensor atualizado com sucesso!");
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sensor não encontrado."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarSensor(@PathVariable Long id) {
        return repository.findById(id)
                .map(_ -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok("Sensor deletado com sucesso.");
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sensor não encontrado."));
    }


    private SensorDTO toDTO(Sensor sensor) {
        return new SensorDTO(
                sensor.getId(),
                sensor.getMoto() != null ? sensor.getMoto().getId() : null,
                sensor.getTemperatura(),
                sensor.getLigada()
        );
    }

    private Sensor toEntity(SensorDTO dto) {
        Sensor sensor = new Sensor();
        Moto moto = new Moto();
        moto.setId(dto.getIdMoto());
        sensor.setMoto(moto);
        sensor.setTemperatura(dto.getTemperatura());
        sensor.setLigada(dto.getLigada());
        return sensor;
    }
}
