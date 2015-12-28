/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ray Cabrera
 * Clase para manjera reportes
 */
public class ParaReportes {
      private static  ParaReportes parareportes = new ParaReportes();

      private static String host,usuario,puerto,bd,driver,pwd;
    public ParaReportes() {
    }
    
    
      public static ParaReportes getInstance(String Host,String Puerto, String BD,String Driver,String Usuario,String pwd){
          pwd = pwd;  
          host = Host;
          puerto = Puerto;
          bd= BD;
          usuario= Usuario;
          driver= Driver;
          return parareportes;
    }
      
//      Metodo para ver reporte sin parametros
      public void Ver_Reporte(String Reporte){
         JasperPrint reporte_view;
        try {
            Class.forName(driver);
            java.sql.Connection conexion = null;
            System.out.print("jdbc:mysql://" + host + ":" + puerto + "/" + bd + "," + usuario + "," + "");
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + bd, usuario, pwd);
            JasperReport reporte;
            reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(Reporte);
            Map parametros = new HashMap();
            parametros.clear();
            reporte_view = JasperFillManager.fillReport(reporte, null, conexion);
            JasperViewer.viewReport(reporte_view, false);

        } catch (JRException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());
        }


    }
//  Metodo para generar reportes con parametros que se generan dinamicamnet no importa 
//      no importa la cantidad de parametros que vayas a neviar al reporte
    public void Ver_Reporte(String Reporte, Parametro... ParaStrings) {
        JasperPrint reporte_view;
        try {
            Class.forName(driver);
            Parametro[] params2 = null;
            java.sql.Connection conexion = null;
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + bd, usuario, pwd);
            JasperReport reporte;
            reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(Reporte);
            Map parametros = new HashMap();
            parametros.clear();
            boolean first = true;
            int i = 0;
            if (ParaStrings != null && ParaStrings.length > 0) {
                params2 = new Parametro[ParaStrings.length];
                for (Parametro fP : ParaStrings) {
                    System.out.println(fP.getValor().toString());
                    parametros.put(fP.getCampo().toString(), fP.getValor().toString());
                    i++;
                }
            }
            reporte_view = JasperFillManager.fillReport(reporte, parametros, conexion);
            JasperViewer.viewReport(reporte_view, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}
