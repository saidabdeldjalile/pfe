
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the operation_div database table.
 * 
 */
@Entity
@Table(name = "operation_div")
public class OperationDiv implements Serializable {
  private static final long serialVersionUID = 1L;

  @Transient
  Format format = new SimpleDateFormat("dd/MM/yyyy");

  @Id
  @Column(name = "Ref")
  private long ref;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date")
  private Date date;

  @Column(name = "Lib_ope")
  private String lib_ope;

  @Column(name = "Libelle_1")
  private String libelle_1;

  @Column(name = "Libelle_2")
  private String libelle_2;

  @Column(name = "Monatnt")
  private BigDecimal monatnt;

  @Column(name = "Type")
  private String type;

  @Transient

  private BigDecimal Rec;

  @Transient

  private BigDecimal Dep;

  @Column(name = "Hadj")
  private short hadj;

  @Transient

  private boolean hadj_b;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  public OperationDiv() {

    monatnt = new BigDecimal(0);
    Rec = new BigDecimal(0);
    Dep = new BigDecimal(0);
  }

  public long getRef() {
    return this.ref;
  }

  public void setRef(long ref) {
    this.ref = ref;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getLib_ope() {
    return this.lib_ope;
  }

  public void setLib_ope(String lib_ope) {
    this.lib_ope = lib_ope;
  }

  public BigDecimal getMonatnt() {
    return this.monatnt;
  }

  public void setMonatnt(BigDecimal monatnt) {
    this.monatnt = monatnt;
  }

  public String getType() {

    if (this.type == null)
      return "";
    else
      return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Agence getAgence() {
    return this.agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }

  public BigDecimal getRec() {
    return Rec;
  }

  public void setRec(BigDecimal rec) {
    Rec = rec;
  }

  public BigDecimal getDep() {
    return Dep;
  }

  public void setDep(BigDecimal dep) {
    Dep = dep;
  }

  public String getDateS() {
    return format.format(this.date);
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

  public short getHadj() {
    return hadj;
  }

  public void setHadj(short hadj) {
    this.hadj = hadj;
  }

  public boolean isHadj_b() {
    return hadj_b;
  }

  public void setHadj_b(boolean hadj_b) {
    this.hadj_b = hadj_b;
  }

}
