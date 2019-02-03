package br.com.sifivei.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import br.com.sifivei.beans.GenericEntity;
import br.com.sifivei.exceptions.DAOException;
import lombok.NonNull;

public interface GenericDAO<E extends GenericEntity<K>, K extends Serializable> {

	E consultarPorPk(K id) throws DAOException;
	   
    K salvar(E entity) throws DAOException;   

    void excluir(E entity) throws DAOException;
    
    List<E> consultar(Query query) throws DAOException;

	List<E> consultar(@NonNull Query query, DaoParameter... params) throws DAOException;

	List<E> consultar(@NonNull Query query, int inicio, int numRegistros, DaoParameter... params) throws DAOException;
    
}
