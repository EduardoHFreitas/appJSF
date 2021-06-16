package com.eduardo.model;

import java.time.LocalDateTime;

import com.eduardo.repository.entity.PessoaEntity;

public class PessoaModel {

	private Integer id;
	private String nome;
	private String sexo;
	private LocalDateTime dataCadastro;
	private String email;
	private String endereco;
	private UsuarioModel usuarioModel;

	public PessoaModel() {
	}
	
	public PessoaModel(Integer id, String nome, String sexo, LocalDateTime dataCadastro, String email, String endereco, UsuarioModel usuarioModel) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataCadastro = dataCadastro;
		this.email = email;
		this.endereco = endereco;
		this.usuarioModel = usuarioModel;
	}

	public PessoaModel(PessoaEntity pessoaEntity) {
		super();
		this.id = pessoaEntity.getId();
		this.nome = pessoaEntity.getNome();
		this.sexo = pessoaEntity.getSexo();
		this.dataCadastro = pessoaEntity.getDataCadastro();
		this.email = pessoaEntity.getEmail();
		this.endereco = pessoaEntity.getEndereco();
		this.usuarioModel = new UsuarioModel(pessoaEntity.getUsuarioEntity());		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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