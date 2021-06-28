package com.cea.crudUsuarioAutomoveis.controller;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cea.crudUsuarioAutomoveis.dto.AutomovelDTO;
import com.cea.crudUsuarioAutomoveis.dto.UsuarioDTO;
import com.cea.crudUsuarioAutomoveis.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO dto) {
		dto = usuarioService.insert(dto);

		if (dto != null) {
			return new ResponseEntity<UsuarioDTO>(dto, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> findOne(@PathVariable Long id) {

		Optional<UsuarioDTO> dto = Optional.of(usuarioService.findOne(id));

		Calendar agora = Calendar.getInstance();
		String hoje = diaDaSemana(agora);

		String mensagem = "";
		String numerosFinais = "";
		String diaRodizioCarro = "";
		boolean atributo = false;
		String erro = "Nenhum resultado encontrado. Tente verificar a ortografia";

		for (AutomovelDTO a : dto.get().getAutomoveis()) {

			numerosFinais = a.getAno().substring(3, 4);
			diaRodizioCarro = diaRodizio(numerosFinais);
			atributo = atributoRodizio(hoje, diaRodizioCarro);

			mensagem = "hoje é " + hoje + ", o carro é da marca " + a.getMarca() + ", modelo " + a.getModelo()
					+ " do ano de " + a.getAno().substring(0, 4) + ", ou seja, seu rodízio será às " + diaRodizioCarro
					+ " e o atributo de rodízio ativo será " + atributo + ".";

			dto.get().getMensagem().add(mensagem);

		}

		if (dto.isPresent()) {
			return new ResponseEntity<UsuarioDTO>(dto.get(), HttpStatus.OK);
		} else {
			dto.get().getMensagem().add(erro);
			return new ResponseEntity<UsuarioDTO>(dto.get(), HttpStatus.NOT_FOUND);
		}

	}

	public String diaRodizio(String numerosFinais) {

		String dia = "";

		if (numerosFinais.equalsIgnoreCase("0") || numerosFinais.equalsIgnoreCase("1")) {
			dia = "segunda-feira";
		} else if (numerosFinais.equalsIgnoreCase("2") || numerosFinais.equalsIgnoreCase("3")) {
			dia = "terça-feira";
		} else if (numerosFinais.equalsIgnoreCase("4") || numerosFinais.equalsIgnoreCase("5")) {
			dia = "quarta-feira";
		} else if (numerosFinais.equalsIgnoreCase("6") || numerosFinais.equalsIgnoreCase("7")) {
			dia = "quinta-feira";
		} else if (numerosFinais.equalsIgnoreCase("8") || numerosFinais.equalsIgnoreCase("9")) {
			dia = "sexta-feira";
		} else {
			dia = "Parâmetro inválido, verifique a ortografia!";
		}
		return dia;

	}

	public static String diaDaSemana(Calendar cal) {
		return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
	}

	public boolean atributoRodizio(String hoje, String diaRodizio) {
		boolean atributo = false;
		if (hoje == diaRodizio) {
			atributo = true;
		} else {
			atributo = false;
		}
		return atributo;
	}

}
