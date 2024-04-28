package com.testeyoux.testepratico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testeyoux.testepratico.services.UserService;
import com.testeyoux.testepratico.util.Response;
import com.testeyoux.testepratico.models.Usuario;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("usuario/create")
	public Response createUser(@RequestBody Usuario user) {
		return userService.createUser(user);
	}
	
	@GetMapping("usuario/list")
	public Response listUsers() {
		return userService.listEnfermeiros();
	}
	
	@PutMapping("usuario/update")
	public Response updateUser(@RequestBody Usuario user) {
		return userService.updateUser(user);
	}
	
	@PostMapping("usuario/remove")
	public Response removeUser(@RequestBody Usuario user) {
		return userService.removeUser(user);
	}
	
	@PostMapping("usuario/login")
	public Response login(@RequestBody Usuario user) {
		return userService.login(user);
	}
}
