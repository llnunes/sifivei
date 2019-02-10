package br.com.sifivei.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sifivei.beans.GenericEntity;

public abstract class SifiveiDAO<E extends GenericEntity<K>, K extends Serializable> extends GenericDAOImpl<E, K> {

	private EntityManager em;
	
	@Override
	public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sifiveiPU");
        if (em == null) {
        	em = factory.createEntityManager();
        }

        return em;
    }
}