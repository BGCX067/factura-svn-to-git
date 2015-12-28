/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Clases.ClavePrimaria;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ray Cabrera
 */
@Entity
@Table(name = "entradas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entradas.findAll", query = "SELECT e FROM Entradas e"),
    @NamedQuery(name = "Entradas.findById", query = "SELECT e FROM Entradas e WHERE e.id = :id")})
public class Entradas extends ClavePrimaria{
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
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @Lob
    @Column(name = "hora")
    private String hora;
    @Basic(optional = false)
    @Lob
    @Column(name = "ip")
    private String ip;
    @JoinColumn(name = "id_usuario", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Entradas() {
    }

    public Entradas(Integer id) {
        this.id = id;
    }

    public Entradas(Integer id, String nombreMaquina, String fecha, String hora, String ip) {
        this.id = id;
        this.nombreMaquina = nombreMaquina;
        this.fecha = fecha;
        this.hora = hora;
        this.ip = ip;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Entradas)) {
            return false;
        }
        Entradas other = (Entradas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Entradas[ id=" + id + " ]";
    }
    
}
