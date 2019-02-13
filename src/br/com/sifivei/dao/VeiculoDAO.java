package br.com.sifivei.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sifivei.beans.Veiculo;
import br.com.sifivei.exceptions.DAOException;

public class VeiculoDAO implements Serializable{

	private static final long serialVersionUID = -5634183222911828171L;
	
	private static VeiculoDAO instance;
	protected EntityManager entityManager;

	public static VeiculoDAO getInstance() {
		if (instance == null) {
			instance = new VeiculoDAO();
		}

		return instance;
	}

	public VeiculoDAO() {
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
	public List<Veiculo> pesquisarVeiculos() throws DAOException{
		try {
			Query q = entityManager.createQuery("SELECT c FROM Veiculo c");
			return q.getResultList();
		} catch (Exception e) {
			throw new DAOException(e);
		}		
	}

	public void salvar(Veiculo cliente) throws DAOException{
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

	public Veiculo consultarPorId(Integer id) throws DAOException{
		Query q = entityManager.createQuery("SELECT c FROM Veiculo c WHERE c.id = :id");
		q.setParameter("id", id);
		q.setMaxResults(1);
		return (Veiculo) q.getSingleResult();
	}

	public void excluir(Integer id) throws DAOException{
		try {
            entityManager.getTransaction().begin();
            Veiculo cliente = entityManager.find(Veiculo.class, id);
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new DAOException(ex);
        }
		
	}
}
