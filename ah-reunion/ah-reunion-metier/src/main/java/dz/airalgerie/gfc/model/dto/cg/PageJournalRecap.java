package dz.airalgerie.gfc.model.dto.cg;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author kehli
 */
@Entity
public class PageJournalRecap implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "NUM_PAGE")
  private String numPage;
  @Column(name = "DEBIT")
  private BigDecimal debit;
  @Column(name = "CREDIT")
  private BigDecimal credit;
  @Column(name = "ECART")
  private BigDecimal ecart;

  public PageJournalRecap() {
  }

  public PageJournalRecap(String numPage, BigDecimal debit, BigDecimal credit, BigDecimal ecart) {
    this.numPage = numPage;
    this.credit = credit;
    this.debit = debit;
    this.ecart = ecart;
  }

  public String getNumPage() {
    return numPage;
  }

  public void setNumPage(String numPage) {
    this.numPage = numPage;
  }

  public BigDecimal getCredit() {
    return credit;
  }

  public void setCredit(BigDecimal credit) {
    this.credit = credit;
  }

  public BigDecimal getDebit() {
    return debit;
  }

  public void setDebit(BigDecimal debit) {
    this.debit = debit;
  }

  public BigDecimal getEcart() {
    return ecart;
  }

  public void setEcart(BigDecimal ecart) {
    this.ecart = ecart;
  }



}
