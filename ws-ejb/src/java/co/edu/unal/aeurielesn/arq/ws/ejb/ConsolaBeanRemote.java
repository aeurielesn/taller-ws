package co.edu.unal.aeurielesn.arq.ws.ejb;

import co.edu.unal.aeurielesn.arq.ws.dto.HistorialDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 * Remote.
 * @author Alexander Urieles
 */
    @Remote
    public interface ConsolaBeanRemote {
        List<HistorialDTO> getHistorial();
        String ejecutar(String comando);
    }
