package br.com.sifivei.dao;

import br.com.sifivei.beans.Usuario;
import br.com.sifivei.exceptions.DAOException;


public interface UsuarioDAO {
	
	public Usuario login(String login, String senha) throws DAOException;
	
}