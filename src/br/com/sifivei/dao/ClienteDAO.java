package br.com.sifivei.dao;

import java.util.List;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.exceptions.DAOException;

public interface ClienteDAO {
	
	List<Cliente> pesquisarClientes() throws DAOException;
}
