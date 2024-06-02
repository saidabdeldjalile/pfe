
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the operation database table.
 * 
 */
@SuppressWarnings("rawtypes")
@Entity
@Table(name = "operation")
public class Operation implements Serializable, java.lang.Comparable {

  /*
   * @EJB
   * 
   * private Generer_billetLocal generer_billetLocal;
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_opr")
  private long num_opr;

  @Column(name = "DebitCredit")
  private String debitCredit;

  @Column(name = "Libelle")
  private String libelle;

  @Column(name = "Montant")
  private BigDecimal montant;

  @Column(name = "Libelle_1")
  private String libelle_1;

  @Column(name = "Libelle_2")
  private String libelle_2;

  @Transient
  private BigDecimal dEbit;

  @Transient
  private BigDecimal cRedit;

  @Transient
  private String cHiffreEnLettre;

  @Transient
  private String rEcDep;

  @Transient
  private String pAy;

  @Transient
  private Date date;

  @Transient
  private String dateS;

  @Transient
  private String rp;

  @Transient
  private String monnaie;

  @Transient
  private String name;

  @Transient
  private Sage sage;

  // bi-directional many-to-one association to JournalCaisse
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Journal_caisse_Num_journal")
  private JournalCaisse journalCaisse;

  public Operation() {

    dEbit = new BigDecimal(0);
    cRedit = new BigDecimal(0);
  }

  public long getNum_opr() {
    return this.num_opr;
  }

  public void setNum_opr(long num_opr) {
    this.num_opr = num_opr;
  }

  public String getDebitCredit() {
    return this.debitCredit;
  }

  public void setDebitCredit(String debitCredit) {
    this.debitCredit = debitCredit;
  }

  public String getLibelle() {
    return this.libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BigDecimal getMontant() {

    return montant;
    // return this.montant;
  }

  public void setMontant(BigDecimal montant) {
    this.montant = montant;
  }

  public JournalCaisse getJournalCaisse() {
    return this.journalCaisse;
  }

  public void setJournalCaisse(JournalCaisse journalCaisse) {
    this.journalCaisse = journalCaisse;
  }

  public BigDecimal getdEbit() {

    return dEbit;
    // return dEbit;
  }

  public void setdEbit(BigDecimal dEbit) {
    this.dEbit = dEbit;// generer_billetLocal.dEuxcHiffre(dEbit);//dEbit;//dEuxcHiffre(dEbit);//(Math.round(
                       // dEbit*100.00)/100.00);
  }

  public BigDecimal getcRedit() {

    return cRedit;
    // return cRedit;
  }

  public String getcRedit_s() {

    if (cRedit.equals(new BigDecimal(0)))
      return "";
    else
      return cRedit.toString();
  }

  public String getdEbit_s() {

    if (dEbit.equals(new BigDecimal(0)))
      return "";
    else
      return dEbit.toString();
  }

  public void setcRedit(BigDecimal cRedit) {
    this.cRedit = cRedit;// generer_billetLocal.dEuxcHiffre(cRedit);//generer_billetLocal.dEuxcHiffre(cRedit);//(Math.round(
                         // cRedit*100.00)/100.00);
  }

  public String getcHiffreEnLettre() {
    return cHiffreEnLettre;
  }

  public void setcHiffreEnLettre(String cHiffreEnLettre) {
    this.cHiffreEnLettre = cHiffreEnLettre;
  }

  public String getrEcDep() {
    return rEcDep;
  }

  public void setrEcDep(String rEcDep) {
    this.rEcDep = rEcDep;
  }

  public String getpAy() {
    return pAy;
  }

  public void setpAy(String pAy) {
    this.pAy = pAy;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getDateS() {
    return dateS;
  }

  public void setDateS(String dateS) {
    this.dateS = dateS;
  }

  public String getRp() {
    return rp;
  }

  public void setRp(String rp) {
    this.rp = rp;
  }

  public String getLibelle_1() {
    return libelle_1;
  }

  public void setLibelle_1(String libelle_1) {
    this.libelle_1 = libelle_1;
  }

  public String getLibelle_2() {
    return libelle_2;
  }

  public void setLibelle_2(String libelle_2) {
    this.libelle_2 = libelle_2;
  }

  public String getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(String monnaie) {
    this.monnaie = monnaie;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Sage getSage() {
    return sage;
  }

  public void setSage(Sage sage) {
    this.sage = sage;
  }

  public BigDecimal getDebit_sage() {

    if (cRedit.equals(new BigDecimal(0)))
      return null;
    else
      return cRedit;
    // return dEbit;
  }

  public BigDecimal getCredit_sage() {

    if (dEbit.equals(new BigDecimal(0)))
      return null;
    else
      return dEbit;
    //
    // return cRedit;
  }

  public int compareTo(Object other) {
    long nombre1 = ((Operation) other).getNum_opr();
    long nombre2 = this.getNum_opr();
    if (nombre1 > nombre2)
      return -1;
    else if (nombre1 == nombre2)
      return 0;
    else
      return 1;
  }

  /*
   * public double dEuxcHiffre(double chiffre)
   * 
   * { DecimalFormat df = new DecimalFormat("###,###,###.00"); String str = df.format(chiffre);
   * 
   * System.out.println(str);
   * 
   * return chiffre = Double.parseDouble(str.replace(',', '.')); }
   */

}
