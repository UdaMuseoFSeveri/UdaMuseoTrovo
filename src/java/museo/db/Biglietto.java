/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.db;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

/**
 *
 * @author FSEVERI\magro3026
 */
@NamedQueries(
        {
            @NamedQuery(
                    name = "getBiglietti",
                    query = "FROM Biglietto B WHERE B.nomeUtente=:nome_Utente AND B.dataPrenotazione=:data_Prenotazione"
            ),
            /**
            @NamedQuery(
                    name = "getBigliettiForReview",
                    query = "FROM Biglietto B WHERE B.nomeUtente= :nome_Utente GROUP BY B.dataPrenotazione"
            ),
        
            @NamedQuery(
                    name = "getNBigliettiEspozioni",
                    query = "SELECT COUNT(*) FROM Biglietto B,Visita V WHERE B.codiceVisita = V.codiceVisita AND V.tipo='E'  AND  B.codiceVisita = :codice_Visita"
            ),
            
            @NamedQuery(
                    name = "getRicavoEsposizioni",
                    query = "SELECT SUM(V.tariffa-(V.tariffa*C.sconto/100)) AS RicavoBiglietti FROM Biglietto B, Visita V, Categoria C WHERE B.codiceVisita=V.codiceVisita AND C.codiceCategoria=B.codiceCategoria AND V.tipo='E' AND V.codiceVisita= :codice_Visita "
            )
            */   
        }
)
@Entity
@Table(name = "Biglietti")
/*@XmlRootElement
 @NamedQueries({
 @NamedQuery(name = "Biglietti.findAll", query = "SELECT b FROM Biglietti b"),
 @NamedQuery(name = "Biglietti.findByCodiceBiglietto", query = "SELECT b FROM Biglietti b WHERE b.codiceBiglietto = :codiceBiglietto"),
 @NamedQuery(name = "Biglietti.findByDataValidita", query = "SELECT b FROM Biglietti b WHERE b.dataValidita = :dataValidita"),
 @NamedQuery(name = "Biglietti.findByDataPrenotazione", query = "SELECT b FROM Biglietti b WHERE b.dataPrenotazione = :dataPrenotazione")})*/
public class Biglietto implements Serializable {

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
    //@Temporal(TemporalType.TIMESTAMP)
    private Timestamp dataPrenotazione;
    
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "Aggiunta", joinColumns = {
        @JoinColumn(name = "CodiceBiglietto", referencedColumnName = "CodiceBiglietto")}, inverseJoinColumns = {
        @JoinColumn(name = "CodiceServizio", referencedColumnName = "CodiceServizio")})
    
    private Collection<Servizio> serviziCollection;
    @JoinColumn(name = "NomeUtente", referencedColumnName = "NomeUtente")
    @ManyToOne(optional = false)
    private Utente nomeUtente;
    @JoinColumn(name = "CodiceCategoria", referencedColumnName = "CodiceCategoria")
    @ManyToOne(optional = false)
    private Categoria codiceCategoria;
    @JoinColumn(name = "CodiceVisita", referencedColumnName = "CodiceVisita")
    @ManyToOne(optional = false)
    private Visita codiceVisita;

    public Biglietto() {
    }

    public Biglietto(Integer codiceBiglietto) {
        this.codiceBiglietto = codiceBiglietto;
    }

    public Biglietto(Integer codiceBiglietto, Date dataValidita, Timestamp dataPrenotazione) {
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

    public Timestamp getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(Timestamp dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    //@XmlTransient
    public Collection<Servizio> getServiziCollection() {
        return serviziCollection;
    }

    public void setServiziCollection(Collection<Servizio> serviziCollection) {
        this.serviziCollection = serviziCollection;
    }

    public Utente getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(Utente nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public Categoria getCodiceCategoria() {
        return codiceCategoria;
    }

    public void setCodiceCategoria(Categoria codiceCategoria) {
        this.codiceCategoria = codiceCategoria;
    }

    public Visita getCodiceVisita() {
        return codiceVisita;
    }

    public void setCodiceVisita(Visita codiceVisita) {
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
        if (!(object instanceof Biglietto)) {
            return false;
        }
        Biglietto other = (Biglietto) object;
        if ((this.codiceBiglietto == null && other.codiceBiglietto != null) || (this.codiceBiglietto != null && !this.codiceBiglietto.equals(other.codiceBiglietto))) {
            return false;
        }
        return true;
    }

  @Override
  public String toString() {
    return "Biglietto{" + "codiceBiglietto=" + codiceBiglietto + ", dataValidita=" + dataValidita + ", dataPrenotazione=" + dataPrenotazione + ", serviziCollection=" + serviziCollection + ", nomeUtente=" + nomeUtente + ", codiceCategoria=" + codiceCategoria + ", codiceVisita=" + codiceVisita + '}';
  }



}
