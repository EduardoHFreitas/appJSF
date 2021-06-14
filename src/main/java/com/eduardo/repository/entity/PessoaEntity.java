package com.eduardo.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@NamedQueries({
	@NamedQuery(name="PessoaEntity.findAll", query="SELECT p FROM PessoaEntity p")
})
public class PessoaEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "cadastro")
	private LocalDateTime dataCadastro;

	@Column(name = "email")
	private String email;

	@Column(name = "endereco")
	private String endereco;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuarioEntity;

	public PessoaEntity() {
	}
	
	public PessoaEntity(Integer id, String nome, String sexo, LocalDateTime dataCadastro, String email, String endereco, UsuarioEntity usuarioEntity) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataCadastro = dataCadastro;
		this.email = email;
		this.endereco = endereco;
		this.usuarioEntity = usuarioEntity;
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

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
}
