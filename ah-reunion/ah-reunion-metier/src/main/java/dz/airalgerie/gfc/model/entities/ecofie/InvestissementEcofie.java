/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ecofie;

import dz.airalgerie.gfc.model.dto.ecofie.DTOInvestissementEcofieRecap;
import dz.airalgerie.gfc.model.dto.ecofie.DTOInvestissementEcofieUniteRecap;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kehli
 */
@Entity
@Table(name = "INVESTISSEMENT_ECOFIE", schema = "CF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvestissementEcofie.findAll",
        query = "SELECT i FROM InvestissementEcofie i"),
    @NamedQuery(name = "InvestissementEcofie.findById",
        query = "SELECT i FROM InvestissementEcofie i WHERE i.id = :id"),
    @NamedQuery(name = "InvestissementEcofie.findByUniteId",
        query = "SELECT i FROM InvestissementEcofie i WHERE i.uniteId = :uniteId"),
    @NamedQuery(name = "InvestissementEcofie.findByAnneeTrt",
        query = "SELECT i FROM InvestissementEcofie i WHERE i.anneeTrt = :anneeTrt"),
    @NamedQuery(name = "InvestissementEcofie.findByTrimestreTrt",
        query = "SELECT i FROM InvestissementEcofie i WHERE i.trimestreTrt = :trimestreTrt"),
    @NamedQuery(name = "InvestissementEcofie.findByDateInvestissement",
        query = "SELECT i FROM InvestissementEcofie i WHERE i.dateInvestissement = :dateInvestissement"),
    @NamedQuery(name = "InvestissementEcofie.findByNatureInvesrissement",
        query = "SELECT i FROM InvestissementEcofie i WHERE i.natureInvestissement = :natureInvestissement"),
    @NamedQuery(name = "InvestissementEcofie.findByTypeFinancement",
        query = "SELECT i FROM InvestissementEcofie i WHERE i.typeFinancement = :typeFinancement"),
    @NamedQuery(name = "InvestissementEcofie.findByMontantDevise",
        query = "SELECT i FROM InvestissementEcofie i WHERE i.montantDevise = :montantDevise"),
    @NamedQuery(name = "InvestissementEcofie.findByMontantDinars",
        query = "SELECT i FROM InvestissementEcofie i WHERE i.montantDinars = :montantDinars"),
    @NamedQuery(name = "InvestissementEcofie.findByCodeMonnaie",
        query = "SELECT i FROM InvestissementEcofie i WHERE i.codeMonnaie = :codeMonnaie"),
    @NamedQuery(name = "InvestissementEcofie.findByCoursDevise",
        query = "SELECT i FROM InvestissementEcofie i WHERE i.coursDevise = :coursDevise")})
@SqlResultSetMappings({@SqlResultSetMapping(name = "DTOInvestissementEcofieRecapMapping",
    classes = @ConstructorResult(targetClass = DTOInvestissementEcofieRecap.class,
        columns = {@ColumnResult(name = "ENTREPRISE", type = String.class),
            @ColumnResult(name = "AUTOFINANCEMENT_ANT", type = BigDecimal.class),
            @ColumnResult(name = "CREDIT_ANT", type = BigDecimal.class),
            @ColumnResult(name = "MONTANT_TOTAL_ANT", type = BigDecimal.class),
            @ColumnResult(name = "AUTOFINANCEMENT", type = BigDecimal.class),
            @ColumnResult(name = "CREDIT", type = BigDecimal.class),
            @ColumnResult(name = "MONTANT_TOTAL", type = BigDecimal.class)}

    )),
    @SqlResultSetMapping(name = "DTOInvestissementEcofieUniteRecapMapping",
        classes = @ConstructorResult(targetClass = DTOInvestissementEcofieUniteRecap.class,
            columns = {@ColumnResult(name = "DESIGNATION_ANT", type = String.class),
                @ColumnResult(name = "QUANTITE_ANT", type = Integer.class),
                @ColumnResult(name = "MONTANT_ANT", type = BigDecimal.class),
                @ColumnResult(name = "DESIGNATION", type = String.class),
                @ColumnResult(name = "QUANTITE", type = Integer.class),
                @ColumnResult(name = "MONTANT", type = BigDecimal.class),
                @ColumnResult(name = "CODE_MONNAIE", type = String.class)}

        ))})
public class InvestissementEcofie implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "UNITE_ID")
  private String uniteId;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ANNEE_TRT")
  private Integer anneeTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TRIMESTRE_TRT")
  private Integer trimestreTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_INVESTISSEMENT")
  private LocalDate dateInvestissement;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NATURE_INVESTISSEMENT")
  private Character natureInvestissement;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TYPE_FINANCEMENT")
  private Character typeFinancement;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 250)
  @Column(name = "DESIGNATION")
  private String designation;
  @Basic(optional = false)
  @NotNull
  @Column(name = "QUANTITE")
  private Integer quantite;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MONTANT_DEVISE")
  private BigDecimal montantDevise;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MONTANT_DINARS")
  private BigDecimal montantDinars;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_MONNAIE")
  private String codeMonnaie;
  @Basic(optional = false)
  @NotNull
  @Column(name = "COURS_DEVISE")
  private BigDecimal coursDevise;

  public InvestissementEcofie() {
  }

  public InvestissementEcofie(Integer id) {
    this.id = id;
  }

  public InvestissementEcofie(Integer id, String uniteId, Integer anneeTrt, Integer trimestreTrt,
      LocalDate dateInvestissement, Character natureInvestissement, Character typeFinancement,
      String designation, Integer quantite, BigDecimal montantDevise, BigDecimal montantDinars,
      String codeMonnaie, BigDecimal coursDevise) {
    this.id = id;
    this.uniteId = uniteId;
    this.anneeTrt = anneeTrt;
    this.trimestreTrt = trimestreTrt;
    this.dateInvestissement = dateInvestissement;
    this.natureInvestissement = natureInvestissement;
    this.typeFinancement = typeFinancement;
    this.designation = designation;
    this.quantite = quantite;
    this.montantDevise = montantDevise;
    this.montantDinars = montantDinars;
    this.codeMonnaie = codeMonnaie;
    this.coursDevise = coursDevise;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUniteId() {
    return uniteId;
  }

  public void setUniteId(String uniteId) {
    this.uniteId = uniteId;
  }

  public Integer getAnneeTrt() {
    return anneeTrt;
  }

  public void setAnneeTrt(Integer anneeTrt) {
    this.anneeTrt = anneeTrt;
  }

  public Integer getTrimestreTrt() {
    return trimestreTrt;
  }

  public void setTrimestreTrt(Integer trimestreTrt) {
    this.trimestreTrt = trimestreTrt;
  }

  public LocalDate getDateInvestissement() {
    return dateInvestissement;
  }

  public void setDateInvestissement(LocalDate dateInvestissement) {
    this.dateInvestissement = dateInvestissement;
  }

  public Character getNatureInvestissement() {
    return natureInvestissement;
  }

  public void setNatureInvestissement(Character natureInvestissement) {
    this.natureInvestissement = natureInvestissement;
  }

  public Character getTypeFinancement() {
    return typeFinancement;
  }

  public void setTypeFinancement(Character typeFinancement) {
    this.typeFinancement = typeFinancement;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public Integer getQuantite() {
    return quantite;
  }

  public void setQuantite(Integer quantite) {
    this.quantite = quantite;
  }

  public BigDecimal getMontantDevise() {
    return montantDevise;
  }

  public void setMontantDevise(BigDecimal montantDevise) {
    this.montantDevise = montantDevise;
  }

  public BigDecimal getMontantDinars() {
    return montantDinars;
  }

  public void setMontantDinars(BigDecimal montantDinars) {
    this.montantDinars = montantDinars;
  }

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public BigDecimal getCoursDevise() {
    return coursDevise;
  }

  public void setCoursDevise(BigDecimal coursDevise) {
    this.coursDevise = coursDevise;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof InvestissementEcofie)) {
      return false;
    }
    InvestissementEcofie other = (InvestissementEcofie) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.ecofie.InvestissementEcofie[ id=" + id + " ]";
  }

}
