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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByCodiceCategoria", query = "SELECT c FROM Categorie c WHERE c.codiceCategoria = :codiceCategoria"),
    @NamedQuery(name = "Categorie.findByTitolo", query = "SELECT c FROM Categorie c WHERE c.titolo = :titolo"),
    @NamedQuery(name = "Categorie.findByTipoDocumento", query = "SELECT c FROM Categorie c WHERE c.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Categorie.findBySconto", query = "SELECT c FROM Categorie c WHERE c.sconto = :sconto"),
    @NamedQuery(name = "Categorie.findByDescrizione", query = "SELECT c FROM Categorie c WHERE c.descrizione = :descrizione")})
public class Categorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodiceCategoria")
    private Integer codiceCategoria;
    @Basic(optional = false)
    @Column(name = "Titolo")
    private String titolo;
    @Column(name = "TipoDocumento")
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "Sconto")
    private int sconto;
    @Basic(optional = false)
    @Column(name = "Descrizione")
    private String descrizione;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiceCategoria")
    private Collection<Biglietti> bigliettiCollection;

    public Categorie() {
    }

    public Categorie(Integer codiceCategoria) {
        this.codiceCategoria = codiceCategoria;
    }

    public Categorie(Integer codiceCategoria, String titolo, int sconto, String descrizione) {
        this.codiceCategoria = codiceCategoria;
        this.titolo = titolo;
        this.sconto = sconto;
        this.descrizione = descrizione;
    }

    public Integer getCodiceCategoria() {
        return codiceCategoria;
    }

    public void setCodiceCategoria(Integer codiceCategoria) {
        this.codiceCategoria = codiceCategoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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
        hash += (codiceCategoria != null ? codiceCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.codiceCategoria == null && other.codiceCategoria != null) || (this.codiceCategoria != null && !this.codiceCategoria.equals(other.codiceCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "museo.db.Categorie[ codiceCategoria=" + codiceCategoria + " ]";
    }
    
}
