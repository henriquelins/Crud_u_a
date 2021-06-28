package com.cea.crudUsuarioAutomoveis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cea.crudUsuarioAutomoveis.model.Automovel;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {

}
