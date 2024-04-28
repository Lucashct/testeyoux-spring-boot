package com.testeyoux.testepratico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeyoux.testepratico.enums.StatusResponse;
import com.testeyoux.testepratico.models.Paciente;
import com.testeyoux.testepratico.repositorys.PacienteRepository;
import com.testeyoux.testepratico.util.Response;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Response listAllPacientes() {
		Response response = new Response();
		
		response.setStatus(StatusResponse.SUCCESS);
		response.setList(pacienteRepository.findAll());
		response.setMessage("Pacientes listados com sucesso!");
		
		return response;
	}
	
	public Response createPaciente(Paciente paciente) {
		Response response = new Response();

		response.setStatus(StatusResponse.SUCCESS);
		response.setItem(pacienteRepository.save(paciente));
		response.setMessage("Paciente cadastrado com sucesso!");
		
		return response;
	}
	
	public Response updatePaciente(Paciente paciente) {
		Response response = new Response();

		response.setStatus(StatusResponse.SUCCESS);
		response.setItem(pacienteRepository.save(paciente));
		response.setMessage("Paciente atualizado com sucesso!");
		
		return response;
	}
	
	public Response removePaciente(Paciente paciente) {
		Response response = new Response();
		
		pacienteRepository.deleteById(paciente.getId());
		
		response.setStatus(StatusResponse.SUCCESS);
		response.setMessage("Paciente removido com sucesso!");
		
		return response;
	}
	
}
