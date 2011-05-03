package co.edu.unal.aeurielesn.arq.ws.dto;

import co.edu.unal.aeurielesn.arq.ws.entities.Historial;
import java.util.Date;

/**
 * DTO for Historial
 * @author Alexander Urieles
 */
public class HistorialDTO {
    private Long historialId;
    private Date fecha;
    private String comando;
    private String resultado;

    public HistorialDTO() {
    }

    public HistorialDTO(Historial historial) {
        fromHistorial(historial);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getHistorialId() {
        return historialId;
    }

    public void setHistorialId(Long id) {
        this.historialId = id;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public final void fromHistorial(Historial historial){
        this.historialId = historial.getId();
        this.fecha = historial.getFecha();
        this.comando = historial.getComando();
        this.resultado = historial.getResultado();
    }

    @Override
    public String toString() {
        return "co.edu.unal.aeurielesn.arq.ws.dto.HistorialDTO[id=" + historialId + "]";
    }

}
