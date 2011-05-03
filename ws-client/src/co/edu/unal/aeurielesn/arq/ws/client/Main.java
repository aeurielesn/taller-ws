package co.edu.unal.aeurielesn.arq.ws.client;

import co.edu.unal.aeurielesn.arq.ws.wsclient.Consola;
import co.edu.unal.aeurielesn.arq.ws.wsclient.ConsolaService;
import co.edu.unal.aeurielesn.arq.ws.wsclient.HistorialDTO;
import java.util.List;

/**
 *
 * @author Alexander Urieles
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.getHistorial();
    }

    public void getHistorial() {
        Consola consola = new ConsolaService().getConsolaPort();
        List<HistorialDTO> historial = consola.getHistorial();
        for (HistorialDTO historialDTO : historial) {
            System.out.print(historialDTO.getComando());
            System.out.print(" : ");
            System.out.println(historialDTO.getResultado());
        }
    }
}
