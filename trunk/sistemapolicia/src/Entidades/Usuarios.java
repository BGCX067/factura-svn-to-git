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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")})
public class Usuarios extends ClavePrimaria{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @Lob
    @Column(name = "Cedula")
    private String cedula;
    @Basic(optional = false)
    @Lob
    @Column(name = "Telelono1")
    private String telelono1;
    @Basic(optional = false)
    @Lob
    @Column(name = "Telefono2")
    private String telefono2;
    @Basic(optional = false)
    @Lob
    @Column(name = "Nivel")
    private String nivel;
    @Basic(optional = false)
    @Lob
    @Column(name = "estatus")
    private String estatus;
    @Basic(optional = false)
    @Lob
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @Lob
    @Column(name = "preguntaseguridad")
    private String preguntaseguridad;
    @Basic(optional = false)
    @Lob
    @Column(name = "respuestaseguridad")
    private String respuestaseguridad;
    @Basic(optional = false)
    @Lob
    @Column(name = "Password")
    private String password;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String nombre, String apellido, String cedula, String telelono1, String telefono2, String nivel, String estatus, String direccion, String preguntaseguridad, String respuestaseguridad, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telelono1 = telelono1;
        this.telefono2 = telefono2;
        this.nivel = nivel;
        this.estatus = estatus;
        this.direccion = direccion;
        this.preguntaseguridad = preguntaseguridad;
        this.respuestaseguridad = respuestaseguridad;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelelono1() {
        return telelono1;
    }

    public void setTelelono1(String telelono1) {
        this.telelono1 = telelono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPreguntaseguridad() {
        return preguntaseguridad;
    }

    public void setPreguntaseguridad(String preguntaseguridad) {
        this.preguntaseguridad = preguntaseguridad;
    }

    public String getRespuestaseguridad() {
        return respuestaseguridad;
    }

    public void setRespuestaseguridad(String respuestaseguridad) {
        this.respuestaseguridad = respuestaseguridad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Usuarios[ id=" + id + " ]";
    }
    
}
