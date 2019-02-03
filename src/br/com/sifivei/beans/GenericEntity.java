package br.com.sifivei.beans;

import java.io.Serializable;

public abstract class GenericEntity<K extends Serializable> implements Serializable {

	private static final long serialVersionUID = -765789666506485060L;

	/**
     * Retorna o <code>Id</code> da entidade
     * @return id da entidade
     */
    public abstract K getId();

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {

        if(this == obj) {
            return true;
        }

        if (getId() == null) {
            return false;
        }

        if (obj == null || !getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }

        GenericEntity<K> other = (GenericEntity<K>)obj;

        return getId().equals(other.getId());

    }

    @Override
    public int hashCode() {
        final int prime = getClass().getName().hashCode();
        int result = prime + (getId() == null ? super.hashCode() : getId().hashCode());
        return result;
    }

}
