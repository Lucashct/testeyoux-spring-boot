package com.testeyoux.testepratico.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeyoux.testepratico.enums.StatusResponse;
import com.testeyoux.testepratico.models.Usuario;
import com.testeyoux.testepratico.repositorys.UserRepository;
import com.testeyoux.testepratico.util.Response;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Response listEnfermeiros() {
		Response response = new Response();
		Usuario item = null;;
		List<Usuario> filteredList = new ArrayList<Usuario>();
		
		List<Usuario> listUsers = userRepository.findByRole("ENFERMEIRO");
		
		for(Usuario usuario : listUsers) {
			item = new Usuario();
			
			item.setId(usuario.getId());
			item.setCpf(usuario.getCpf());
			item.setName(usuario.getName());
			item.setRole(usuario.getRole());
			
			filteredList.add(item);			
		}
		
		response.setStatus(StatusResponse.SUCCESS);
		response.setList(filteredList);
		response.setMessage("Enfermeiros listados com sucesso!");
		
		return response;
	}
	
	public Response createUser(Usuario user) {
		Response response = new Response();
		
		List<Usuario> listUserSearch = userRepository.findByCpf(user.getCpf());
		
		if(listUserSearch.size() > 0) {
			response.setStatus(StatusResponse.FAIL);
			response.setMessage("Esse CPF já está cadastrado!");
			return response;
		}
		
		response.setStatus(StatusResponse.SUCCESS);
		response.setItem(userRepository.save(user));
		switch(user.getRole()) {
		case "ENFERMEIRO":
			response.setMessage("Enfermeiro criado com sucesso!");
			break;
		case "MEDICO":
			response.setMessage("Médico criado com sucesso!");
			break;
		}
		
		return response;
	}
	
	public Response updateUser(Usuario user) {
		Response response = new Response();
		
		response.setStatus(StatusResponse.SUCCESS);
		response.setItem(userRepository.save(user));
		switch(user.getRole()) {
		case "ENFERMEIRO":
			response.setMessage("Enfermeiro atualizado com sucesso!");
			break;
		case "MEDICO":
			response.setMessage("Médico atualizado com sucesso!");
			break;
		}
		
		return response;
	}
	
	public Response removeUser(Usuario user) {
		Response response = new Response();
		
		userRepository.deleteById(user.getId());
		
		response.setStatus(StatusResponse.SUCCESS);
		switch(user.getRole()) {
		case "ENFERMEIRO":
			response.setMessage("Enfermeiro removido com sucesso!");
			break;
		case "MEDICO":
			response.setMessage("Médico removido com sucesso!");
			break;
		}
		
		return response;
	}
	
	public Response login(Usuario user) {
		Response response = new Response();
		Usuario usuarioLogin;
		
		List<Usuario> userSearched = userRepository.findByCpf(user.getCpf());
		if(userSearched.size() > 0) {
			usuarioLogin = userSearched.get(0);
		} else {
			usuarioLogin = new Usuario();
		}
		
		if(userSearched.size() == 0) {
			response.setStatus(StatusResponse.FAIL);
			response.setMessage("CPF ou senha inválida");
			return response;
		} else if(usuarioLogin.getCpf().equals(user.getCpf()) && usuarioLogin.getPassword().equals(user.getPassword())) {
			response.setStatus(StatusResponse.SUCCESS);
			response.setItem(usuarioLogin);
			response.setMessage("Login realizado com Sucesso");
			return response;
		} else {
			response.setStatus(StatusResponse.FAIL);
			response.setMessage("CPF ou senha inválida");
			
			return response;
		}
	}
}
