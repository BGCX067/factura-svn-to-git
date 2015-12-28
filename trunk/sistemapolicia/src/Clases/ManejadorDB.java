/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import Entidades.Usuarios;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Ray Cabrera
 * @version 1.0
 */

//@javax.ejb.ApplicationException(rollback = true)
//@TransactionManagement(TransactionManagementType.BEAN)
//@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class ManejadorDB {
    private List Lista;
    private DefaultTableModel modelo;
MetodosComunes met = MetodosComunes.getInstance();
public <T extends ClavePrimaria> int Eliminar(T entidad){
           EntityManager em = getEntityManager();
 
     
           try {       
             
            Class instancia = Class.forName(entidad.getClass().getName());
       System.out.print("estoy aqui" + entidad);
       
            if ((buscar(instancia, entidad.getId())) != null) {
              
                em.getTransaction().begin();
                em = getEntityManager();

//                em.merge(instancia.getName().getClass());
                em.remove(entidad);

                em.getTransaction().commit();

         

      
    }
           } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, ex.toString());
        }
        return 1;
    
    
    
  
    
    
}
public void cargar(String Tabla,String Clase,JTable grilla) throws ClassNotFoundException{
     EntityManager em;
    em = maneja.getEntityManager();
    Query q = em.createQuery("SELECT u FROM " + Tabla + " u");

    Lista = q.getResultList();

    if (Lista.isEmpty()) {
        return;
    }


    grilla.removeAll();



    Object datos[] = new Object[Lista.size()];

    modelo = new DefaultTableModel();

    modelo.setNumRows(Lista.size());

    Class _class;
    _class = Class.forName(Clase);
    Field properties[] = _class.getFields();
    for (int i = 0; i < properties.length; i++) {
        Field field = null;
        field = properties[i];
//        System.out.println(field.getName() + " > " + field.getType());
//        String Excepto = null;
//        Excepto = met.PrimeraMayuscula(excepto);

//        if (Excepto != met.PrimeraMayuscula(field.getName())) {
//            System.out.print(met.PrimeraMayuscula(field.getName()));

//            i = i + 1;

//        }
        modelo.addColumn(met.PrimeraMayuscula(field.getName()));


    }









        for (int i = 0; i < Lista.size(); i++) {

//              = (Doctores) Lista.get(i);
//            modelo.setValueAt(doctor.getId(), i, 0);
//            modelo.setValueAt(doctor.getNombre(), i, 1);
//            modelo.setValueAt(doctor.getApellido(), i, 2);
//            modelo.setValueAt(doctor.getCedula(), i, 3);
//            modelo.setValueAt(doctor.getDireccion(), i, 4);
//            modelo.setValueAt(doctor.getTelefono(), i, 5);



        }

        grilla.setModel(modelo);
}
    //@Resource
    //private UserTransaction utx = null;
    //@PersistenceUnit(unitName = "EAFacturacion-ejbPU")
    private static EntityManagerFactory emf = null;
private static String motorentidad;

private static ManejadorDB maneja = new ManejadorDB();
public static ManejadorDB getInstance(String NombreUnidadPersistencia){
       motorentidad = NombreUnidadPersistencia;
      return maneja;
}
    private ManejadorDB(){
}

    public  EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory( motorentidad + "PU");
        System.out.print(emf);
         return emf.createEntityManager();
    }

    
    public <T extends ClavePrimaria> int insert(T entidad) { 
        System.out.print(getEntityManager());
        EntityManager em = getEntityManager();
        int bandera = 0;
        try {
            Class instancia = Class.forName(entidad.getClass().getName());
            System.out.println("valor devuelto " + buscar(instancia, entidad.getId()));
            if ((buscar(instancia, entidad.getId())) == null) {
                em.getTransaction().begin();
               // em = getEntityManager();
                em.persist(entidad);
                em.getTransaction().commit();
            } else {

                return 1;
            }
        } catch (RollbackException ex) {
            System.out.println("Exception " + ex);
            bandera = 2;

        } catch (Exception ex) {
            bandera = 3;
            System.out.println("Exception " + ex);
        } finally {
            if (em != null) {
                em.close();

            }

        }
        return bandera;

    }

    public <T extends ClavePrimaria> T buscar(Class<T> entidad, Integer id) {

        EntityManager em = getEntityManager();
     //   System.out.print(em);
      // System.out.print("estas alli:" + em);
        Object objeto = null;
       
        if (id == null && entidad != null) {
            return (T) objeto;
        }

        objeto = em.find(entidad, id);

        em.close();
        return (T) objeto;
    }

  
    public <T extends ClavePrimaria> List<T> buscarTodos(Class<T> objeto, String columna, boolean estatus, boolean ascendente) {

        final String entityName = objeto.getSimpleName();
        final Query query;
        EntityManager em = getEntityManager();

        if (ascendente) {
            query = em.createQuery("SELECT e from " + entityName + " e WHERE e.estatus = :estatus order by e." + columna + " asc").setParameter("estatus", estatus);

        } else {
            query = em.createQuery("SELECT e from " + entityName + " e WHERE e.estatus = :estatus order by e." + columna + " desc").setParameter("estatus", estatus);
        }
        final List<T> resultList = query.getResultList();
        if (em != null) {
            em.close();
        }
        return resultList;
    }

    public <T extends ClavePrimaria> List<T> busquedaPorFiltro(
            Class<T> entidad, String columna, boolean ascendente, boolean or, Parametro... params) {

        final String entityName = entidad.getSimpleName();
        StringBuffer sbQuery = new StringBuffer("SELECT e from ").append(entityName).append(" e");
        final Query query;

        Parametro[] params2 = null;


        boolean first = true;
        int i = 0;
        if (params != null && params.length > 0) {

            params2 = new Parametro[params.length];

            for (Parametro fP : params) {
                if (first) {
                    sbQuery.append(" where e.").append(fP.getCampo()).append(" like :").append("p" + i);
                } else {
                    sbQuery.append(or ? " or" : " and").append(" e.").append(fP.getCampo()).append(" like :").append("p" + i);
                }

                first = false;

                Parametro fPAux = new Parametro("p" + i, fP.getValor() + "%");
                params2[i] = fPAux;
                i++;
            }
        }
        System.out.println("Query " + sbQuery);
        if (ascendente) {
            sbQuery.append(" order by e." + columna + " asc");
        } else {
            sbQuery.append(" order by e." + columna + " desc");
        }

        query = createQuery(sbQuery.toString(), params2);
System.out.println(sbQuery.toString());
        final List<T> resultList = query.getResultList();

        return resultList;
    }

    private Query createQuery(String query, Parametro... params) {
        EntityManager em = getEntityManager();
        Query qQuery = em.createQuery(query);
        if (params != null && params.length > 0) {
            for (Parametro fP : params) {
                qQuery.setParameter(fP.getCampo(), fP.getValor());
            }
        }

        return qQuery;
    }

   
    public <T extends ClavePrimaria> int modificar(T entidad) {
        
        EntityManager em = getEntityManager();
        try {       
            Class instancia = Class.forName(entidad.getClass().getName());
            if ((buscar(instancia, entidad.getId())) != null) {
                em.getTransaction().begin();
                em = getEntityManager();
                em.merge(entidad);
                em.getTransaction().commit();

         

      
    }   } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;

    }
    public Integer getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   

    

   
}
