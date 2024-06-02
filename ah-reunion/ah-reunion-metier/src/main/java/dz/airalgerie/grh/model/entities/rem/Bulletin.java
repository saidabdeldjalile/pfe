/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import dz.airalgerie.commun.model.entities.commun.Filiale;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "BULLETIN", schema = Utils.dbSchema)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Bulletin.findAll", query = "SELECT b FROM Bulletin b"),
    @NamedQuery(name = "Bulletin.findByMatricule",
        query = "SELECT b FROM Bulletin b WHERE b.bulletinPK.matricule = :matricule"),
    @NamedQuery(name = "Bulletin.findByDatePai",
        query = "SELECT b FROM Bulletin b WHERE b.bulletinPK.datePai = :datePai"),
    @NamedQuery(name = "Bulletin.findByDateTrt",
        query = "SELECT b FROM Bulletin b WHERE b.bulletinPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "Bulletin.findByBulPrim",
        query = "SELECT b FROM Bulletin b WHERE b.bulletinPK.bulPrim = :bulPrim"),
    @NamedQuery(name = "Bulletin.findByCodeFil",
        query = "SELECT b FROM Bulletin b WHERE b.bulletinPK.codeFil = :codeFil"),
    @NamedQuery(name = "Bulletin.findByMoisPai",
        query = "SELECT b FROM Bulletin b WHERE b.moisPai = :moisPai"),
    @NamedQuery(name = "Bulletin.findByAnnePai",
        query = "SELECT b FROM Bulletin b WHERE b.annePai = :annePai"),
    @NamedQuery(name = "Bulletin.findByRefEntete",
        query = "SELECT b FROM Bulletin b WHERE b.refEntete = :refEntete"),
    @NamedQuery(name = "Bulletin.findByCatEntete",
        query = "SELECT b FROM Bulletin b WHERE b.catEntete = :catEntete"),
    @NamedQuery(name = "Bulletin.findByNom", query = "SELECT b FROM Bulletin b WHERE b.nom = :nom"),
    @NamedQuery(name = "Bulletin.findByFonction",
        query = "SELECT b FROM Bulletin b WHERE b.fonction = :fonction"),
    @NamedQuery(name = "Bulletin.findByGrpChap",
        query = "SELECT b FROM Bulletin b WHERE b.grpChap = :grpChap"),
    @NamedQuery(name = "Bulletin.findByAffectat",
        query = "SELECT b FROM Bulletin b WHERE b.affectat = :affectat"),
    @NamedQuery(name = "Bulletin.findByAdresse",
        query = "SELECT b FROM Bulletin b WHERE b.adresse = :adresse"),
    @NamedQuery(name = "Bulletin.findByBanqLib",
        query = "SELECT b FROM Bulletin b WHERE b.banqLib = :banqLib"),
    @NamedQuery(name = "Bulletin.findByBnqNcpt",
        query = "SELECT b FROM Bulletin b WHERE b.bnqNcpt = :bnqNcpt"),
    @NamedQuery(name = "Bulletin.findByCodCatg",
        query = "SELECT b FROM Bulletin b WHERE b.codCatg = :codCatg"),
    @NamedQuery(name = "Bulletin.findByCodEchl",
        query = "SELECT b FROM Bulletin b WHERE b.codEchl = :codEchl"),
    @NamedQuery(name = "Bulletin.findByDateEnt",
        query = "SELECT b FROM Bulletin b WHERE b.dateEnt = :dateEnt"),
    @NamedQuery(name = "Bulletin.findByCodeCivil",
        query = "SELECT b FROM Bulletin b WHERE b.codeCivil = :codeCivil"),
    @NamedQuery(name = "Bulletin.findByEnfantm10",
        query = "SELECT b FROM Bulletin b WHERE b.enfantm10 = :enfantm10"),
    @NamedQuery(name = "Bulletin.findByEnfantp10",
        query = "SELECT b FROM Bulletin b WHERE b.enfantp10 = :enfantp10"),
    @NamedQuery(name = "Bulletin.findByCodeIts",
        query = "SELECT b FROM Bulletin b WHERE b.codeIts = :codeIts"),
    @NamedQuery(name = "Bulletin.findBySalBase",
        query = "SELECT b FROM Bulletin b WHERE b.salBase = :salBase"),
    @NamedQuery(name = "Bulletin.findByIndice",
        query = "SELECT b FROM Bulletin b WHERE b.indice = :indice"),
    @NamedQuery(name = "Bulletin.findByTaux",
        query = "SELECT b FROM Bulletin b WHERE b.taux = :taux"),
    @NamedQuery(name = "Bulletin.findByCodeTech",
        query = "SELECT b FROM Bulletin b WHERE b.codeTech = :codeTech"),
    @NamedQuery(name = "Bulletin.findByPhvReel",
        query = "SELECT b FROM Bulletin b WHERE b.phvReel = :phvReel")})
public class Bulletin implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BulletinPK bulletinPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "MOIS_PAI")
  private String moisPai;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ANNE_PAI")
  private short annePai;
  @Size(max = 50)
  @Column(name = "REF_ENTETE")
  private String refEntete;
  @Size(max = 100)
  @Column(name = "CAT_ENTETE")
  private String catEntete;
  @Size(max = 100)
  @Column(name = "NOM")
  private String nom;
  @Size(max = 50)
  @Column(name = "FONCTION")
  private String fonction;
  @Size(max = 4)
  @Column(name = "GRP_CHAP")
  private String grpChap;
  @Size(max = 100)
  @Column(name = "AFFECTAT")
  private String affectat;
  @Size(max = 100)
  @Column(name = "ADRESSE")
  private String adresse;
  @Size(max = 50)
  @Column(name = "BANQ_LIB")
  private String banqLib;
  @Size(max = 50)
  @Column(name = "BNQ_NCPT")
  private String bnqNcpt;
  @Size(max = 3)
  @Column(name = "COD_CATG")
  private String codCatg;
  @Size(max = 3)
  @Column(name = "COD_ECHL")
  private String codEchl;
  @Column(name = "DATE_ENT")
  @Temporal(TemporalType.DATE)
  private Date dateEnt;
  @Column(name = "CODE_CIVIL")
  private Character codeCivil;
  @Column(name = "ENFANTM10")
  private Integer enfantm10;
  @Column(name = "ENFANTP10")
  private Integer enfantp10;
  @Column(name = "CODE_ITS")
  private Integer codeIts;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "SAL_BASE")
  private BigDecimal salBase;
  @Column(name = "INDICE")
  private Integer indice;
  @Size(max = 10)
  @Column(name = "TAUX")
  private String taux;
  @Column(name = "CODE_TECH")
  private Character codeTech;
  @Column(name = "PHV_REEL")
  private BigDecimal phvReel;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bulletin")
  private Collection<BulletinPointage> bulletinPointageCollection;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "bulletin")
  private BulletinTotal bulletinTotal;
  @JoinColumn(name = "CODE_FIL", referencedColumnName = "CODE_FIL", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Filiale filiale;

  public Bulletin() {}

  public Bulletin(BulletinPK bulletinPK) {
    this.bulletinPK = bulletinPK;
  }

  public Bulletin(BulletinPK bulletinPK, String moisPai, short annePai) {
    this.bulletinPK = bulletinPK;
    this.moisPai = moisPai;
    this.annePai = annePai;
  }

  public Bulletin(int matricule, int datePai, int dateTrt, boolean bulPrim, Character codeFil) {
    this.bulletinPK = new BulletinPK(matricule, datePai, dateTrt, bulPrim, codeFil);
  }

  public BulletinPK getBulletinPK() {
    return bulletinPK;
  }

  public void setBulletinPK(BulletinPK bulletinPK) {
    this.bulletinPK = bulletinPK;
  }

  public String getMoisPai() {
    return moisPai;
  }

  public void setMoisPai(String moisPai) {
    this.moisPai = moisPai;
  }

  public short getAnnePai() {
    return annePai;
  }

  public void setAnnePai(short annePai) {
    this.annePai = annePai;
  }

  public String getRefEntete() {
    return refEntete;
  }

  public void setRefEntete(String refEntete) {
    this.refEntete = refEntete;
  }

  public String getCatEntete() {
    return catEntete;
  }

  public void setCatEntete(String catEntete) {
    this.catEntete = catEntete;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getFonction() {
    return fonction;
  }

  public void setFonction(String fonction) {
    this.fonction = fonction;
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

  public String getAffectat() {
    return affectat;
  }

  public void setAffectat(String affectat) {
    this.affectat = affectat;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getBanqLib() {
    return banqLib;
  }

  public void setBanqLib(String banqLib) {
    this.banqLib = banqLib;
  }

  public String getBnqNcpt() {
    return bnqNcpt;
  }

  public void setBnqNcpt(String bnqNcpt) {
    this.bnqNcpt = bnqNcpt;
  }

  public String getCodCatg() {
    return codCatg;
  }

  public void setCodCatg(String codCatg) {
    this.codCatg = codCatg;
  }

  public String getCodEchl() {
    return codEchl;
  }

  public void setCodEchl(String codEchl) {
    this.codEchl = codEchl;
  }

  public Date getDateEnt() {
    return dateEnt;
  }

  public void setDateEnt(Date dateEnt) {
    this.dateEnt = dateEnt;
  }

  public Character getCodeCivil() {
    return codeCivil;
  }

  public void setCodeCivil(Character codeCivil) {
    this.codeCivil = codeCivil;
  }

  public Integer getEnfantm10() {
    return enfantm10;
  }

  public void setEnfantm10(Integer enfantm10) {
    this.enfantm10 = enfantm10;
  }

  public Integer getEnfantp10() {
    return enfantp10;
  }

  public void setEnfantp10(Integer enfantp10) {
    this.enfantp10 = enfantp10;
  }

  public Integer getCodeIts() {
    return codeIts;
  }

  public void setCodeIts(Integer codeIts) {
    this.codeIts = codeIts;
  }

  public BigDecimal getSalBase() {
    return salBase;
  }

  public void setSalBase(BigDecimal salBase) {
    this.salBase = salBase;
  }

  public Integer getIndice() {
    return indice;
  }

  public void setIndice(Integer indice) {
    this.indice = indice;
  }

  public String getTaux() {
    return taux;
  }

  public void setTaux(String taux) {
    this.taux = taux;
  }

  public Character getCodeTech() {
    return codeTech;
  }

  public void setCodeTech(Character codeTech) {
    this.codeTech = codeTech;
  }

  public BigDecimal getPhvReel() {
    return phvReel;
  }

  public void setPhvReel(BigDecimal phvReel) {
    this.phvReel = phvReel;
  }

  @XmlTransient
  public Collection<BulletinPointage> getBulletinPointageCollection() {
    return bulletinPointageCollection;
  }

  public void setBulletinPointageCollection(
      Collection<BulletinPointage> bulletinPointageCollection) {
    this.bulletinPointageCollection = bulletinPointageCollection;
  }

  public BulletinTotal getBulletinTotal() {
    return bulletinTotal;
  }

  public void setBulletinTotal(BulletinTotal bulletinTotal) {
    this.bulletinTotal = bulletinTotal;
  }

  public Filiale getFiliale() {
    return filiale;
  }

  public void setFiliale(Filiale filiale) {
    this.filiale = filiale;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bulletinPK != null ? bulletinPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Bulletin)) {
      return false;
    }
    Bulletin other = (Bulletin) object;
    if ((this.bulletinPK == null && other.bulletinPK != null)
        || (this.bulletinPK != null && !this.bulletinPK.equals(other.bulletinPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.SAISIE.Bulletin[ bulletinPK=" + bulletinPK + " ]";
  }

}
