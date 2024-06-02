
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the journal_caisse database table.
 * 
 */
@Entity
@Table(name = "journal_caisse")
public class JournalCaisse implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Num_journal")
  private long num_journal;

  @Column(name = "Brut_Avr")
  private double _Brut_Avr_;

  @Column(name = "Brut_E_C")
  private double _Brut_E_C_;

  @Temporal(TemporalType.DATE)
  @Column(name = "Debut")
  private Date debut;

  @Temporal(TemporalType.DATE)
  @Column(name = "Fin")
  private Date fin;

  @Transient
  private String date;

  @Transient
  private String sommeDebit;

  @Column(name = "Verouiller")
  private int verouiller;

  // bi-directional many-to-one association to Agence
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Agence_code_iata")
  private Agence agence;

  // bi-directional many-to-one association to Operation
  @OneToMany(mappedBy = "journalCaisse", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
  private Set<Operation> operations;

  public JournalCaisse() {}

  public long getNum_journal() {
    return this.num_journal;
  }

  public void setNum_journal(long num_journal) {
    this.num_journal = num_journal;
  }

  public double get_Brut_Avr_() {
    return this._Brut_Avr_;
  }

  public void set_Brut_Avr_(double _Brut_Avr_) {
    this._Brut_Avr_ = _Brut_Avr_;
  }

  public double get_Brut_E_C_() {
    return this._Brut_E_C_;
  }

  public void set_Brut_E_C_(double _Brut_E_C_) {
    this._Brut_E_C_ = _Brut_E_C_;
  }

  public Date getDebut() {
    return this.debut;
  }

  public void setDebut(Date debut) {
    this.debut = debut;
  }

  public Date getFin() {
    return this.fin;
  }

  public void setFin(Date fin) {
    this.fin = fin;
  }

  public Agence getAgence() {
    return this.agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }

  public Set<Operation> getOperations() {
    return this.operations;
  }

  public void setOperations(Set<Operation> operations) {
    this.operations = operations;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getSommeDebit() {
    return sommeDebit;
  }

  public void setSommeDebit(String sommeDebit) {
    this.sommeDebit = sommeDebit;
  }

  public double getBrut_Avr() {
    return this._Brut_Avr_;
  }

  public double getBrut_E_C() {
    return this._Brut_E_C_;
  }

  public int getVerouiller() {
    return verouiller;
  }

  public void setVerouiller(int verouiller) {
    this.verouiller = verouiller;
  }

}
