/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.cellulecrise;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(schema = "VCC", name = "CANDIDATURE")
// @XmlRootElement
// @NamedQueries({
// @NamedQuery(name = "Candidature.findAll", query = "SELECT c FROM Candidature c"),
// @NamedQuery(name = "Candidature.findByMatricule", query = "SELECT c FROM Candidature c WHERE
// c.matricule = :matricule"),
// @NamedQuery(name = "Candidature.findByDateSaisie", query = "SELECT c FROM Candidature c WHERE
// c.dateSaisie = :dateSaisie"),
// @NamedQuery(name = "Candidature.findByMobile", query = "SELECT c FROM Candidature c WHERE
// c.mobile = :mobile"),
// @NamedQuery(name = "Candidature.findByFixe", query = "SELECT c FROM Candidature c WHERE c.fixe =
// :fixe"),
// @NamedQuery(name = "Candidature.findByApptitudePhysique", query = "SELECT c FROM Candidature c
// WHERE c.apptitudePhysique = :apptitudePhysique"),
// @NamedQuery(name = "Candidature.findByUserValid", query = "SELECT c FROM Candidature c WHERE
// c.userValid = :userValid"),
// @NamedQuery(name = "Candidature.findByAdminValid", query = "SELECT c FROM Candidature c WHERE
// c.adminValid = :adminValid"),
// @NamedQuery(name = "Candidature.findByMatriculeValid", query = "SELECT c FROM Candidature c WHERE
// c.matriculeValid = :matriculeValid"),
// @NamedQuery(name = "Candidature.findByDateValid", query = "SELECT c FROM Candidature c WHERE
// c.dateValid = :dateValid")})
public class Candidature implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.DATE)
  private Date dateSaisie;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "MOBILE")
  private String mobile;
  @Size(max = 12)
  @Column(name = "FIXE")
  private String fixe;
  @Basic(optional = false)
  @NotNull
  @Column(name = "APPTITUDE_PHYSIQUE")
  private boolean apptitudePhysique;
  @Basic(optional = false)
  @NotNull
  @Column(name = "USER_VALID")
  private boolean userValid;
  @Basic(optional = false)
  @Column(name = "ADMIN_VALID")
  private Boolean adminValid;
  @Basic(optional = false)
  @Column(name = "DIR_VALID")
  private boolean dirValid;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE_VALID")
  private int matriculeValid;
  @Column(name = "DATE_VALID")
  @Temporal(TemporalType.DATE)
  private Date dateValid;
  @Column(name = "QUALIFICATION")
  private String qualification;
  @Basic(optional = false)
  @NotNull
  @Column(name = "USER_DELETE")
  private boolean userDelete;

  @JoinColumn(name = "CODE_ADHESION", referencedColumnName = "CODE_ADHESION")
  @ManyToOne(optional = false)
  private Adhesion codeAdhesion;
  @JoinColumn(name = "CODE_REGIME_TRAVAIL", referencedColumnName = "CODE_REGIME_TRAVAIL")
  @ManyToOne(optional = false)
  private RegimeTravail codeRegimeTravail;

  public Candidature() {}

  public Candidature(Integer matricule) {
    this.matricule = matricule;
  }

  public Candidature(Integer matricule, Date dateSaisie, String mobile, boolean apptitudePhysique,
      boolean userValid, Boolean adminValid, boolean dirValid, int matriculeValid,
      String qualification, boolean userDelete) {
    this.matricule = matricule;
    this.dateSaisie = dateSaisie;
    this.mobile = mobile;
    this.apptitudePhysique = apptitudePhysique;
    this.userValid = userValid;
    this.adminValid = adminValid;
    this.dirValid = dirValid;
    this.matriculeValid = matriculeValid;
    this.qualification = qualification;
    this.userDelete = userDelete;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getFixe() {
    return fixe;
  }

  public void setFixe(String fixe) {
    this.fixe = fixe;
  }

  public boolean getApptitudePhysique() {
    return apptitudePhysique;
  }

  public void setApptitudePhysique(boolean apptitudePhysique) {
    this.apptitudePhysique = apptitudePhysique;
  }

  public boolean getUserValid() {
    return userValid;
  }

  public void setUserValid(boolean userValid) {
    this.userValid = userValid;
  }

  public Boolean getAdminValid() {
    return adminValid;
  }

  public void setAdminValid(Boolean adminValid) {
    this.adminValid = adminValid;
  }

  public int getMatriculeValid() {
    return matriculeValid;
  }

  public void setMatriculeValid(int matriculeValid) {
    this.matriculeValid = matriculeValid;
  }

  public Date getDateValid() {
    return dateValid;
  }

  public void setDateValid(Date dateValid) {
    this.dateValid = dateValid;
  }

  public Adhesion getCodeAdhesion() {
    return codeAdhesion;
  }

  public void setCodeAdhesion(Adhesion codeAdhesion) {
    this.codeAdhesion = codeAdhesion;
  }

  public RegimeTravail getCodeRegimeTravail() {
    return codeRegimeTravail;
  }

  public void setCodeRegimeTravail(RegimeTravail codeRegimeTravail) {
    this.codeRegimeTravail = codeRegimeTravail;
  }

  public boolean getDirValid() {
    return dirValid;
  }

  public void setDirValid(boolean dirValid) {
    this.dirValid = dirValid;
  }

  public String getQualification() {
    return qualification;
  }

  public void setQualification(String qualification) {
    this.qualification = qualification;
  }

  public boolean getUserDelete() {
    return userDelete;
  }

  public void setUserDelete(boolean userDelete) {
    this.userDelete = userDelete;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (matricule != null ? matricule.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Candidature)) {
      return false;
    }
    Candidature other = (Candidature) object;
    if ((this.matricule == null && other.matricule != null)
        || (this.matricule != null && !this.matricule.equals(other.matricule))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Candidature[ matricule=" + matricule + " ]";
  }

}
