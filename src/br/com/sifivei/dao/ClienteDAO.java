package br.com.sifivei.dao;

import java.util.List;

import br.com.sifivei.beans.Cliente;

public interface ClienteDAO {
	
	List<Cliente> pesquisarClientes() throws Exception;
}
