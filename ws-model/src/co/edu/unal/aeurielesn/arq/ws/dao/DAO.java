package co.edu.unal.aeurielesn.arq.ws.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * DAO Superclass
 * @author Alexander Urieles
 */
public class DAO {

    EntityManager em;

    protected DAO() {
    }

    protected DAO(EntityManager entityManager) {
        em = entityManager;
    }

    static class Parameter implements Map.Entry<String, Object> {

        String key;
        Object value;

        Parameter(String theKey, Object theValue) {
            key = theKey;
            value = theValue;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object object) {
            Object result = value;
            value = object;
            return result;
        }

        @Override
        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object instanceof Map.Entry) {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
                return (key == null ? entry.getKey() == null : key.equals(entry.getKey())) && (value == null ? entry.getValue() == null : value.equals(entry.getValue()));
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }
    }

    final List performNamedQuery(String name, Parameter... params) {
        Query query = em.createNamedQuery(name);
        for (int i = 0; i < params.length; i++) {
            Map.Entry<String, Object> entry = params[i];
            query.setParameter(entry.getKey(), entry.getValue());
        }
        List list = query.getResultList();
        for (Object object : list) {
            em.refresh(object);
        }
        return list;
    }

    final List performNamedQueryData(String name, Parameter... params) {
        Query query = em.createNamedQuery(name);
        for (int i = 0; i < params.length; i++) {
            Map.Entry<String, Object> entry = params[i];
            query.setParameter(entry.getKey(), entry.getValue());
        }
        List list = query.getResultList();
        return list;
    }

    final int performNamedUpdate(String name, Parameter... params) {
        Query query = em.createNamedQuery(name);
        for (int i = 0; i < params.length; i++) {
            Map.Entry<String, Object> entry = params[i];
            query.setParameter(entry.getKey(), entry.getValue());
        }
        int updated = query.executeUpdate();
        if(updated > 0) em.flush();
        return updated;
    }

    final List performQuery(String str, Parameter... params) {
        Query query = em.createQuery(str);
        for (int i = 0; i < params.length; i++) {
            Map.Entry<String, Object> entry = params[i];
            query.setParameter(entry.getKey(), entry.getValue());
        }
        List list = query.getResultList();
        for (Object object : list) {
            em.refresh(object);
        }
        return list;
    }

    final int performQueryUpdate(String str, Parameter... params) {
        Query query = em.createQuery(str);
        for (int i = 0; i < params.length; i++) {
            Map.Entry<String, Object> entry = params[i];
            query.setParameter(entry.getKey(), entry.getValue());
        }
        int updated = query.executeUpdate();
        if(updated > 0) em.flush();
        return updated;
    }

    public int performNativeQuery(String str){
        Query query = em.createNativeQuery(str);
        int updated = query.executeUpdate();
        if(updated > 0) em.flush();
        return updated;
    }

    final Object findById(Class clas, Object id) {
        Object ob = null;
        try {
            ob = em.find(clas, id);
            if(ob!=null)
                em.refresh(ob);
        } catch(Exception ex) {
            ob = null;
        }
        return ob;
    }

}
