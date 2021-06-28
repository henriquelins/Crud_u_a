package com.cea.crudUsuarioAutomoveis.model;

public class FipeMarcas {
	
	private String name;
	private String fipe_name;
	private Integer order;
	private	String key;
	private String id;
	
	public FipeMarcas() {

	}

	public FipeMarcas(String name, String fipe_name, Integer order, String key, String id) {

		this.name = name;
		this.fipe_name = fipe_name;
		this.order = order;
		this.key = key;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFipe_name() {
		return fipe_name;
	}

	public void setFipe_name(String fipe_name) {
		this.fipe_name = fipe_name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
