/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

//Importaciones necesarias
//import Entidades.Configuraciones;
//import formularios.frmacceso;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
//Algunas importaciones
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
//Importacion para aplicar temas
//import org.jvnet.substance.SubstanceLookAndFeel;
import java.awt.event.KeyEvent;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import javax.swing.JButton;

/**
 *
 * @author Ray Cabrera V-1.0
 */
 public class MetodosComunes {

     private static MetodosComunes met = new MetodosComunes();
      public MetodosComunes() {
    }
     
     public static MetodosComunes getInstance(){
         return met;
         
         
         
     }
     
   
//    ManejadorDB maneja = new ManejadorDB();
    public String ObtenerHostname() throws UnknownHostException{
         Inet4Address averigua = (Inet4Address) Inet4Address.getLocalHost();
       return averigua.getHostName().toString();
       
      
    }
    
    
    public String ObtenerIP() throws UnknownHostException{
        Inet4Address averigua = (Inet4Address) Inet4Address.getLocalHost();
       
        
        
         return averigua.getHostAddress();
        
    }
    
//    Metodo para solo numeros
    public void SoloNumeros(KeyEvent e){
        int k = (int) e.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            e.consume();
        }
    }
    
//    Metodo pata convertir la primeras 
//    letra de una palabra 
//    en mayuscula
      public String PrimeraMayuscula(String cadena){
        String cadena2 = "";
        StringTokenizer token = new StringTokenizer(cadena);
        while (token.hasMoreTokens()) {
            cadena = token.nextToken();
            cadena = cadena.substring(0, 1).toUpperCase() + cadena.substring(1, cadena.length());
            cadena2 = cadena2 + cadena + " ";
        }
        return cadena2;
    } 
      
//      Devuelve el año
       public void Botonera(Integer Accion, JPanel frm) {
//        
//        if (Accion == 1){
//            frm.jButton6.setEnabled(false);
//            frm.jButton7.setEnabled(false);
//            frm.jButton8.setEnabled(false);
//            frm.jButton9.setEnabled(true);
//            frm.jButton5.setEnabled(true);
//        }else{
//            if (Accion == 2){
//
//                frm.jButton6.setEnabled(true);
//                frm.jButton7.setEnabled(true);
//                frm.jButton8.setEnabled(true);
//                frm.jButton9.setEnabled(false);
//                frm.jButton5.setEnabled(false);
//                
//            }
//          
         for (Object c : frm.getComponents())
        {
           
// metodo para controlar botonera
            if (c instanceof JButton) {
//                    System.out.println("este el nombre del boton" +  c.getClass().);

                if (Accion == 1) {
                    if (((JButton) c).getText() == "Nuevo" || ((JButton) c).getText() == "Actualizar" || ((JButton) c).getText() == "Eliminar") {

                        ((JButton) c).setEnabled(false);

                    }
                    if (((JButton) c).getText() == "Guardar" || ((JButton) c).getText() == "Cancelar") {
                        ((JButton) c).setEnabled(true);

                    }

                }
                if (Accion == 2) {
                    if (((JButton) c).getText() == "Nuevo" || ((JButton) c).getText() == "Actualizar" || ((JButton) c).getText() == "Eliminar") {

                        ((JButton) c).setEnabled(true);

                    }
                    if (((JButton) c).getText() == "Guardar" || ((JButton) c).getText() == "Cancelar") {
                        ((JButton) c).setEnabled(false);

                    }

                }}}
       }
     public String anio(){
           Calendar c = new GregorianCalendar(); 
        String annio = Integer.toString(c.get(Calendar.YEAR));
         
         return annio;
     }
     
//     Devuelve la fecha
   public String Fecha(String Delimitador){
	   Calendar c = new GregorianCalendar(); 
	   String dia, mes, annio;
	   dia = Integer.toString(c.get(Calendar.DATE));
	   mes = Integer.toString(c.get(Calendar.MONTH));
	   annio = Integer.toString(c.get(Calendar.YEAR));
           return  dia + Delimitador + mes + Delimitador + annio;
	   //System.out.println (dia + "/" + mes +"/" + annio);
   }
   
//   Devuelve la hora
    public String Hora(){
        Calendar calendario = new GregorianCalendar();
        int hora,minutos,segundos;
       hora =calendario.get(Calendar.HOUR_OF_DAY);
minutos = calendario.get(Calendar.MINUTE);
segundos = calendario.get(Calendar.SECOND);
        return hora + ":" + minutos + ":" + segundos; 
    }

    
    
public void Limpiartextfields(JPanel frm){ 
  //metodo para limpiar textfields
//dentro de un Jpanel
      for (Object c : frm.getComponents())
        {
                if (c instanceof JTextField)
                {
                    System.out.print(((JTextField)c).getText());
                        ((JTextField)c).setText("");
                }
        }

    }

public void Limpiarformatedfields(JPanel frm){
    //metodo para limpiar formatedfields

      for (Object c : frm.getComponents())
        {
                if (c instanceof JFormattedTextField)
                {
                   // System.out.print(((JTextField)c).getText());
                        ((JFormattedTextField)c).setValue("");  
                }
        }
    }

    
        
//          public void AplicarTema(JFrame frm){
//         EntityManager em;
//        em = maneja.getEntityManager();
//       System.out.println("hola" + em);
//          Query q = em.createQuery("select u from Configuraciones u");
//            List<Configuraciones> Lista = q.getResultList();
//        if (Lista.size()==0){
//            return;
//        }    
//         Configuraciones config = (Configuraciones) Lista.get(0);
//         frm.setDefaultLookAndFeelDecorated(true);
//        SubstanceLookAndFeel.setSkin(config.getTemaplicado()); 
// }
        
        
    }
   
    
    
    

