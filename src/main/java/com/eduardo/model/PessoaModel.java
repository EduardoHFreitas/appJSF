package com.eduardo.model;

import java.time.LocalDateTime;

public class PessoaModel {

	private Integer codigo;
	private String nome;
	private String sexo;
	private LocalDateTime dataCadastro;
	private String email;
	private String endereco;
	private UsuarioModel usuarioModel;

	public PessoaModel() {
	}
	
	public PessoaModel(Integer codigo, String nome, String sexo, LocalDateTime dataCadastro, String email, String endereco, UsuarioModel usuarioModel) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sexo = sexo;
		this.dataCadastro = dataCadastro;
		this.email = email;
		this.endereco = endereco;
		this.usuarioModel = usuarioModel;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
}