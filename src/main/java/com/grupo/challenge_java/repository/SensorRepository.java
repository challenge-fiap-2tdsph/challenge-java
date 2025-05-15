package com.grupo.challenge_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo.challenge_java.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

}
