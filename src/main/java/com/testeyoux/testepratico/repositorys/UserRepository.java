package com.testeyoux.testepratico.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testeyoux.testepratico.models.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findByRole(String role);
	
	List<Usuario> findByCpf(String cpf);
}
