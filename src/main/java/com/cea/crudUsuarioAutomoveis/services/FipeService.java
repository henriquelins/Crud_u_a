package com.cea.crudUsuarioAutomoveis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cea.crudUsuarioAutomoveis.model.FipeAutomovel;
import com.cea.crudUsuarioAutomoveis.model.FipeCodVeiculos;
import com.cea.crudUsuarioAutomoveis.model.FipeIdVeiculos;
import com.cea.crudUsuarioAutomoveis.model.FipeMarcas;
import com.cea.crudUsuarioAutomoveis.repositories.FipeRepository;

@RestController
public class FipeService {

	@Autowired
	private FipeRepository fipeRepository;

	public ResponseEntity<List<FipeMarcas>> getMarcas(@PathVariable String tipo) {

		List<FipeMarcas> fipeMarcas = fipeRepository.getMarcas(tipo);

		return fipeMarcas != null ? ResponseEntity.ok().body(fipeMarcas) : ResponseEntity.notFound().build();
	}

	public ResponseEntity<List<FipeCodVeiculos>> getModelos(@PathVariable String tipo, @PathVariable String cod_v) {

		List<FipeCodVeiculos> fipeCodVeiculos = fipeRepository.getModelos(tipo, cod_v);

		return fipeCodVeiculos != null ? ResponseEntity.ok().body(fipeCodVeiculos) : ResponseEntity.notFound().build();
	}

	public ResponseEntity<List<FipeIdVeiculos>> getAno(@PathVariable String tipo, @PathVariable String cod_v,
			@PathVariable String cod_id) {

		List<FipeIdVeiculos> fipeIdVeiculos = fipeRepository.getAno(tipo, cod_v, cod_id);

		return fipeIdVeiculos != null ? ResponseEntity.ok().body(fipeIdVeiculos) : ResponseEntity.notFound().build();
	}

	public ResponseEntity<FipeAutomovel> getPreco(@PathVariable String tipo, @PathVariable String cod_v,
			@PathVariable String cod_id, @PathVariable String ano) {

		FipeAutomovel fipeAutomovel = fipeRepository.getPreco(tipo, cod_v, cod_id, ano);

		return fipeAutomovel != null ? ResponseEntity.ok().body(fipeAutomovel) : ResponseEntity.notFound().build();
	}

}
