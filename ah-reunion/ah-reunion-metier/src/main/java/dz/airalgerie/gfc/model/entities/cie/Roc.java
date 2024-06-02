/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cie;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(catalog = "CPTA", schema = "CE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Roc.findAll", query = "SELECT r FROM Roc r"),
    @NamedQuery(name = "Roc.findById", query = "SELECT r FROM Roc r WHERE r.id = :id"),
    @NamedQuery(name = "Roc.findByDatTrt", query = "SELECT r FROM Roc r WHERE r.datTrt = :datTrt"),
    @NamedQuery(name = "Roc.findByCptPage",
        query = "SELECT r FROM Roc r WHERE r.cptPage = :cptPage"),
    @NamedQuery(name = "Roc.findByNumJou", query = "SELECT r FROM Roc r WHERE r.numJou = :numJou"),
    @NamedQuery(name = "Roc.findByCptPiece",
        query = "SELECT r FROM Roc r WHERE r.cptPiece = :cptPiece"),
    @NamedQuery(name = "Roc.findByCptGen", query = "SELECT r FROM Roc r WHERE r.cptGen = :cptGen"),
    @NamedQuery(name = "Roc.findByCptPart",
        query = "SELECT r FROM Roc r WHERE r.cptPart = :cptPart"),
    @NamedQuery(name = "Roc.findByCptLib", query = "SELECT r FROM Roc r WHERE r.cptLib = :cptLib"),
    @NamedQuery(name = "Roc.findByCptSensd",
        query = "SELECT r FROM Roc r WHERE r.cptSensd = :cptSensd"),
    @NamedQuery(name = "Roc.findByCptDebCgn",
        query = "SELECT r FROM Roc r WHERE r.cptDebCgn = :cptDebCgn"),
    @NamedQuery(name = "Roc.findByCptSensc",
        query = "SELECT r FROM Roc r WHERE r.cptSensc = :cptSensc"),
    @NamedQuery(name = "Roc.findByCptCreCgn",
        query = "SELECT r FROM Roc r WHERE r.cptCreCgn = :cptCreCgn"),
    @NamedQuery(name = "Roc.findByCodeMon",
        query = "SELECT r FROM Roc r WHERE r.codeMon = :codeMon"),
    @NamedQuery(name = "Roc.findByCptRef", query = "SELECT r FROM Roc r WHERE r.cptRef = :cptRef"),
    @NamedQuery(name = "Roc.findByCptLigne",
        query = "SELECT r FROM Roc r WHERE r.cptLigne = :cptLigne"),
    @NamedQuery(name = "Roc.findByCptMaj", query = "SELECT r FROM Roc r WHERE r.cptMaj = :cptMaj"),
    @NamedQuery(name = "Roc.findByCptUnite",
        query = "SELECT r FROM Roc r WHERE r.cptUnite = :cptUnite"),
    @NamedQuery(name = "Roc.findByCptCc", query = "SELECT r FROM Roc r WHERE r.cptCc = :cptCc"),
    @NamedQuery(name = "Roc.findByCodeCpt",
        query = "SELECT r FROM Roc r WHERE r.codeCpt = :codeCpt"),
    @NamedQuery(name = "Roc.findByDateSaisie",
        query = "SELECT r FROM Roc r WHERE r.dateSaisie = :dateSaisie"),
    @NamedQuery(name = "Roc.findByCodeAgent",
        query = "SELECT r FROM Roc r WHERE r.codeAgent = :codeAgent")})
public class Roc implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DAT_TRT", nullable = false)
  private int datTrt;
  @Size(max = 4)
  @Column(name = "CPT_PAGE", length = 4)
  private String cptPage;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "NUM_JOU", nullable = false, length = 2)
  private String numJou;
  @Column(name = "CPT_PIECE")
  private Integer cptPiece;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_GEN", nullable = false, length = 6)

  private String cptGen;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "CPT_PART", nullable = false, length = 6)
  private String cptPart;
  @Size(max = 30)
  @Column(name = "CPT_LIB", length = 30)
  private String cptLib;
  @Column(name = "CPT_SENSD")
  private Short cptSensd;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "CPT_DEB_CGN", precision = 18, scale = 2)
  private BigDecimal cptDebCgn;
  @Column(name = "CPT_SENSC")
  private Short cptSensc;

  @Column(name = "CPT_CRE_CGN", precision = 18, scale = 2)
  private BigDecimal cptCreCgn;
  @Size(max = 3)
  @Column(name = "CODE_MON", length = 3)
  private String codeMon;
  @Size(max = 25)
  @Column(name = "CPT_REF", length = 25)
  private String cptRef;
  @Column(name = "CPT_LIGNE")
  private Short cptLigne;
  @Column(name = "CPT_MAJ")
  private Character cptMaj;
  @Size(max = 2)
  @Column(name = "CPT_UNITE", length = 2)
  private String cptUnite;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CPT_CC", nullable = false)
  private short cptCc;
  @Column(name = "CODE_CPT")
  private Short codeCpt;
  @Column(name = "DATE_SAISIE")
  private Integer dateSaisie;
  @Column(name = "CODE_AGENT")
  private Integer codeAgent;

  public Roc() {}

  public Roc(Integer id) {
    this.id = id;
  }

  public Roc(Integer id, int datTrt, String numJou, String cptPart, short cptCc) {
    this.id = id;
    this.datTrt = datTrt;
    this.numJou = numJou;
    this.cptPart = cptPart;
    this.cptCc = cptCc;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getDatTrt() {
    return datTrt;
  }

  public void setDatTrt(int datTrt) {
    this.datTrt = datTrt;
  }

  public String getCptPage() {
    return cptPage;
  }

  public void setCptPage(String cptPage) {
    this.cptPage = cptPage;
  }

  public String getNumJou() {
    return numJou;
  }

  public void setNumJou(String numJou) {
    this.numJou = numJou;
  }

  public Integer getCptPiece() {
    return cptPiece;
  }

  public void setCptPiece(Integer cptPiece) {
    this.cptPiece = cptPiece;
  }

  public String getCptGen() {
    return cptGen;
  }

  public void setCptGen(String cptGen) {
    this.cptGen = cptGen;
  }

  public String getCptPart() {
    return cptPart;
  }

  public void setCptPart(String cptPart) {
    this.cptPart = cptPart;
  }

  public String getCptLib() {
    return cptLib;
  }

  public void setCptLib(String cptLib) {
    this.cptLib = cptLib;
  }

  public Short getCptSensd() {
    return cptSensd;
  }

  public void setCptSensd(Short cptSensd) {
    this.cptSensd = cptSensd;
  }

  public BigDecimal getCptDebCgn() {
    return cptDebCgn;
  }

  public void setCptDebCgn(BigDecimal cptDebCgn) {
    this.cptDebCgn = cptDebCgn;
  }

  public Short getCptSensc() {
    return cptSensc;
  }

  public void setCptSensc(Short cptSensc) {
    this.cptSensc = cptSensc;
  }

  public BigDecimal getCptCreCgn() {
    return cptCreCgn;
  }

  public void setCptCreCgn(BigDecimal cptCreCgn) {
    this.cptCreCgn = cptCreCgn;
  }

  public String getCodeMon() {
    return codeMon;
  }

  public void setCodeMon(String codeMon) {
    this.codeMon = codeMon;
  }

  public String getCptRef() {
    return cptRef;
  }

  public void setCptRef(String cptRef) {
    this.cptRef = cptRef;
  }

  public Short getCptLigne() {
    return cptLigne;
  }

  public void setCptLigne(Short cptLigne) {
    this.cptLigne = cptLigne;
  }

  public Character getCptMaj() {
    return cptMaj;
  }

  public void setCptMaj(Character cptMaj) {
    this.cptMaj = cptMaj;
  }

  public String getCptUnite() {
    return cptUnite;
  }

  public void setCptUnite(String cptUnite) {
    this.cptUnite = cptUnite;
  }

  public short getCptCc() {
    return cptCc;
  }

  public void setCptCc(short cptCc) {
    this.cptCc = cptCc;
  }

  public Short getCodeCpt() {
    return codeCpt;
  }

  public void setCodeCpt(Short codeCpt) {
    this.codeCpt = codeCpt;
  }

  public Integer getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Integer dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public Integer getCodeAgent() {
    return codeAgent;
  }

  public void setCodeAgent(Integer codeAgent) {
    this.codeAgent = codeAgent;
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
    if (!(object instanceof Roc)) {
      return false;
    }
    Roc other = (Roc) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.Roc[ id=" + id + " ]";
  }

}
