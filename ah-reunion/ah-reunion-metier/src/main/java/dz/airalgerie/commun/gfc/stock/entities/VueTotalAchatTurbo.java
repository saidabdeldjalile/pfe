/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.TOTAL_ACHAT_TURBO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TotalAchatTurbo.findAll", query = "SELECT t FROM VueTotalAchatTurbo t"),
    @NamedQuery(name = "TotalAchatTurbo.findByCodeAppareil",
        query = "SELECT t FROM VueTotalAchatTurbo t WHERE t.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "TotalAchatTurbo.findByDateTraitAchat",
        query = "SELECT t FROM VueTotalAchatTurbo t WHERE t.dateTraitAchat = :dateTraitAchat"),
    @NamedQuery(name = "TotalAchatTurbo.findByTtAlg",
        query = "SELECT t FROM VueTotalAchatTurbo t WHERE t.ttAlg = :ttAlg"),
    @NamedQuery(name = "TotalAchatTurbo.findByTtEtrang",
        query = "SELECT t FROM VueTotalAchatTurbo t WHERE t.ttEtrang = :ttEtrang"),
    @NamedQuery(name = "TotalAchatTurbo.findByTotal",
        query = "SELECT t FROM VueTotalAchatTurbo t WHERE t.total = :total"),
    @NamedQuery(name = "TotalAchatSdrm.findByApp",
        query = "SELECT t FROM VueTotalAchatSdrm t WHERE t.app = :app")})
public class VueTotalAchatTurbo implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "codeAppareil")
  private String codeAppareil;
  @Column(name = "dateTraitAchat")
  private Integer dateTraitAchat;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TT_ALG")
  private BigDecimal ttAlg;
  @Column(name = "TT_ETRANG")
  private BigDecimal ttEtrang;
  @Column(name = "TOTAL")
  private BigDecimal total;
  @Column(name = "app")
  private String app;

  public VueTotalAchatTurbo() {}

  public String getCodeAppareil() {
    return codeAppareil;
  }

  public void setCodeAppareil(String codeAppareil) {
    this.codeAppareil = codeAppareil;
  }

  public Integer getDateTraitAchat() {
    return dateTraitAchat;
  }

  public void setDateTraitAchat(Integer dateTraitAchat) {
    this.dateTraitAchat = dateTraitAchat;
  }

  public BigDecimal getTtAlg() {
    return ttAlg;
  }

  public void setTtAlg(BigDecimal ttAlg) {
    this.ttAlg = ttAlg;
  }

  public BigDecimal getTtEtrang() {
    return ttEtrang;
  }

  public void setTtEtrang(BigDecimal ttEtrang) {
    this.ttEtrang = ttEtrang;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public String getApp() {
    return app;
  }

  public void setApp(String app) {
    this.app = app;
  }

}
