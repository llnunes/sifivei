package br.com.sifivei.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;

import br.com.sifivei.beans.GenericEntity;
import br.com.sifivei.exceptions.DAOException;
import lombok.NonNull;

public abstract class GenericDAOImpl<E extends GenericEntity<K>, K extends Serializable> implements GenericDAO<E, K> {

	private Class<E> entityClass;

	public abstract EntityManager getEntityManager();

	@Override
	@SuppressWarnings("unchecked")
	public E consultarPorPk(@NonNull K id) throws DAOException {
		try {
			final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
			entityClass = (Class<E>) type.getActualTypeArguments()[0];

			return getEntityManager().find(entityClass, id);
		} catch (Exception ex) {
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	@Override
	public K salvar(@NonNull E entity) throws DAOException {
		try {
			EntityTransaction tx = null;
			tx = getEntityManager().getTransaction();
		    tx.begin();
			if (entity.getId() == null) {
				getEntityManager().persist(entity);
			} else {
				getEntityManager().merge(entity);
			}
			tx.commit();			
			return entity.getId();
		} catch (Exception ex) {
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	@Override
	public void excluir(@NonNull E entity) throws DAOException {
		try {
			if (entity.getId() != null) {
				E e = consultarPorPk(entity.getId());
				getEntityManager().remove(e);
			}
		} catch (Exception ex) {
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	public void initialize(Collection<?> obj) {
		if (obj == null) {
			return;
		}

		PersistenceUnitUtil uu = getEntityManager().getEntityManagerFactory().getPersistenceUnitUtil();
		if (!uu.isLoaded(obj)) {
			obj.iterator().hasNext();
		}
	}

	@Override
	public List<E> consultar(@NonNull Query query) throws DAOException {
		return consultar(query, 0, 0, (DaoParameter[]) null);
	}

	@Override
	public List<E> consultar(@NonNull Query query, DaoParameter... params) throws DAOException {
		return consultar(query, 0, 0, params);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> consultar(@NonNull Query query, int inicio, int numRegistros, DaoParameter... params)
			throws DAOException {
		try {
			if (numRegistros > 0) {
				query.setFirstResult(inicio);
				query.setMaxResults(numRegistros);
			}
			defineParameters(query, params);
			return query.getResultList();
		} catch (NoResultException e) {
			return Collections.emptyList();
		} catch (NonUniqueResultException e) {
			return Collections.emptyList();
		} catch (Exception ex) {
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	protected void defineParameters(Query query, DaoParameter... params) {
		if (params != null && params.length > 0) {
			for (DaoParameter parameter : params) {
				query.setParameter(parameter.getName(), parameter.getValue());
			}
		}
	}

}
