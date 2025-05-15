package com.grupo.challenge_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo.challenge_java.model.Moto;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MotoRepository extends JpaRepository<Moto, Long> {

    Page<Moto> findByPlacaContainingIgnoreCase(String placa, Pageable pageable);

}