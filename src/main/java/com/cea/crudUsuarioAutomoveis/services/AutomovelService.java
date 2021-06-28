package com.cea.crudUsuarioAutomoveis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cea.crudUsuarioAutomoveis.dto.AutomovelDTO;
import com.cea.crudUsuarioAutomoveis.model.Automovel;
import com.cea.crudUsuarioAutomoveis.repositories.AutomovelRepository;

@Service
public class AutomovelService {

	@Autowired
	private AutomovelRepository automovelRepository;

	@Transactional
	public AutomovelDTO insert(AutomovelDTO dto) {
		Automovel automovel = new Automovel(null, dto.getMarca(), dto.getModelo(), dto.getAno(), dto.getPrecoFipe());
		automovel = automovelRepository.save(automovel);
		return new AutomovelDTO(automovel);
	}

}
