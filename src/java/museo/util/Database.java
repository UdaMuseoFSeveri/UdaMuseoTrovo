/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.util;

import java.util.*;
import museo.db.*;
import org.hibernate.*;

/**
 *
 * @author FSEVERI\benetti3004
 */
public class Database {

    private SessionFactory factory;

    public Database() {
        factory = HibernateUtil.getSessionFactory();
    }

    /**
     *
     * @param utente
     * @return 0 se nome utente e password sono corretti, 1 se nome utente non
     * esiste, -1 se la password è errata
     */
    public int verificaUtente(Utente utente) {
        Transaction tx = null;
        Session session = factory.openSession();
        String username = utente.getNomeUtente();
        try {
            tx = session.beginTransaction();
            Query q = session.createSQLQuery("SELECT password FROM Utente where nomeUtente= ? ").addEntity(Utente.class);
            q.setString(0, username);
            if (q.list().size() == 0) {
                return 1;
            }
            if (q.list().size() > 0) {
                String passUser = (String) q.list().get(0);
                if (passUser.equals(utente.getPassword())) {
                    return 0;
                } else {
                    return -1;
                }
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return 1;
        } finally {
            session.close();
        }
        return -2;
    }

    public void salvaUtente(Utente u) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(u);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void salvaBiglietto(Biglietto b) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(b);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public List<Biglietto> getBiglietti(Date timestamp, String username) {
        Transaction tx = null;
        Session session = factory.openSession();
        ArrayList<Biglietto> biglietti = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            Query q = session.createSQLQuery("SELECT * FROM Biglietti where nomeUtente= ? AND DataPrenotazione=? ").addEntity(Biglietto.class);
            q.setParameter(0, username);
            q.setParameter(1, timestamp);
            return q.list();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
