/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.entities.emd;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import dz.airalgerie.ops.model.view.emd.VArcEmdTktComp;
import dz.airalgerie.portail.model.entities.tkt.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = DbSchemaName.PAX_ODS_PRG_EMD, name = "COMPENSATION")
public class CompensationEmd implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @JoinColumn(name = "EMD_NBR", referencedColumnName = "EMD_NBR")
  @OneToOne(fetch = FetchType.LAZY)
  private VArcEmdTktComp vArcEmdAmd;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "UNITE_INPUT")
  private String uniteInput;
  @Basic(optional = false)
  @Size(max = 100)
  @Column(name = "REF_DEMANDE")
  private String refDemande;
  @Basic(optional = false)
  @Size(max = 100)
  @Column(name = "RESULTAT_TRAITEMENT")
  private String resultatTraitement;
  @Size(max = 100)
  @Column(name = "REF_ACCORD")
  private String refAccord;
  @Size(max = 100)
  @Column(name = "REF_REPONSE")
  private String refReponse;
  @Size(max = 3)
  @Column(name = "CUR")
  private String cur;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MONTANT_HT")
  private BigDecimal montantHt;
  @Column(name = "MONTANT_TTC")
  private BigDecimal montantTtc;
  @Size(max = 255)
  @Column(name = "TAXES")
  private String taxes;
  @Size(max = 100)
  @Column(name = "DOC_VOUCHER")
  private String docVoucher;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "AGENT")
  private String agent;
  @Size(max = 200)
  @Column(name = "OBS")
  private String obs;
  @Basic(optional = false)
  @Column(name = "STATUT")
  private short statut;
  @Column(name = "STRUCTURE")
  private String structure;
  @Column(name = "DATE_OPERATION")
  private LocalDateTime dateOperation;
  @Column(name = "DATE_FIN")
  private LocalDateTime dateFin;
  @Column(name = "IS_TRANSFERED")
  private boolean isTransfered;
  @Column(name = "CODE_AGENCE")
  private String codeAgence;
  @Column(name = "DATE_TRANSFERT")
  private LocalDateTime dateTransfert;
  @JoinColumn(name = "MODE_REMBOURSEMENT", referencedColumnName = "MODE_REMBOURSEMENT")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private ModeRemboursement modeRemboursement;

  public CompensationEmd() {
  }

  public CompensationEmd(VArcEmdTktComp vArcEmdAmd) {
    this.vArcEmdAmd = vArcEmdAmd;
  }

  public CompensationEmd(VArcEmdTktComp vArcEmdAmd, String uniteInput, String refDemande,
      String resultatTraitement, String agent, short statut) {
    this.vArcEmdAmd = vArcEmdAmd;
    this.uniteInput = uniteInput;
    this.refDemande = refDemande;
    this.resultatTraitement = resultatTraitement;
    this.agent = agent;
    this.statut = statut;
  }

  public CompensationEmd(VArcEmdTktComp vArcEmdAmd, String uniteInput, String refDemande,
      String resultatTraitement, String refAccord, String refReponse, String cur,
      BigDecimal montantHt, BigDecimal montantTtc, String taxes, String docVoucher, String agent,
      String obs, short statut) {
    this.vArcEmdAmd = vArcEmdAmd;
    this.uniteInput = uniteInput;
    this.refDemande = refDemande;
    this.resultatTraitement = resultatTraitement;
    this.refAccord = refAccord;
    this.refReponse = refReponse;
    this.cur = cur;
    this.montantHt = montantHt;
    this.taxes = taxes;
    this.docVoucher = docVoucher;
    this.agent = agent;
    this.obs = obs;
    this.statut = statut;
  }

  public CompensationEmd(VArcEmdTktComp vArcEmdAmd, String uniteInput, String refDemande,
      String resultatTraitement, String refAccord, String refReponse, String cur,
      BigDecimal montantHt, BigDecimal montantTtc, String taxes, String docVoucher, String agent,
      String obs, short statut, String structure, LocalDateTime dateOperation,
      LocalDateTime dateFin, boolean isTransfered, String codeAgence, LocalDateTime dateTransfert,
      ModeRemboursement modeRemboursement) {
    this.vArcEmdAmd = vArcEmdAmd;
    this.uniteInput = uniteInput;
    this.refDemande = refDemande;
    this.resultatTraitement = resultatTraitement;
    this.refAccord = refAccord;
    this.refReponse = refReponse;
    this.cur = cur;
    this.montantHt = montantHt;
    this.montantTtc = montantTtc;
    this.taxes = taxes;
    this.docVoucher = docVoucher;
    this.agent = agent;
    this.obs = obs;
    this.statut = statut;
    this.structure = structure;
    this.dateOperation = dateOperation;
    this.dateFin = dateFin;
    this.isTransfered = isTransfered;
    this.codeAgence = codeAgence;
    this.dateTransfert = dateTransfert;
    this.modeRemboursement = modeRemboursement;
  }

  public String getUniteInput() {
    return uniteInput;
  }

  public void setUniteInput(String uniteInput) {
    this.uniteInput = uniteInput;
  }

  public String getRefDemande() {
    return refDemande;
  }

  public void setRefDemande(String refDemande) {
    this.refDemande = refDemande;
  }

  public String getResultatTraitement() {
    return resultatTraitement;
  }

  public void setResultatTraitement(String resultatTraitement) {
    this.resultatTraitement = resultatTraitement;
  }

  public String getRefAccord() {
    return refAccord;
  }

  public void setRefAccord(String refAccord) {
    this.refAccord = refAccord;
  }

  public String getRefReponse() {
    return refReponse;
  }

  public void setRefReponse(String refReponse) {
    this.refReponse = refReponse;
  }

  public String getCur() {
    return cur;
  }

  public void setCur(String cur) {
    this.cur = cur;
  }

  public BigDecimal getMontantHt() {
    return montantHt;
  }

  public void setMontantHt(BigDecimal montantHt) {
    this.montantHt = montantHt;
  }

  public BigDecimal getMontantTtc() {
    return montantTtc;
  }

  public void setMontantTtc(BigDecimal montantTtc) {
    this.montantTtc = montantTtc;
  }

  public String getTaxes() {
    return taxes;
  }

  public void setTaxes(String taxes) {
    this.taxes = taxes;
  }

  public String getDocVoucher() {
    return docVoucher;
  }

  public void setDocVoucher(String docVoucher) {
    this.docVoucher = docVoucher;
  }

  public String getAgent() {
    return agent;
  }

  public void setAgent(String agent) {
    this.agent = agent;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public short getStatut() {
    return statut;
  }

  public void setStatut(short statut) {
    this.statut = statut;
  }

  public VArcEmdTktComp getvArcEmdAmd() {
    return vArcEmdAmd;
  }

  public void setvArcEmdAmd(VArcEmdTktComp vArcEmdAmd) {
    this.vArcEmdAmd = vArcEmdAmd;
  }


  public String getStructure() {
    return structure;
  }

  public void setStructure(String structure) {
    this.structure = structure;
  }

  public LocalDateTime getDateOperation() {
    return dateOperation;
  }

  public void setDateOperation(LocalDateTime dateOperation) {
    this.dateOperation = dateOperation;
  }

  public LocalDateTime getDateFin() {
    return dateFin;
  }

  public void setDateFin(LocalDateTime dateFin) {
    this.dateFin = dateFin;
  }

  public boolean isIsTransfered() {
    return isTransfered;
  }

  public void setIsTransfered(boolean isTransfered) {
    this.isTransfered = isTransfered;
  }

  public String getCodeAgence() {
    return codeAgence;
  }

  public void setCodeAgence(String codeAgence) {
    this.codeAgence = codeAgence;
  }

  public LocalDateTime getDateTransfert() {
    return dateTransfert;
  }

  public void setDateTransfert(LocalDateTime dateTransfert) {
    this.dateTransfert = dateTransfert;
  }

  public ModeRemboursement getModeRemboursement() {
    return modeRemboursement;
  }

  public void setModeRemboursement(ModeRemboursement modeRemboursement) {
    this.modeRemboursement = modeRemboursement;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (vArcEmdAmd != null ? vArcEmdAmd.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CompensationEmd)) {
      return false;
    }
    CompensationEmd other = (CompensationEmd) object;
    if ((this.vArcEmdAmd == null && other.vArcEmdAmd != null)
        || (this.vArcEmdAmd != null && !this.vArcEmdAmd.equals(other.vArcEmdAmd))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.emd.CompensationEmd[ emd=" + vArcEmdAmd + " ]";
  }

}
