package com.eduardo.repository;

import java.io.Serializable;

import javax.persistence.Query;
import javax.transaction.Transactional;

import com.eduardo.model.UsuarioModel;
import com.eduardo.repository.entity.UsuarioEntity;
import com.eduardo.uteis.Uteis;

public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Transactional
	public UsuarioEntity ValidaUsuario(UsuarioModel usuarioModel) {

		try {
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");

			query.setParameter("login", usuarioModel.getLogin());
			query.setParameter("senha", usuarioModel.getSenha());

			return (UsuarioEntity) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
