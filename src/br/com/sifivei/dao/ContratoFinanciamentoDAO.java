package br.com.sifivei.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sifivei.beans.ContratoFinanciamento;
import br.com.sifivei.exceptions.DAOException;

public class ContratoFinanciamentoDAO implements Serializable{
	
	private static final long serialVersionUID = -2251977790764366750L;
			
	private static ContratoFinanciamentoDAO instance;
	protected EntityManager entityManager;

	public static ContratoFinanciamentoDAO getInstance() {
		if (instance == null) {
			instance = new ContratoFinanciamentoDAO();
		}

		return instance;
	}

	public ContratoFinanciamentoDAO() {
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
	public List<ContratoFinanciamento> pesquisarContratoFinanciamentos() throws DAOException{
		try {
			Query q = entityManager.createQuery("SELECT c FROM ContratoFinanciamento c");
			return q.getResultList();
		} catch (Exception e) {
			throw new DAOException(e);
		}		
	}

	public void salvar(ContratoFinanciamento financiamento) throws DAOException{
		try {
			entityManager.getTransaction().begin();
			if (financiamento.getId() == null) {
				entityManager.persist(financiamento);
			} else {
				entityManager.merge(financiamento);
			}
			entityManager.getTransaction().commit();

		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			throw new DAOException(ex);
		}
	}

	public ContratoFinanciamento consultarPorId(Integer id) throws DAOException{
		Query q = entityManager.createQuery("SELECT c FROM ContratoFinanciamento c WHERE c.id = :id");
		q.setParameter("id", id);
		q.setMaxResults(1);
		return (ContratoFinanciamento) q.getSingleResult();
	}

	public void excluir(Integer id) throws DAOException{
		try {
            entityManager.getTransaction().begin();
            ContratoFinanciamento financiamento = entityManager.find(ContratoFinanciamento.class, id);
            entityManager.remove(financiamento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new DAOException(ex);
        }
		
	}
}