/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.util;

import java.sql.Date;
import java.util.List;
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
            Query q = session.getNamedQuery("checkPassword");
            q.setParameter("nome_Utente", username);
            if (q.list().isEmpty()) {
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
        try {
            tx = session.beginTransaction();
            Query q = session.getNamedQuery("getBigliettiFromDate");
            q.setParameter("nome_Utente", username);
            q.setParameter("data_Prenotazione", timestamp);
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

    public float getRicavoEsposizioni(int codiceVisita) {
        Transaction tx = null;
        Session session = factory.openSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createSQLQuery("getRicavoEsposizioni");
            q.setParameter("codice_Visita", codiceVisita);
            return (float) q.uniqueResult();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return 0;
    }
    
    public int getNBigliettiEspozioni(int codiceVisita) {
        Transaction tx = null;
        Session session = factory.openSession();
        try {
            tx = session.beginTransaction();
            Query q = session.getNamedQuery("getNBigliettiEspozioni");
            q.setParameter("codice_Visita", codiceVisita);
            return (Integer) q.uniqueResult();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return 0;
    }

    public List<Visita> getVisiteFromDate(Date dataInizio, Date dataFine) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("getVisiteFromDate");
            query.setParameter("data_Ini", dataInizio);
            query.setParameter("data_Fine", dataFine);
            if (query.list().size() > 0) {
                List<Visita> risultati = query.list();
                return risultati;
            }
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

    public List<Visita> getVisite() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("getVisite");
            List risultati = query.list();
            return risultati;
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

    public Visita getEventoById(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query q = session.getNamedQuery("getEventoById");
            q.setParameter("codice_Visita", id);
            if (q.list().size() > 0) {
                return (Visita) q.list().get(0);
            }
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

    public List<Categoria> getCategorie() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("getCategorie");
            List risultati = query.list();
            return risultati;
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

    public List<Servizio> getServizi() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("getServizi");
            List risultati = query.list();
            return risultati;
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

    public int utenteEsistente(String utente) {
        Transaction tx = null;
        Session session = factory.openSession();
        try {
            tx = session.beginTransaction();
            Query q = session.getNamedQuery("checkUtente");
            q.setParameter("utente", utente);
            if (q.list().isEmpty()) {
                return 0;
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return 1;
    }

    public List<Biglietto> getBigliettiForReview(String nomeUtente) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("getBigliettiForReview");
            query.setParameter("nome_Utente", nomeUtente);
            if (query.list().size() > 0) {
                List<Biglietto> risultati = query.list();
                return risultati;
            }
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
