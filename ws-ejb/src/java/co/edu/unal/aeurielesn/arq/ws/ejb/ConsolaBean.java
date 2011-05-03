package co.edu.unal.aeurielesn.arq.ws.ejb;

import co.edu.unal.aeurielesn.arq.ws.biz.ConsolaService;
import co.edu.unal.aeurielesn.arq.ws.dto.HistorialDTO;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Bean for Consola.
 * @author Alexander Urieles
 */
@Stateless
public class ConsolaBean implements ConsolaBeanRemote {
    @PersistenceUnit(unitName="ws-pu")
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    ConsolaService service;

    @Override
    public List<HistorialDTO> getHistorial() {
        return service.getHistorial();
    }

    @PostConstruct
    public void initialize()
    {
        entityManager = entityManagerFactory.createEntityManager();
        if(entityManagerFactory == null) {
            Logger.getAnonymousLogger().severe("entityManagerFactory.null? true");
        }
        if(entityManager == null) {
            Logger.getAnonymousLogger().severe("entityManager.null? true");
        }
        service = new ConsolaService(entityManager);
    }

    @PreDestroy
    public void cleanUp()
    {
       if(entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @Override
    public String ejecutar(String comando) {
        return service.ejecutar(comando);
    }
}
