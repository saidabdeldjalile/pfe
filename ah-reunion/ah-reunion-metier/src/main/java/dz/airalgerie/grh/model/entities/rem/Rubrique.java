/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nabila
 */
@Entity
@Table(name = "RUBRIQUE", schema = Utils.dbSchema)

public class Rubrique implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_RUB")
  private String codeRub;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "LIBE_RUB")
  private String libeRub;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_DEB")
  private int dateDeb;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FIN")
  private int dateFin;
  @Size(max = 50)
  @Column(name = "COMPTE_PSL")
  private String comptePsl;
  @Size(max = 50)
  @Column(name = "COMPTE_PN")
  private String comptePn;
  @Column(name = "IMPOSABLE")
  private Boolean imposable;
  @Column(name = "COTISABLE")
  private Boolean cotisable;
  @Column(name = "CGE_PAYE")
  private Boolean cgePaye;
  @Column(name = "SAL_POSTE")
  private Boolean salPoste;
  @Column(name = "SAL_BRUT")
  private Boolean salBrut;
  @Column(name = "NET_FISCAL")
  private Boolean netFiscal;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "PART_OUVR")
  private BigDecimal partOuvr;
  @Column(name = "PART_PATR")
  private BigDecimal partPatr;
  @Column(name = "TX_VERS_FORF")
  private BigDecimal txVersForf;
  @Column(name = "TX_FOS")
  private BigDecimal txFos;
  @Column(name = "TX_RET_ANTICIPE")
  private BigDecimal txRetAnticipe;
  @Column(name = "TX_CHGE_SOCIALE")
  private BigDecimal txChgeSociale;
  @Column(name = "TX_ASSUR_SOCIALE")
  private BigDecimal txAssurSociale;
  @Column(name = "TX_ACC_TRAVAIL")
  private BigDecimal txAccTravail;
  @Column(name = "TX_FN_LOGEMENT")
  private BigDecimal txFnLogement;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "rubrique")
  private List<Constante> constanteList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeRub")
  private List<RubSystematique> rubSystematiqueList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeRub")
  private List<RubMensuel> rubMensuelList;

  public Rubrique() {}

  public Rubrique(String codeRub) {
    this.codeRub = codeRub;
  }

  public Rubrique(String codeRub, String libeRub, int dateDeb, int dateFin) {
    this.codeRub = codeRub;
    this.libeRub = libeRub;
    this.dateDeb = dateDeb;
    this.dateFin = dateFin;
  }

  public String getCodeRub() {
    return codeRub;
  }

  public void setCodeRub(String codeRub) {
    this.codeRub = codeRub;
  }

  public String getLibeRub() {
    return libeRub;
  }

  public void setLibeRub(String libeRub) {
    this.libeRub = libeRub;
  }

  public int getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(int dateDeb) {
    this.dateDeb = dateDeb;
  }

  public int getDateFin() {
    return dateFin;
  }

  public void setDateFin(int dateFin) {
    this.dateFin = dateFin;
  }

  public String getComptePsl() {
    return comptePsl;
  }

  public void setComptePsl(String comptePsl) {
    this.comptePsl = comptePsl;
  }

  public String getComptePn() {
    return comptePn;
  }

  public void setComptePn(String comptePn) {
    this.comptePn = comptePn;
  }

  public Boolean getImposable() {
    return imposable;
  }

  public void setImposable(Boolean imposable) {
    this.imposable = imposable;
  }

  public Boolean getCotisable() {
    return cotisable;
  }

  public void setCotisable(Boolean cotisable) {
    this.cotisable = cotisable;
  }

  public Boolean getCgePaye() {
    return cgePaye;
  }

  public void setCgePaye(Boolean cgePaye) {
    this.cgePaye = cgePaye;
  }

  public Boolean getSalPoste() {
    return salPoste;
  }

  public void setSalPoste(Boolean salPoste) {
    this.salPoste = salPoste;
  }

  public Boolean getSalBrut() {
    return salBrut;
  }

  public void setSalBrut(Boolean salBrut) {
    this.salBrut = salBrut;
  }

  public Boolean getNetFiscal() {
    return netFiscal;
  }

  public void setNetFiscal(Boolean netFiscal) {
    this.netFiscal = netFiscal;
  }

  public BigDecimal getPartOuvr() {
    return partOuvr;
  }

  public void setPartOuvr(BigDecimal partOuvr) {
    this.partOuvr = partOuvr;
  }

  public BigDecimal getPartPatr() {
    return partPatr;
  }

  public void setPartPatr(BigDecimal partPatr) {
    this.partPatr = partPatr;
  }

  public BigDecimal getTxVersForf() {
    return txVersForf;
  }

  public void setTxVersForf(BigDecimal txVersForf) {
    this.txVersForf = txVersForf;
  }

  public BigDecimal getTxFos() {
    return txFos;
  }

  public void setTxFos(BigDecimal txFos) {
    this.txFos = txFos;
  }

  public BigDecimal getTxRetAnticipe() {
    return txRetAnticipe;
  }

  public void setTxRetAnticipe(BigDecimal txRetAnticipe) {
    this.txRetAnticipe = txRetAnticipe;
  }

  public BigDecimal getTxChgeSociale() {
    return txChgeSociale;
  }

  public void setTxChgeSociale(BigDecimal txChgeSociale) {
    this.txChgeSociale = txChgeSociale;
  }

  public BigDecimal getTxAssurSociale() {
    return txAssurSociale;
  }

  public void setTxAssurSociale(BigDecimal txAssurSociale) {
    this.txAssurSociale = txAssurSociale;
  }

  public BigDecimal getTxAccTravail() {
    return txAccTravail;
  }

  public void setTxAccTravail(BigDecimal txAccTravail) {
    this.txAccTravail = txAccTravail;
  }

  public BigDecimal getTxFnLogement() {
    return txFnLogement;
  }

  public void setTxFnLogement(BigDecimal txFnLogement) {
    this.txFnLogement = txFnLogement;
  }

  @XmlTransient
  public List<Constante> getConstanteList() {
    return constanteList;
  }

  public void setConstanteList(List<Constante> constanteList) {
    this.constanteList = constanteList;
  }

  @XmlTransient
  public List<RubSystematique> getRubSystematiqueList() {
    return rubSystematiqueList;
  }

  public void setRubSystematiqueList(List<RubSystematique> rubSystematiqueList) {
    this.rubSystematiqueList = rubSystematiqueList;
  }

  @XmlTransient
  public List<RubMensuel> getRubMensuelList() {
    return rubMensuelList;
  }

  public void setRubMensuelList(List<RubMensuel> rubMensuelList) {
    this.rubMensuelList = rubMensuelList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeRub != null ? codeRub.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Rubrique)) {
      return false;
    }
    Rubrique other = (Rubrique) object;
    if ((this.codeRub == null && other.codeRub != null)
        || (this.codeRub != null && !this.codeRub.equals(other.codeRub))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.Rubrique[ codeRub=" + codeRub + " ]";
  }

}
