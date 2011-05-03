package co.edu.unal.aeurielesn.arq.ws.biz;

import co.edu.unal.aeurielesn.arq.ws.dao.HistorialDAO;
import co.edu.unal.aeurielesn.arq.ws.dto.HistorialDTO;
import co.edu.unal.aeurielesn.arq.ws.entities.Historial;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Lógica de negocio.
 * @author Alexander Urieles
 */
public class ConsolaService {
    EntityManager em;

    public ConsolaService(EntityManager entityManager) {
        em = entityManager;
    }

    public List<HistorialDTO> getHistorial() {
        HistorialDAO historialDAO = new HistorialDAO(em);
        List<HistorialDTO> logDTOs = new ArrayList<HistorialDTO>();
        List<Historial> logs = historialDAO.findAll();
        for (Historial log : logs) {
            logDTOs.add(new HistorialDTO(log));
        }
        return logDTOs;
    }

    public String ejecutar(String comando) {
        HistorialDAO historialDAO = new HistorialDAO(em);
        Historial historial = new Historial();
        historial.setFecha(new Date());
        historial.setComando(comando);
        String resultado = null;
        try {
            /* convierte el texto a mayúscula */
            resultado = comando.toUpperCase();
        } catch (Exception ex) {
            resultado = "-Error-";
        }
        historial.setResultado(resultado);
        /*boolean done =*/ historialDAO.persist(historial);
        return resultado;
    }
}
