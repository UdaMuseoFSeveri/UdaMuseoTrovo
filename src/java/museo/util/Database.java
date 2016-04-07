/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FSEVERI\benetti3004
 */
public class Database {
    private  SessionFactory factory;
    
    public Database(){
        factory = HibernateUtil.getSessionFactory();
    }
    
    public int verificaUtente()
    
    
    
}
