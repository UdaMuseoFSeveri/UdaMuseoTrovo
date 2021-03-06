/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.db;

import java.io.Serializable;
import java.util.Collection;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\magro3026
 */

@NamedQueries(
        {
            @NamedQuery(
                    name = "getVisiteFromDate",
                    query = "FROM Visita V WHERE V.tipo='E'  AND  V.dataInizio>=:data_Ini  AND  V.dataFine<=:data_Fine"
            ), 
             
            @NamedQuery(
                    name = "getVisite",
                    query = "FROM Visita V WHERE V.tipo='V'"
            ),
            @NamedQuery(
                    name = "getEventoById",
                    query = "FROM Visita V WHERE V.codiceVisita=:codice_Visita"
            )
        }
                
)
@Entity
@Table(name = "Visite")
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodiceVisita")
    private Integer codiceVisita;
    @Basic(optional = false)
    @Column(name = "Titolo")
    private String titolo;
    @Basic(optional = false)
    @Column(name = "Tariffa")
    private float tariffa;
    @Basic(optional = false)
    @Column(name = "Descrizione")
    private String descrizione;
    @Column(name = "ImmagineCopertina")
    private String immagineCopertina;
    @Basic(optional = false)
    @Column(name = "Tipo")
    private Character tipo;
    @Column(name = "DataInizio")
    //@Temporal(TemporalType.DATE)
    private Date dataInizio;
    @Column(name = "DataFine")
    //@Temporal(TemporalType.DATE)
    private Date dataFine;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "codiceVisita")
    private Collection<Biglietto> bigliettiCollection;

    public Visita() {
    }

    public Visita(Integer codiceVisita) {
        this.codiceVisita = codiceVisita;
    }

    public Visita(Integer codiceVisita, String titolo, long tariffa, String descrizione, Character tipo) {
        this.codiceVisita = codiceVisita;
        this.titolo = titolo;
        this.tariffa = tariffa;
        this.descrizione = descrizione;
        this.tipo = tipo;
    }

    public Integer getCodiceVisita() {
        return codiceVisita;
    }

    public void setCodiceVisita(Integer codiceVisita) {
        this.codiceVisita = codiceVisita;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public float getTariffa() {
        return tariffa;
    }

    public void setTariffa(long tariffa) {
        this.tariffa = tariffa;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagineCopertina() {
        return immagineCopertina;
    }

    public void setImmagineCopertina(String immagineCopertina) {
        this.immagineCopertina = immagineCopertina;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
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
        hash += (codiceVisita != null ? codiceVisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.codiceVisita == null && other.codiceVisita != null) || (this.codiceVisita != null && !this.codiceVisita.equals(other.codiceVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "museo.db.Visite[ codiceVisita=" + codiceVisita + " ]";
    }

}
