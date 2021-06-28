package com.cea.crudUsuarioAutomoveis.repositories;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cea.crudUsuarioAutomoveis.model.FipeAutomovel;
import com.cea.crudUsuarioAutomoveis.model.FipeCodVeiculos;
import com.cea.crudUsuarioAutomoveis.model.FipeIdVeiculos;
import com.cea.crudUsuarioAutomoveis.model.FipeMarcas;

@Service
@FeignClient(url = "https://fipeapi.appspot.com/api/1", name = "FipeService")
public interface FipeRepository {

	@GetMapping("/{tipo}/marcas.json")
	public List<FipeMarcas> getMarcas(@PathVariable String tipo);

	@GetMapping("/{tipo}/veiculos/{cod_v}.json")
	public List<FipeCodVeiculos> getModelos(@PathVariable String tipo, @PathVariable String cod_v);

	@GetMapping("/{tipo}/veiculo/{cod_v}/{cod_id}.json")
	public List<FipeIdVeiculos> getAno(@PathVariable String tipo, @PathVariable String cod_v,
			@PathVariable String cod_id);

	@GetMapping("/{tipo}/veiculo/{cod_v}/{cod_id}/{ano}.json")
	public FipeAutomovel getPreco(@PathVariable String tipo, @PathVariable String cod_v, @PathVariable String cod_id,
			@PathVariable String ano);

}
