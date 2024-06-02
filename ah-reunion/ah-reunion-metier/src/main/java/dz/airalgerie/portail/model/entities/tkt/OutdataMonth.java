/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.tkt;

import java.io.Serializable;
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
 * @author hp
 */
@Entity
@Table(schema = "PRG", name = "OUTDATA_MONTH")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "OutdataMonth.findAll", query = "SELECT o FROM OutdataMonth o"),
    @NamedQuery(name = "OutdataMonth.findByMonthIssue",
        query = "SELECT o FROM OutdataMonth o WHERE o.monthIssue = :monthIssue")})
public class OutdataMonth implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 7)
  @Column(name = "MONTH_ISSUE")
  private String monthIssue;

  public OutdataMonth() {
  }

  public OutdataMonth(String monthIssue) {
    this.monthIssue = monthIssue;
  }

  public String getMonthIssue() {
    return monthIssue;
  }

  public void setMonthIssue(String monthIssue) {
    this.monthIssue = monthIssue;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (monthIssue != null ? monthIssue.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof OutdataMonth)) {
      return false;
    }
    OutdataMonth other = (OutdataMonth) object;
    if ((this.monthIssue == null && other.monthIssue != null)
        || (this.monthIssue != null && !this.monthIssue.equals(other.monthIssue))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.tkt.OutdataMonth[ monthIssue=" + monthIssue + " ]";
  }

}
