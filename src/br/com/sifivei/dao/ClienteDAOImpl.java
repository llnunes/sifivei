package br.com.sifivei.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.exceptions.DAOException;

public class ClienteDAOImpl extends SifiveiDAO<Cliente, Integer> implements ClienteDAO {

	private static ClienteDAOImpl instance;

	public static ClienteDAOImpl getInstance() {
		if (instance == null) {
			instance = new ClienteDAOImpl();
		}

		return instance;
	}

	@Override
	public List<Cliente> pesquisarClientes() throws DAOException {
		try {
			Query q = getEntityManager().createQuery("SELECT c FROM Cliente c");
			return consultar(q);
		} catch (Exception e) {
			throw new DAOException(e);
		}		
	}

}
