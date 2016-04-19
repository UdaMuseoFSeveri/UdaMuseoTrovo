/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.util;

import museo.db.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author FSEVERI\magro3026
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    
    /*static {
        
    }*/
    
    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null){
        Configuration configuration = new Configuration();         
        configuration.addAnnotatedClass(Biglietto.class).addAnnotatedClass(Categoria.class).addAnnotatedClass(Servizio.class).addAnnotatedClass(Utente.class).addAnnotatedClass(Visita.class);
            configuration.configure();
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
        }
      return sessionFactory;
    }
}
