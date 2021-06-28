package com.cea.crudUsuarioAutomoveis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cea.crudUsuarioAutomoveis.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
