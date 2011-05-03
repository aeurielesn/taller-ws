package co.edu.unal.aeurielesn.arq.ws.ws;

import co.edu.unal.aeurielesn.arq.ws.dto.HistorialDTO;
import co.edu.unal.aeurielesn.arq.ws.ejb.ConsolaBeanRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Alexander Urieles
 */
@WebService()
public class Consola {
    @EJB
    private ConsolaBeanRemote ejbRef;

    @WebMethod(operationName = "getHistorial")
    public List<HistorialDTO> getHistorial() {
        return ejbRef.getHistorial();
    }

    @WebMethod(operationName = "ejecutar")
    public String ejecutar(@WebParam(name = "comando")
    String comando) {
        return ejbRef.ejecutar(comando);
    }

}
