package com.testeyoux.testepratico.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testeyoux.testepratico.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
