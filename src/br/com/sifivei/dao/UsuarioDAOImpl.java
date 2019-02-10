package br.com.sifivei.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.sifivei.beans.Usuario;
import br.com.sifivei.exceptions.DAOException;

public class UsuarioDAOImpl extends SifiveiDAO<Usuario, Integer> implements UsuarioDAO{

    private static UsuarioDAOImpl instance;
   
    public static UsuarioDAOImpl getInstance() {
        if (instance == null) {
            instance = new UsuarioDAOImpl();
        }

        return instance;
    }

    @SuppressWarnings("unchecked")
	public Usuario login(String login, String senha) throws DAOException{
    	try{
    		Query q = getEntityManager().createQuery("SELECT u from Usuario u WHERE "
    				+ "u.login = :login AND u.senha = :senha ");
    		q.setParameter("login", login);
    		q.setParameter("senha", senha);
    		
    		List<Usuario> ls = q.getResultList();
    		
    		if (ls.size() == 1) {
    			return ls.get(0);
    		}
    		return null;    		
    	} catch (Exception e) {
    		throw new DAOException(e);
    	}
    }
}
