/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\magro3026
 */
@Entity
@Table(name = "Servizi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servizi.findAll", query = "SELECT s FROM Servizi s"),
    @NamedQuery(name = "Servizi.findByCodiceServizio", query = "SELECT s FROM Servizi s WHERE s.codiceServizio = :codiceServizio"),
    @NamedQuery(name = "Servizi.findByTitolo", query = "SELECT s FROM Servizi s WHERE s.titolo = :titolo"),
    @NamedQuery(name = "Servizi.findByPrezzo", query = "SELECT s FROM Servizi s WHERE s.prezzo = :prezzo"),
    @NamedQuery(name = "Servizi.findByDescrizione", query = "SELECT s FROM Servizi s WHERE s.descrizione = :descrizione"),
    @NamedQuery(name = "Servizi.findByImmagine", query = "SELECT s FROM Servizi s WHERE s.immagine = :immagine")})
public class Servizi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodiceServizio")
    private Integer codiceServizio;
    @Basic(optional = false)
    @Column(name = "Titolo")
    private String titolo;
    @Basic(optional = false)
    @Column(name = "Prezzo")
    private long prezzo;
    @Basic(optional = false)
    @Column(name = "Descrizione")
    private String descrizione;
    @Basic(optional = false)
    @Column(name = "Immagine")
    private String immagine;
    @ManyToMany(mappedBy = "serviziCollection")
    private Collection<Biglietti> bigliettiCollection;

    public Servizi() {
    }

    public Servizi(Integer codiceServizio) {
        this.codiceServizio = codiceServizio;
    }

    public Servizi(Integer codiceServizio, String titolo, long prezzo, String descrizione, String immagine) {
        this.codiceServizio = codiceServizio;
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.immagine = immagine;
    }

    public Integer getCodiceServizio() {
        return codiceServizio;
    }

    public void setCodiceServizio(Integer codiceServizio) {
        this.codiceServizio = codiceServizio;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public long getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(long prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    @XmlTransient
    public Collection<Biglietti> getBigliettiCollection() {
        return bigliettiCollection;
    }

    public void setBigliettiCollection(Collection<Biglietti> bigliettiCollection) {
        this.bigliettiCollection = bigliettiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiceServizio != null ? codiceServizio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servizi)) {
            return false;
        }
        Servizi other = (Servizi) object;
        if ((this.codiceServizio == null && other.codiceServizio != null) || (this.codiceServizio != null && !this.codiceServizio.equals(other.codiceServizio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "museo.db.Servizi[ codiceServizio=" + codiceServizio + " ]";
    }
    
}
