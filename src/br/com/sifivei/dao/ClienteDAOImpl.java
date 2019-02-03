package br.com.sifivei.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.sifivei.beans.Cliente;

public class ClienteDAOImpl extends SifiveiDAO<Cliente, Integer> implements ClienteDAO{

	@Override
	public List<Cliente> pesquisarClientes() throws Exception {
		Query q = getEntityManager().createQuery("SELECT c FROM Cliente c");
		return consultar(q);
	}

}
