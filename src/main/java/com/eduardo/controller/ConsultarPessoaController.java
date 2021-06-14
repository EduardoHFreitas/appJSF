package com.eduardo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.eduardo.model.PessoaModel;
import com.eduardo.repository.PessoaRepository;
 
@Named(value="consultarPessoaController")
@ViewScoped
public class ConsultarPessoaController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private PessoaModel pessoaModel;
 
	@Produces 
	private List<PessoaModel> pessoas;
 
	@Inject transient
	private PessoaRepository pessoaRepository;
 
	public List<PessoaModel> getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(List<PessoaModel> pessoas) {
		this.pessoas = pessoas;
	}		
	
	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}
	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}
 
	@PostConstruct
	public void init(){
		this.pessoas = pessoaRepository.getPessoas();
	}
}