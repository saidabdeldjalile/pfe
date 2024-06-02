/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cie;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "COMPAGNIE", schema = "CE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Compagnie.findAll", query = "SELECT c FROM Compagnie c")})
public class Compagnie implements Serializable {

  @Size(max = 10)
  @Column(name = "CODE_ANUM")
  private String codeAnum;

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "NUM_CIE")
  private String numCie;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_CIE")
  private String codeCie;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "NOM")
  private String nom;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "VILLE")
  private String ville;
  @Size(max = 50)
  @Column(name = "ADRESSE")
  private String adresse;
  @Column(name = "PAYS")
  private Integer pays;
  @Size(max = 1)
  @Column(name = "CODE_FCT")
  private String codeFct;
  @Size(max = 1)
  @Column(name = "IDEC")
  private String idec;
  @Size(max = 8)
  @Column(name = "TELEX")
  private String telex;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TAUX_COMM")
  private BigDecimal tauxComm;
  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax
  // format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using
  // this annotation to enforce field validation
  @Size(max = 50)
  @Column(name = "FAX")
  private String fax;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "compagnie")
  private Collection<FactureRecue> factureRecueCollection;

  public Compagnie() {}

  public Compagnie(String numCie) {
    this.numCie = numCie;
  }

  public Compagnie(String numCie, String codeCie, String nom, String ville) {
    this.numCie = numCie;
    this.codeCie = codeCie;
    this.nom = nom;
    this.ville = ville;
  }

  public String getNumCie() {

    return numCie;
  }

  public void setNumCie(String numCie) {
    this.numCie = numCie;
  }

  public String getCodeCie() {
    return codeCie;
  }

  public void setCodeCie(String codeCie) {
    this.codeCie = codeCie;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public Integer getPays() {
    return pays;
  }

  public void setPays(Integer pays) {
    this.pays = pays;
  }

  public String getCodeFct() {
    return codeFct;
  }

  public void setCodeFct(String codeFct) {
    this.codeFct = codeFct;
  }

  public String getIdec() {
    return idec;
  }

  public void setIdec(String idec) {
    this.idec = idec;
  }

  public String getTelex() {
    return telex;
  }

  public void setTelex(String telex) {
    this.telex = telex;
  }

  public BigDecimal getTauxComm() {
    return tauxComm;
  }

  public void setTauxComm(BigDecimal tauxComm) {
    this.tauxComm = tauxComm;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  @XmlTransient
  public Collection<FactureRecue> getFactureRecueCollection() {
    return factureRecueCollection;
  }

  public void setFactureRecueCollection(Collection<FactureRecue> factureRecueCollection) {
    this.factureRecueCollection = factureRecueCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (numCie != null ? numCie.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Compagnie)) {
      return false;
    }
    Compagnie other = (Compagnie) object;
    if ((this.numCie == null && other.numCie != null)
        || (this.numCie != null && !this.numCie.equals(other.numCie))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.Compagnie[ numCie=" + numCie + " ]";
  }

  public String getCodeAnum() {
    return codeAnum;
  }

  public void setCodeAnum(String codeAnum) {
    this.codeAnum = codeAnum;
  }

}
