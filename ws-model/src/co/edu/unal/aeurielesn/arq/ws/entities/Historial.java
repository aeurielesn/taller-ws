package co.edu.unal.aeurielesn.arq.ws.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 * Clase entidad para Historial.
 * @author Alexander Urieles
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Historial.findAll", query = "SELECT h FROM Historial h ORDER BY h.id DESC")
    })
public class Historial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private String comando;
    private String resultado;

    /**
     * Get the result of the performed operation
     * @return the result of the performed operation
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Set the result
     * @param resultado new value of result
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Get the command performed
     * @return the command performed
     */
    public String getComando() {
        return comando;
    }

    /**
     * Set the value of command
     * @param comando new value of comando
     */
    public void setComando(String comando) {
        this.comando = comando;
    }

    /**
     * Get the operation performed
     * @return the operation performed
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Set the opertation performed
     * @param performed new operation performed
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.aeurielesn.arq.ws.entities.Historial[id=" + id + "]";
    }

}
