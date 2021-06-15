package com.eduardo.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.eduardo.model.PessoaModel;
import com.eduardo.model.UsuarioModel;
import com.eduardo.repository.entity.PessoaEntity;
import com.eduardo.repository.entity.UsuarioEntity;
import com.eduardo.uteis.Uteis;

public class PessoaRepository {

	@Inject
	PessoaEntity pessoaEntity;

	EntityManager entityManager;

	public void salvarNovoRegistro(PessoaModel pessoaModel) {

		entityManager = Uteis.JpaEntityManager();

		pessoaEntity = new PessoaEntity();
		pessoaEntity.setDataCadastro(LocalDateTime.now());
		pessoaEntity.setEmail(pessoaModel.getEmail());
		pessoaEntity.setEndereco(pessoaModel.getEndereco());
		pessoaEntity.setNome(pessoaModel.getNome());
		pessoaEntity.setSexo(pessoaModel.getSexo());

		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, pessoaModel.getUsuarioModel().getId());

		pessoaEntity.setUsuarioEntity(usuarioEntity);

		entityManager.persist(pessoaEntity);
	}

	public List<PessoaModel> getPessoas() {
		List<PessoaModel> pessoasModel = new ArrayList<>();

		entityManager = Uteis.JpaEntityManager();

		Query query = entityManager.createNamedQuery("PessoaEntity.findAll");

		@SuppressWarnings("unchecked")
		Collection<PessoaEntity> pessoasEntity = (Collection<PessoaEntity>) query.getResultList();

		PessoaModel pessoaModel = null;

		for (PessoaEntity pessoaEntity : pessoasEntity) {

			pessoaModel = new PessoaModel();
			pessoaModel.setId(pessoaEntity.getId());
			pessoaModel.setDataCadastro(pessoaEntity.getDataCadastro());
			pessoaModel.setEmail(pessoaEntity.getEmail());
			pessoaModel.setEndereco(pessoaEntity.getEndereco());
			pessoaModel.setNome(pessoaEntity.getNome());

			if (pessoaEntity.getSexo().equals("M")) {
				pessoaModel.setSexo("Masculino");
			} else {
				pessoaModel.setSexo("Feminino");
			}

			UsuarioEntity usuarioEntity = pessoaEntity.getUsuarioEntity();

			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setLogin(usuarioEntity.getLogin());

			pessoaModel.setUsuarioModel(usuarioModel);

			pessoasModel.add(pessoaModel);
		}

		return pessoasModel;
	}
	
	private PessoaEntity getPessoa(int id){
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(PessoaEntity.class, id);
	}
 
	public void alterarRegistro(PessoaModel pessoaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		PessoaEntity pessoaEntity = this.getPessoa(pessoaModel.getId());
 
		pessoaEntity.setEmail(pessoaModel.getEmail());
		pessoaEntity.setEndereco(pessoaModel.getEndereco());
		pessoaEntity.setNome(pessoaModel.getNome());
		pessoaEntity.setSexo(pessoaModel.getSexo());
 
		entityManager.merge(pessoaEntity);
	}
	
	public void excluirRegistro(int codigo){
		entityManager =  Uteis.JpaEntityManager();		
 
		PessoaEntity pessoaEntity = this.getPessoa(codigo);
 
		entityManager.remove(pessoaEntity);
	}
	
	public Hashtable<String, Integer> getSexoPessoa(){
		 
		Hashtable<String, Integer> hashtableRegistros = new Hashtable<String,Integer>(); 
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("PessoaEntity.groupBySexo");
 
		@SuppressWarnings("unchecked")
		Collection<Object[]> collectionRegistros  = (Collection<Object[]>)query.getResultList();
 
		for (Object[] objects : collectionRegistros) {
 
			String sexo = (String) objects[0];
			int totalDeRegistros = ((Number) objects[1]).intValue();

			if (sexo.equals("M")) {
				sexo = "Masculino";
			} else {
				sexo = "Feminino";
			}
			
			hashtableRegistros.put(sexo, totalDeRegistros);
		}
 
		return hashtableRegistros;
	}
}