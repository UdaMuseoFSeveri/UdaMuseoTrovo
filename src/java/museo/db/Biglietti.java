/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\magro3026
 */
@Entity
@Table(name = "Biglietti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biglietti.findAll", query = "SELECT b FROM Biglietti b"),
    @NamedQuery(name = "Biglietti.findByCodiceBiglietto", query = "SELECT b FROM Biglietti b WHERE b.codiceBiglietto = :codiceBiglietto"),
    @NamedQuery(name = "Biglietti.findByDataValidita", query = "SELECT b FROM Biglietti b WHERE b.dataValidita = :dataValidita"),
    @NamedQuery(name = "Biglietti.findByDataPrenotazione", query = "SELECT b FROM Biglietti b WHERE b.dataPrenotazione = :dataPrenotazione")})
public class Biglietti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodiceBiglietto")
    private Integer codiceBiglietto;
    @Basic(optional = false)
    @Column(name = "DataValidita")
    @Temporal(TemporalType.DATE)
    private Date dataValidita;
    @Basic(optional = false)
    @Column(name = "DataPrenotazione")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPrenotazione;
    @JoinTable(name = "Aggiunta", joinColumns = {
        @JoinColumn(name = "CodiceBiglietto", referencedColumnName = "CodiceBiglietto")}, inverseJoinColumns = {
        @JoinColumn(name = "CodiceServizio", referencedColumnName = "CodiceServizio")})
    @ManyToMany
    private Collection<Servizi> serviziCollection;
    @JoinColumn(name = "NomeUtente", referencedColumnName = "NomeUtente")
    @ManyToOne(optional = false)
    private Utenti nomeUtente;
    @JoinColumn(name = "CodiceCategoria", referencedColumnName = "CodiceCategoria")
    @ManyToOne(optional = false)
    private Categorie codiceCategoria;
    @JoinColumn(name = "CodiceVisita", referencedColumnName = "CodiceVisita")
    @ManyToOne(optional = false)
    private Visite codiceVisita;

    public Biglietti() {
    }

    public Biglietti(Integer codiceBiglietto) {
        this.codiceBiglietto = codiceBiglietto;
    }

    public Biglietti(Integer codiceBiglietto, Date dataValidita, Date dataPrenotazione) {
        this.codiceBiglietto = codiceBiglietto;
        this.dataValidita = dataValidita;
        this.dataPrenotazione = dataPrenotazione;
    }

    public Integer getCodiceBiglietto() {
        return codiceBiglietto;
    }

    public void setCodiceBiglietto(Integer codiceBiglietto) {
        this.codiceBiglietto = codiceBiglietto;
    }

    public Date getDataValidita() {
        return dataValidita;
    }

    public void setDataValidita(Date dataValidita) {
        this.dataValidita = dataValidita;
    }

    public Date getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(Date dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    @XmlTransient
    public Collection<Servizi> getServiziCollection() {
        return serviziCollection;
    }

    public void setServiziCollection(Collection<Servizi> serviziCollection) {
        this.serviziCollection = serviziCollection;
    }

    public Utenti getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(Utenti nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public Categorie getCodiceCategoria() {
        return codiceCategoria;
    }

    public void setCodiceCategoria(Categorie codiceCategoria) {
        this.codiceCategoria = codiceCategoria;
    }

    public Visite getCodiceVisita() {
        return codiceVisita;
    }

    public void setCodiceVisita(Visite codiceVisita) {
        this.codiceVisita = codiceVisita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiceBiglietto != null ? codiceBiglietto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biglietti)) {
            return false;
        }
        Biglietti other = (Biglietti) object;
        if ((this.codiceBiglietto == null && other.codiceBiglietto != null) || (this.codiceBiglietto != null && !this.codiceBiglietto.equals(other.codiceBiglietto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "museo.db.Biglietti[ codiceBiglietto=" + codiceBiglietto + " ]";
    }
    
}
