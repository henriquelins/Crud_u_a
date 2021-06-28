package com.cea.crudUsuarioAutomoveis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cea.crudUsuarioAutomoveis.dto.AutomovelDTO;
import com.cea.crudUsuarioAutomoveis.model.FipeAutomovel;
import com.cea.crudUsuarioAutomoveis.model.FipeCodVeiculos;
import com.cea.crudUsuarioAutomoveis.model.FipeIdVeiculos;
import com.cea.crudUsuarioAutomoveis.model.FipeMarcas;
import com.cea.crudUsuarioAutomoveis.services.AutomovelService;
import com.cea.crudUsuarioAutomoveis.services.FipeService;

@RestController
@RequestMapping(value = "/automoveis")
public class AutomovelController {

	@Autowired
	private AutomovelService service;

	@Autowired
	private FipeService fipeservice;

	@PostMapping
	public ResponseEntity<AutomovelDTO> insert(@RequestBody AutomovelDTO dto) {

		ResponseEntity<List<FipeMarcas>> fipeMarcas = fipeservice.getMarcas("carros");

		String marca_id = "";
		String modelo_id = "";
		String ano_id = "";

		for (FipeMarcas f : fipeMarcas.getBody()) {

			if (f.getFipe_name().equals(dto.getMarca())) {
				marca_id = f.getId();
			}

		}

		ResponseEntity<List<FipeCodVeiculos>> fipeCodVeiculos = fipeservice.getModelos("carros", marca_id);

		for (FipeCodVeiculos f : fipeCodVeiculos.getBody()) {

			if (f.getFipe_name().equals(dto.getModelo())) {
				modelo_id = f.getId();
			}

		}

		ResponseEntity<List<FipeIdVeiculos>> fipeIdVeiculos = fipeservice.getAno("carros", marca_id, modelo_id);

		for (FipeIdVeiculos f : fipeIdVeiculos.getBody()) {

			if (f.getVeiculo().equals(dto.getModelo())) {
				ano_id = f.getId();
			}

		}

		ResponseEntity<FipeAutomovel> fipe = fipeservice.getPreco("carros", marca_id, modelo_id, ano_id);

		dto.setPrecoFipe(fipe.getBody().getPreco());

		dto = service.insert(dto);

		if (dto != null) {
			return new ResponseEntity<AutomovelDTO>(dto, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
