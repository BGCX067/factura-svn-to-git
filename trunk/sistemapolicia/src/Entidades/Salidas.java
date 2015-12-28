/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ray Cabrera
 */
@Entity
@Table(name = "salidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salidas.findAll", query = "SELECT s FROM Salidas s"),
    @NamedQuery(name = "Salidas.findById", query = "SELECT s FROM Salidas s WHERE s.id = :id"),
    @NamedQuery(name = "Salidas.findByIdusuario", query = "SELECT s FROM Salidas s WHERE s.idusuario = :idusuario")})
public class Salidas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "NombreMaquina")
    private String nombreMaquina;
    @Basic(optional = false)
    @Lob
    @Column(name = "Ip")
    private String ip;
    @Basic(optional = false)
    @Lob
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @Lob
    @Column(name = "hora")
    private String hora;
    @Basic(optional = false)
    @Column(name = "Id_usuario")
    private int idusuario;

    public Salidas() {
    }

    public Salidas(Integer id) {
        this.id = id;
    }

    public Salidas(Integer id, String nombreMaquina, String ip, String fecha, String hora, int idusuario) {
        this.id = id;
        this.nombreMaquina = nombreMaquina;
        this.ip = ip;
        this.fecha = fecha;
        this.hora = hora;
        this.idusuario = idusuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMaquina() {
        return nombreMaquina;
    }

    public void setNombreMaquina(String nombreMaquina) {
        this.nombreMaquina = nombreMaquina;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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
        if (!(object instanceof Salidas)) {
            return false;
        }
        Salidas other = (Salidas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Salidas[ id=" + id + " ]";
    }
    
}
