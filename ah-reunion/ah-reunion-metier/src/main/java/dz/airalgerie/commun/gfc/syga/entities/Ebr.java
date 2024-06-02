
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the ebr database table.
 * 
 */
@SuppressWarnings("rawtypes")
@Entity
@Table(name = "ebr")
public class Ebr implements Serializable, java.lang.Comparable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_EBR")
  private long numEbr;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_debut")
  private Date dateDebut;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_fin")
  private Date dateFin;

  @Column(name = "reseau")
  private char reseau;

  @Transient
  private TaxeHasBilletRem billetHasTaxe;

  @Transient
  private List<Eticket> etic = new ArrayList<Eticket>();

  @Transient
  private String res;

  @Transient
  private String date;

  @Transient
  private Detail detaille;

  @Transient
  private String monnaie;

  @Transient
  private String hadj;

  @Transient
  private String dh;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "ebr", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
  private Set<Billet> billets;

  public Ebr() {}

  public long getNumEbr() {
    return this.numEbr;
  }

  public void setNumEbr(long numEbr) {
    this.numEbr = numEbr;
  }

  public Date getDateDebut() {
    return this.dateDebut;
  }

  public void setDateDebut(Date dateDebut) {
    this.dateDebut = dateDebut;
  }

  public Date getDateFin() {
    return this.dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public Set<Billet> getBillets() {
    return this.billets;
  }

  public void setBillets(Set<Billet> billets) {
    this.billets = billets;
  }

  public char getReseau() {
    return reseau;
  }

  public void setReseau(char reseau) {
    this.reseau = reseau;
  }

  public TaxeHasBilletRem getBilletHasTaxe() {
    return billetHasTaxe;
  }

  public void setBilletHasTaxe(TaxeHasBilletRem bIlletHasTaxe) {
    this.billetHasTaxe = bIlletHasTaxe;
  }

  public List<Eticket> getEtic() {
    return etic;
  }

  public void setEtic(List<Eticket> etic) {
    this.etic = etic;
  }

  public String getRes() {
    return res;
  }

  public void setRes(String res) {
    this.res = res;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Detail getDetaille() {
    return detaille;
  }

  public void setDetaille(Detail detaille) {
    this.detaille = detaille;
  }

  public void addEtic(Eticket eTicket) {
    etic.add(eTicket);
  }

  public double getSumCach() {
    return this.detaille.getSumCash();

  }

  public double getSumChe() {
    return this.detaille.getSumChe();

  }

  public double getSumInv() {
    return this.detaille.getSumInv();

  }

  public double getSumCc() {
    return this.detaille.getSumCc();

  }

  public double getSumAutre() {
    return this.detaille.getSumAut();

  }

  public double getSumUatp() {
    return this.detaille.getSumUatp();

  }

  public double getSumInt() {
    return this.detaille.getSumInt();

  }

  public double getSumMnt_net() {
    return this.detaille.getSumMtNet();

  }

  public double getSumFra() {
    return this.detaille.getSumFra();

  }

  public double getSumTbr() {
    return this.detaille.getSumTbr();

  }

  public double getSumTxAero() {
    return this.detaille.getSumTxe();

  }

  public double getSumTxDZ() {
    return this.detaille.getSumTdz();

  }

  public double getSumTva() {
    return this.detaille.getSumTva();

  }

  public double getSumTe() {
    return this.detaille.getSumTe();

  }

  public double getSumTxDiv() {
    return this.detaille.getSumTaxDiv();

  }

  public double getSumFive_Percent() {
    return this.detaille.getSumFivePercent();

  }

  public double getSumThree_Percent() {
    return this.detaille.getSumThreePercent();

  }

  public double getSumHq() {
    return this.detaille.getSumHq();

  }

  public double getSumYr() {
    return this.detaille.getSumYr();

  }

  public double getSumD9() {
    return this.detaille.getSumD9();

  }

  public double getSumNh() {
    return this.detaille.getSumNh();

  }

  public double getSumTotalNet() {
    return this.detaille.getSumTotalNet();

  }

  public double getSumCashChec() {
    return getSumChe() + getSumCach();

  }

  public double getSumInvCc() {
    return getSumCc() + getSumInv();

  }

  public double getSumAuUatp() {
    return getSumUatp() + getSumAutre() + getSumInt();

  }

  public double getTotalNV() {
    return getSumAuUatp() + getSumInvCc() + getSumCashChec();

  }

  public double getTotalV() {
    return getSumTxDiv() + getSumTe() + getSumTva() + getSumTxAero() + getSumMnt_net()
        + getSumTxDZ() + getSumTbr();

  }

  public String getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(String monnaie) {
    this.monnaie = monnaie;
  }

  public String getHadj() {
    return hadj;
  }

  public void setHadj(String hadj) {
    this.hadj = hadj;
  }

  public String getDh() {
    return dh;
  }

  public void setDh(String dH) {
    dh = dH;
  }

  public int compareTo(Object other) {
    long nombre1 = ((Ebr) other).getNumEbr();
    long nombre2 = this.getNumEbr();
    if (nombre1 > nombre2)
      return -1;
    else if (nombre1 == nombre2)
      return 0;
    else
      return 1;
  }

}
