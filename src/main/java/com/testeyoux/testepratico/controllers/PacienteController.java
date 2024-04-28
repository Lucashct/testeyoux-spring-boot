package com.testeyoux.testepratico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testeyoux.testepratico.models.Paciente;
import com.testeyoux.testepratico.services.PacienteService;
import com.testeyoux.testepratico.util.Response;

@RestController
@CrossOrigin(origins = "*")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;

	@GetMapping("paciente/list")
	public Response list() {
		return pacienteService.listAllPacientes();
	}
	
	@PostMapping("paciente/create")
	public Response create(@RequestBody Paciente paciente) {
		return pacienteService.createPaciente(paciente);
	}
	
	@PutMapping("paciente/update")
	public Response update(@RequestBody Paciente paciente) {
		return pacienteService.updatePaciente(paciente);
	}
	
	@PostMapping("paciente/remove")
	public Response remove(@RequestBody Paciente paciente) {
		return pacienteService.removePaciente(paciente);
	}
}
