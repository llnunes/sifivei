package br.com.sifivei.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sifivei.beans.GenericEntity;

public abstract class SifiveiDAO<E extends GenericEntity<K>, K extends Serializable> extends GenericDAOImpl<E, K> {

	@PersistenceContext(unitName = "sifiveiPU")
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	};
}