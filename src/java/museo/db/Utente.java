/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\magro3026
 */
@Entity
@Table(name = "Utenti")
/*@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utenti.findAll", query = "SELECT u FROM Utenti u"),
    @NamedQuery(name = "Utenti.findByNomeUtente", query = "SELECT u FROM Utenti u WHERE u.nomeUtente = :nomeUtente"),
    @NamedQuery(name = "Utenti.findByPassword", query = "SELECT u FROM Utenti u WHERE u.password = :password")})*/
public class Utente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomeUtente")
    private String nomeUtente;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomeUtente")
    private Collection<Biglietto> bigliettiCollection;

    public Utente() {
    }

    public Utente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public Utente(String nomeUtente, String password) {
        this.nomeUtente = nomeUtente;
        this.password = password;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Biglietto> getBigliettiCollection() {
        return bigliettiCollection;
    }

    public void setBigliettiCollection(Collection<Biglietto> bigliettiCollection) {
        this.bigliettiCollection = bigliettiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeUtente != null ? nomeUtente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.nomeUtente == null && other.nomeUtente != null) || (this.nomeUtente != null && !this.nomeUtente.equals(other.nomeUtente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "museo.db.Utenti[ nomeUtente=" + nomeUtente + " ]";
    }
    
}
