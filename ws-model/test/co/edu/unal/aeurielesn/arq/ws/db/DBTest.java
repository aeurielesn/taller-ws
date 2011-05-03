package co.edu.unal.aeurielesn.arq.ws.db;

import co.edu.unal.aeurielesn.arq.ws.dao.HistorialDAO;
import co.edu.unal.aeurielesn.arq.ws.entities.Historial;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Alexander Urieles
 */
public class DBTest {

    public DBTest() {
    }

    @Test
    public void create() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ws-pu");
        EntityManager em = emf.createEntityManager();
        create(em);
        HistorialDAO dao = new HistorialDAO(em);
        List<Historial> findAll = dao.findAll();
        for (Historial history : findAll) {
            System.out.println(history.getId());
        }
        em.close();
        Assert.assertNotNull(findAll);
    }

    private void create(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        HistorialDAO dao = new HistorialDAO(em);
        Historial history = new Historial();
        history.setFecha(new Date());
        history.setComando("2+2");
        history.setResultado("4");
        et.begin();
        boolean persist = dao.persist(history);
        try {
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
        Assert.assertTrue(persist);
    }
}
