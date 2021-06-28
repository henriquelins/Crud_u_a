package com.cea.crudUsuarioAutomoveis.dto;

import com.cea.crudUsuarioAutomoveis.model.Automovel;

public class AutomovelDTO {

	private Long id;
	private String marca;
	private String modelo;
	private String ano;
	private String precoFipe;

	public AutomovelDTO() {
	}

	public AutomovelDTO(Automovel entity) {
		id = entity.getId();
		marca = entity.getMarca();
		modelo = entity.getModelo();
		ano = entity.getAno();
		precoFipe = entity.getPrecoFipe();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPrecoFipe() {
		return precoFipe;
	}

	public void setPrecoFipe(String precoFipe) {
		this.precoFipe = precoFipe;
	}
}
