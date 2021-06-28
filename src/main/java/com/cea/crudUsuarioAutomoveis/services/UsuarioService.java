package com.cea.crudUsuarioAutomoveis.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cea.crudUsuarioAutomoveis.dto.AutomovelDTO;
import com.cea.crudUsuarioAutomoveis.dto.UsuarioDTO;
import com.cea.crudUsuarioAutomoveis.model.Automovel;
import com.cea.crudUsuarioAutomoveis.model.Usuario;
import com.cea.crudUsuarioAutomoveis.repositories.AutomovelRepository;
import com.cea.crudUsuarioAutomoveis.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AutomovelRepository automovelRepository;

	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		Usuario usuario = new Usuario(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getDataDeNascimento());

		for (AutomovelDTO automovelDTO : dto.getAutomoveis()) {
			Automovel automovel = automovelRepository.getById(automovelDTO.getId());
			usuario.getAutomoveis().add(automovel);
		}

		usuario = usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);
	}

	@Transactional(readOnly = true)
	public UsuarioDTO findOne(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return new UsuarioDTO(usuario.get());
	}

}
