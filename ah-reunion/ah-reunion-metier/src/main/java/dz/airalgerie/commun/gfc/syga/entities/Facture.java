
package dz.airalgerie.commun.gfc.syga.entities;

import com.ibm.icu.text.RuleBasedNumberFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.*;

/**
 * The persistent class for the facture database table.
 * 
 */
@Entity
@Table(name = "facture")
public class Facture implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "No_Facture")
  private long no_Facture;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_debut")
  private Date date_debut;

  @Temporal(TemporalType.DATE)
  @Column(name = "Date_fin")
  private Date date_fin;

  @Column(name = "Type")
  private String type;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "facture", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  private List<Billet> billets;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "factureAvoir", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  private List<Billet> billets_avoir;

  @Transient
  private BigDecimal total;

  @Transient
  private BigDecimal total_s;

  @Transient
  private BigDecimal total_n_s;

  @Transient
  private BigDecimal total_tva;

  @Transient
  private BigDecimal total_page;

  @Transient
  private BigDecimal total_s_page;

  @Transient
  private BigDecimal total_n_s_page;

  @Transient
  private BigDecimal total_tva_page;

  @Transient
  private List<Eticket> eTikts = new ArrayList<Eticket>();

  @Transient
  private List<Facture> factures = new ArrayList<Facture>();

  @Transient
  private BigDecimal total_cumul;

  @Transient
  private BigDecimal total_s_cumul;

  @Transient
  private BigDecimal total_n_s_cumul;

  @Transient
  private BigDecimal total_tva_cumul;

  @Transient
  private String sens_impression;

  public Facture() {

    total = new BigDecimal(0);
  }

  public List<Eticket> geteTikts() {
    return eTikts;
  }

  public void seteTikts(List<Eticket> eTikts) {
    this.eTikts = eTikts;
  }

  public long getNo_Facture() {
    return this.no_Facture;
  }

  public void setNo_Facture(long no_Facture) {
    this.no_Facture = no_Facture;
  }

  public Date getDate_debut() {
    return date_debut;
  }

  public void setDate_debut(Date date_debut) {
    this.date_debut = date_debut;
  }

  public Date getDate_fin() {
    return date_fin;
  }

  public void setDate_fin(Date date_fin) {
    this.date_fin = date_fin;
  }

  public String getType() {
    return type;
  }

  public String getTyped() {
    if (type.equals("F"))
      return "FACTURE";
    else
      return "AVOIR";
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<Billet> getBillets() {
    return billets;
  }

  public void setBillets(List<Billet> billets) {
    this.billets = billets;
  }

  public List<Billet> getBillets_avoir() {
    return billets_avoir;
  }

  public void setBillets_avoir(List<Billet> billets_avoir) {
    this.billets_avoir = billets_avoir;
  }

  public int getClient() {
    if (type.compareTo("F") == 0)

      return this.billets.get(0).getBonCommande().getClientEnCompte().getNumClient();/// 100;
    else
      return this.billets_avoir.get(0).getBonCommande().getClientEnCompte().getNumClient();/// 100;
  }

  public String getRs() {

    String chap;
    if (type.compareTo("F") == 0)

      chap = this.billets.get(0).getBonCommande().getClientEnCompte().getRaisonSocial();
    else
      chap = this.billets_avoir.get(0).getBonCommande().getClientEnCompte().getRaisonSocial();

    if (chap == null)
      chap = "";
    return chap;

  }

  public String getChap() {
    String chap;

    if (type.compareTo("F") == 0)

      chap = this.billets.get(0).getBonCommande().getNumChapBu();
    else
      chap = this.billets_avoir.get(0).getBonCommande().getNumChapBu();

    if (chap == null)
      chap = "";

    return chap;

  }

  public String getRc() {

    String chap;

    if (type.compareTo("F") == 0)

      chap = this.billets.get(0).getBonCommande().getClientEnCompte().getRc();
    else
      chap = this.billets_avoir.get(0).getBonCommande().getClientEnCompte().getRc();

    if (chap == null)
      chap = "";

    return chap;

  }

  public String getAdresse() {
    String chap;

    if (type.compareTo("F") == 0)

      chap = this.billets.get(0).getBonCommande().getClientEnCompte().getAdresseClient();
    else
      chap = this.billets_avoir.get(0).getBonCommande().getClientEnCompte().getAdresseClient();

    if (chap == null)
      chap = "";

    return chap;

  }

  public String getTel() {

    String chap;

    if (type.compareTo("F") == 0)

      chap = this.billets.get(0).getBonCommande().getClientEnCompte().getTel();
    else
      chap = this.billets_avoir.get(0).getBonCommande().getClientEnCompte().getTel();

    if (chap == null)
      chap = "";
    else
      chap = "0" + chap;

    return chap;

  }

  public String getFax() {
    String chap;

    if (type.compareTo("F") == 0)

      chap = this.billets.get(0).getBonCommande().getClientEnCompte().getFax();
    else
      chap = this.billets_avoir.get(0).getBonCommande().getClientEnCompte().getFax();

    if (chap == null)
      chap = "";
    else
      chap = "0" + chap;
    return chap;

  }

  public String getNis() {
    String chap;

    if (type.compareTo("F") == 0)

      chap = this.billets.get(0).getBonCommande().getClientEnCompte().getNis();
    else
      chap = this.billets_avoir.get(0).getBonCommande().getClientEnCompte().getNis();

    if (chap == null)
      chap = "";

    return chap;

  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public BigDecimal getTotal_s() {
    return total_s;
  }

  public void setTotal_s(BigDecimal total_s) {
    this.total_s = total_s;
  }

  public BigDecimal getTotal_n_s() {
    return total_n_s;
  }

  public void setTotal_n_s(BigDecimal total_n_s) {
    this.total_n_s = total_n_s;
  }

  public BigDecimal getTotal_tva() {
    return total_tva;
  }

  public void setTotal_tva(BigDecimal total_tva) {
    this.total_tva = total_tva;
  }

  public List<Facture> getFactures() {
    return factures;
  }

  public void setFactures(List<Facture> factures) {
    this.factures = factures;
  }

  public BigDecimal getTotal_page() {
    return total_page;
  }

  public void setTotal_page(BigDecimal total_page) {
    this.total_page = total_page;
  }

  public BigDecimal getTotal_s_page() {
    return total_s_page;
  }

  public void setTotal_s_page(BigDecimal total_s_page) {
    this.total_s_page = total_s_page;
  }

  public BigDecimal getTotal_n_s_page() {
    return total_n_s_page;
  }

  public void setTotal_n_s_page(BigDecimal total_n_s_page) {
    this.total_n_s_page = total_n_s_page;
  }

  public BigDecimal getTotal_tva_page() {
    return total_tva_page;
  }

  public void setTotal_tva_page(BigDecimal total_tva_page) {
    this.total_tva_page = total_tva_page;
  }

  public BigDecimal getTotal_cumul() {
    return total_cumul;
  }

  public void setTotal_cumul(BigDecimal total_cumul) {
    this.total_cumul = total_cumul;
  }

  public BigDecimal getTotal_s_cumul() {
    return total_s_cumul;
  }

  public void setTotal_s_cumul(BigDecimal total_s_cumul) {
    this.total_s_cumul = total_s_cumul;
  }

  public BigDecimal getTotal_n_s_cumul() {
    return total_n_s_cumul;
  }

  public void setTotal_n_s_cumul(BigDecimal total_n_s_cumul) {
    this.total_n_s_cumul = total_n_s_cumul;
  }

  public BigDecimal getTotal_tva_cumul() {
    return total_tva_cumul;
  }

  public void setTotal_tva_cumul(BigDecimal total_tva_cumul) {
    this.total_tva_cumul = total_tva_cumul;
  }

  public String getMoisfacture() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    return formatter.format(date_debut).substring(3);

  }

  public String getDatefacture() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    return formatter.format(date_debut);

  }

  public String getChienltr() {
    int entier = total.intValue();
    RuleBasedNumberFormat rnbf =
        new RuleBasedNumberFormat(Locale.FRANCE, RuleBasedNumberFormat.SPELLOUT);
    String ch = rnbf.format(entier) + " Dinars et ";
    BigDecimal decimale = total.remainder(BigDecimal.ONE);
    ch = ch + rnbf.format(decimale.multiply(new BigDecimal(100))) + " Centimes ";

    return ch;

  }

  public String getSens_impression() {
    return sens_impression;
  }

  public void setSens_impression(String sens_impression) {
    this.sens_impression = sens_impression;
  }

}
