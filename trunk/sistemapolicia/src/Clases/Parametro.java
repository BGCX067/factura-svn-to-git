package Clases;

import java.io.Serializable;

/**
 * Clase que representa un parámetro filtro de una búsqueda
 *
 * @author fjmpaez
 *
 */
public class Parametro implements Serializable{

    private String campo;
    private Object valor;

    public Parametro() {
    }

    public Parametro(String campo, Object valor) {
        this.campo = campo;
        this.valor = valor;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
