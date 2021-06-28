package com.cea.crudUsuarioAutomoveis.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cea.crudUsuarioAutomoveis.model.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataDeNascimento;

	private List<AutomovelDTO> automoveis = new ArrayList<>();

	private List<String> mensagem = new ArrayList<>();

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		cpf = entity.getCpf();
		dataDeNascimento = entity.getDataDeNascimento();
		automoveis = entity.getAutomoveis().stream().map(x -> new AutomovelDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public List<AutomovelDTO> getAutomoveis() {
		return automoveis;
	}

	public List<String> getMensagem() {
		return mensagem;
	}

}
