package br.com.sifivei.exceptions;

public class DAOException extends Exception{

	private static final long serialVersionUID = -2502055031751519795L;

    public DAOException() {
        super();
    }

    public DAOException(String msg) {
        super(msg);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String msg, Throwable cause) {
        super(msg, cause);
    }

	
}

