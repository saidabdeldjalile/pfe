
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the atb database table.
 * 
 */
@Entity
@Table(name = "atb")
public class Atb implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  // @Column(name="Billet_Num_billet")
  private long billet_Num_billet;

  @Column(name = "code_agent")
  private String codeAgent;

  // bi-directional one-to-one association to Billet
  @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
  @JoinColumn(name = "Billet_Num_billet")
  @MapsId
  private Billet billet;

  // bi-directional many-to-one association to Eticket
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "E_TICKET_Billet_Num_billet")
  private Eticket eticket;

  public Atb() {}

  public long getBillet_Num_billet() {
    return this.billet_Num_billet;
  }

  public void setBillet_Num_billet(long billet_Num_billet) {
    this.billet_Num_billet = billet_Num_billet;
  }

  public Billet getBillet() {
    return this.billet;
  }

  public void setBillet(Billet billet) {
    this.billet = billet;
  }

  public Eticket getEticket() {
    return this.eticket;
  }

  public void setEticket(Eticket eticket) {
    this.eticket = eticket;
  }

  public String getCodeAgent() {
    return codeAgent;
  }

  public void setCodeAgent(String codeAgent) {
    this.codeAgent = codeAgent;
  }

  public String getDate() {
    return this.eticket.getDate();
  }

  public String getReseau() {
    return this.eticket.getReseau();
  }

  public long getNum() {
    return this.eticket.getBillet().getNumBillet();
  }

  public long getNumA() {
    return this.billet.getNumBillet();
  }

  public String getAgent() {
    return this.eticket.getCodeAgent();
  }

  public String getObs() {
    return this.eticket.getRemar();
  }
}
