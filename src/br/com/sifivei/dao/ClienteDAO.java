package br.com.sifivei.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.exceptions.DAOException;

public class ClienteDAO implements Serializable{
	
	private static final long serialVersionUID = -2251977790764366750L;
			
	private static ClienteDAO instance;
	protected EntityManager entityManager;

	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}

		return instance;
	}

	public ClienteDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sifiveiPU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> pesquisarClientes() throws DAOException{
		try {
			Query q = entityManager.createQuery("SELECT c FROM Cliente c");
			return q.getResultList();
		} catch (Exception e) {
			throw new DAOException(e);
		}		
	}

	public void salvar(Cliente cliente) throws DAOException{
		try {
			entityManager.getTransaction().begin();
			if (cliente.getId() == null) {
				entityManager.persist(cliente);
			} else {
				entityManager.merge(cliente);
			}
			entityManager.getTransaction().commit();

		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			throw new DAOException(ex);
		}
	}

	public Cliente consultarPorId(Integer id) throws DAOException{
		Query q = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.id = :id");
		q.setParameter("id", id);
		q.setMaxResults(1);
		return (Cliente) q.getSingleResult();
	}

	public void excluir(Integer id) throws DAOException{
		try {
            entityManager.getTransaction().begin();
            Cliente cliente = entityManager.find(Cliente.class, id);
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new DAOException(ex);
        }
		
	}
}
