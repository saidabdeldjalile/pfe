/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ecofie;

import dz.airalgerie.gfc.model.dto.ecofie.DTOContratEcofiePays;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CONTRAT_ECOFIE", schema = "CF")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "ContratEcofie.findAll", query = "SELECT c FROM ContratEcofie c"),
    @NamedQuery(name = "ContratEcofie.findById",
        query = "SELECT c FROM ContratEcofie c WHERE c.id = :id"),
    @NamedQuery(name = "ContratEcofie.findByUniteId",
        query = "SELECT c FROM ContratEcofie c WHERE c.uniteId = :uniteId"),
    @NamedQuery(name = "ContratEcofie.findByAnneeTrt",
        query = "SELECT c FROM ContratEcofie c WHERE c.anneeTrt = :anneeTrt"),
    @NamedQuery(name = "ContratEcofie.findByTrimestreTrt",
        query = "SELECT c FROM ContratEcofie c WHERE c.trimestreTrt = :trimestreTrt"),
    @NamedQuery(name = "ContratEcofie.findByDateContrat",
        query = "SELECT c FROM ContratEcofie c WHERE c.dateContrat = :dateContrat"),
    @NamedQuery(name = "ContratEcofie.findByObjet",
        query = "SELECT c FROM ContratEcofie c WHERE c.objet = :objet"),
    @NamedQuery(name = "ContratEcofie.findByMontantDevise",
        query = "SELECT c FROM ContratEcofie c WHERE c.montantDevise = :montantDevise"),
    @NamedQuery(name = "ContratEcofie.findByMontantDinars",
        query = "SELECT c FROM ContratEcofie c WHERE c.montantDinars = :montantDinars"),
    @NamedQuery(name = "ContratEcofie.findByEntreprise",
        query = "SELECT c FROM ContratEcofie c WHERE c.entreprise = :entreprise"),
    @NamedQuery(name = "ContratEcofie.findByCodeMonnaie",
        query = "SELECT c FROM ContratEcofie c WHERE c.codeMonnaie = :codeMonnaie"),
    @NamedQuery(name = "ContratEcofie.findByCoursDevise",
        query = "SELECT c FROM ContratEcofie c WHERE c.coursDevise = :coursDevise"),
    @NamedQuery(name = "ContratEcofie.findByFileName",
        query = "SELECT c FROM ContratEcofie c WHERE c.fileName = :fileName")})
@SqlResultSetMappings({@SqlResultSetMapping(name = "DTOContratEcofiePaysMapping",
    classes = @ConstructorResult(targetClass = DTOContratEcofiePays.class,
        columns = {@ColumnResult(name = "ANNEE_TRT", type = Integer.class),
            @ColumnResult(name = "TRIMESTRE_TRT", type = Integer.class),
            @ColumnResult(name = "NOM_PAYS", type = String.class),
            @ColumnResult(name = "NOMBRE_CONTRAT", type = Integer.class),
            @ColumnResult(name = "EUR", type = BigDecimal.class),
            @ColumnResult(name = "USD", type = BigDecimal.class),
            @ColumnResult(name = "AUTRE", type = BigDecimal.class),
            @ColumnResult(name = "AUTRE_CODE_MONNAIE", type = String.class)}

    ))})
public class ContratEcofie implements Serializable {

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
  @Column(name = "DATE_CONTRAT")
  private LocalDate dateContrat;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "OBJET")
  private String objet;
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
  @Size(min = 1, max = 255)
  @Column(name = "ENTREPRISE")
  private String entreprise;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_MONNAIE")
  private String codeMonnaie;
  @Basic(optional = false)
  @NotNull
  @Column(name = "COURS_DEVISE")
  private BigDecimal coursDevise;
  @Size(max = 150)
  @Column(name = "FILE_NAME")
  private String fileName;
  @JoinColumn(name = "CODE", referencedColumnName = "CODE")
  @ManyToOne(optional = false)
  private CodeContratEcofie code;
  @JoinColumn(name = "PAYS", referencedColumnName = "ID")
  @ManyToOne(optional = false)
  private PaysEcofie pays;

  public ContratEcofie() {
  }

  public ContratEcofie(Integer id) {
    this.id = id;
  }

  public ContratEcofie(Integer id, String uniteId, Integer anneeTrt, Integer trimestreTrt,
      LocalDate dateContrat, String objet, BigDecimal montantDevise, BigDecimal montantDinars,
      String entreprise, String codeMonnaie, BigDecimal coursDevise, String fileName,
      PaysEcofie pays, CodeContratEcofie code) {
    this.id = id;
    this.uniteId = uniteId;
    this.anneeTrt = anneeTrt;
    this.trimestreTrt = trimestreTrt;
    this.dateContrat = dateContrat;
    this.objet = objet;
    this.montantDevise = montantDevise;
    this.montantDinars = montantDinars;
    this.entreprise = entreprise;
    this.codeMonnaie = codeMonnaie;
    this.coursDevise = coursDevise;
    this.fileName = fileName;
    this.pays = pays;
    this.code = code;
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

  public void setUniteId(String uniteId) {
    this.uniteId = uniteId;
  }

  public LocalDate getDateContrat() {
    return dateContrat;
  }

  public void setDateContrat(LocalDate dateContrat) {
    this.dateContrat = dateContrat;
  }

  public String getObjet() {
    return objet;
  }

  public void setObjet(String objet) {
    this.objet = objet;
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

  public String getEntreprise() {
    return entreprise;
  }

  public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
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

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public CodeContratEcofie getCode() {
    return code;
  }

  public void setCode(CodeContratEcofie code) {
    this.code = code;
  }

  public PaysEcofie getPays() {
    return pays;
  }

  public void setPays(PaysEcofie pays) {
    this.pays = pays;
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
    if (!(object instanceof ContratEcofie)) {
      return false;
    }
    ContratEcofie other = (ContratEcofie) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.ecofie.ContratEcofie[ id=" + id + " ]";
  }

}
