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
@Table(name = "STK.TOTAL_ACHAT_ALGERIE_CLASSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TotalAchatAlgerieClasse.findAll",
        query = "SELECT t FROM VueTotalAchatAlgerieClasse t"),
    @NamedQuery(name = "TotalAchatAlgerieClasse.findByClasse",
        query = "SELECT t FROM VueTotalAchatAlgerieClasse t WHERE t.classe = :classe"),
    @NamedQuery(name = "TotalAchatAlgerieClasse.findByDateTraitAchat",
        query = "SELECT t FROM VueTotalAchatAlgerieClasse t WHERE t.dateTraitAchat = :dateTraitAchat"),
    @NamedQuery(name = "TotalAchatAlgerieClasse.findByTtAlg",
        query = "SELECT t FROM VueTotalAchatAlgerieClasse t WHERE t.ttAlg = :ttAlg")})
public class VueTotalAchatAlgerieClasse implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(max = 1)
  @Column(name = "classe")
  private String classe;
  @Column(name = "dateTraitAchat")
  private Integer dateTraitAchat;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "TT_ALG")
  private BigDecimal ttAlg;

  public VueTotalAchatAlgerieClasse() {}

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
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

}