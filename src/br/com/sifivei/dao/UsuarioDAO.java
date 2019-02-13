package br.com.sifivei.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sifivei.beans.Usuario;
import br.com.sifivei.exceptions.DAOException;

public class UsuarioDAO implements Serializable{

	private static final long serialVersionUID = 3051564634124050786L;
	
	private static UsuarioDAO instance;
	protected EntityManager entityManager;

	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}

		return instance;
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sifiveiPU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public Usuario login(String login, String senha) throws DAOException {
		try {
			Query q = getEntityManager()
					.createQuery("SELECT u from Usuario u WHERE " + "u.login = :login AND u.senha = :senha ");
			q.setParameter("login", login);
			q.setParameter("senha", senha);

			List<Usuario> ls = q.getResultList();

			if (ls.size() == 1) {
				return ls.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}