package com.eduardo.model;

import java.io.Serializable;

import com.eduardo.repository.entity.UsuarioEntity;

public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String login;
	private String senha;

	public UsuarioModel() {
	}
	
	public UsuarioModel(UsuarioEntity usuarioEntity) {
		super();
		this.id = usuarioEntity.getId();
		this.login = usuarioEntity.getLogin();
		this.senha = usuarioEntity.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
