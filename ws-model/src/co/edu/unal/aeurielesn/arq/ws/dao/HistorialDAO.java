package co.edu.unal.aeurielesn.arq.ws.dao;

import co.edu.unal.aeurielesn.arq.ws.entities.Historial;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * DAO for Historial
 * @author Alexander Urieles
 */
public class HistorialDAO extends DAO {

    public HistorialDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Historial> findAll() {
        return performNamedQuery("Historial.findAll");
    }

    public Historial getHistorial(Long id) {
        Historial historial = (Historial) findById(Historial.class, id);
        em.refresh(historial);
        return historial;
    }

    public boolean persist(Historial historial) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(historial);
            et.commit();
        } catch (Exception ex) {
            et.rollback();
            Logger.getAnonymousLogger().severe(ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean merge(Historial historial) {
        try {
            em.merge(historial);
            em.flush();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public Historial findById(Long id) {
        Historial historial = (Historial) findById(Historial.class, id);
        em.refresh(historial);
        return historial;
    }
}
