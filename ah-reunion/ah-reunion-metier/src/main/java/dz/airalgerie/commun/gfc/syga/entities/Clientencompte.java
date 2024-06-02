
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the client_en_compte database table.
 * 
 */
@SuppressWarnings("rawtypes")
@Entity
@Table(name = "client_en_compte")
public class Clientencompte implements Serializable, java.lang.Comparable {
  private static final long serialVersionUID = 1L;

  /*
   * @Transient
   * 
   * @EJB private eJbDAOLocal eJbDAOLocal;
   */
  @Id
  @Column(name = "Num_client")
  private int numClient;

  @Column(name = "adresse_client")
  private String adresseClient;

  @Column(name = "Fax_c")
  private String fax;

  @Column(name = "Obser")
  private String obser;

  @Column(name = "Raison_social")
  private String raisonSocial;

  @Column(name = "Tel_c")
  private String tel;

  // bi-directional many-to-one association to BonCommande
  @OneToMany(mappedBy = "clientEnCompte", fetch = FetchType.LAZY)
  private Set<BonCommande> bonCommandes;

  // bi-directional many-to-many association to Unite
  @ManyToMany(mappedBy = "clientEnComptes", fetch = FetchType.LAZY)
  private Set<Unite> unites;

  @Transient
  private int nbDocV;

  @Transient
  private double mtDocV;

  @Transient
  private int nbDocR;

  @Transient
  private double mtDocR;

  @Column(name = "RC")
  private String rc;

  @Column(name = "NIS")
  private String nis;

  @Column(name = "CLICAT")
  private String cliCat;

  @Column(name = "CLIORG")
  private String cliOrg;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Compte_C")
  private Compte compte;

  @Transient
  private List<Facture> factures = new ArrayList<Facture>();

  public Clientencompte() {}

  public int getNumClient() {

    if (this.numClient > 9999)
      return 0;
    else
      return this.numClient;
  }

  public void setNumClient(int numClient) {
    this.numClient = numClient;
  }

  public String getAdresseClient() {

    if (this.adresseClient == null)
      this.adresseClient = "";

    return this.adresseClient;
  }

  public void setAdresseClient(String adresseClient) {
    this.adresseClient = adresseClient;
  }

  public String getFax() {
    return this.fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getObser() {

    if (this.obser == null)
      this.obser = "";
    return this.obser;
  }

  public void setObser(String obser) {
    this.obser = obser;
  }

  public String getRaisonSocial() {

    if (this.raisonSocial == null)
      this.raisonSocial = "";
    return this.raisonSocial;
  }

  public void setRaisonSocial(String raisonSocial) {
    this.raisonSocial = raisonSocial;
  }

  public String getTel() {

    return this.tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Set<BonCommande> getBonCommandes() {
    return this.bonCommandes;
  }

  public void setBonCommandes(Set<BonCommande> bonCommandes) {
    this.bonCommandes = bonCommandes;
  }

  public Set<Unite> getUnites() {
    return this.unites;
  }

  public void setUnites(Set<Unite> unites) {
    this.unites = unites;
  }

  public int getNbDocV() {
    return nbDocV;
  }

  public void setNbDocV(int nbDocV) {
    this.nbDocV = nbDocV;
  }

  public double getMtDocV() {
    return mtDocV;
  }

  public void setMtDocV(double mtDocV) {
    this.mtDocV = mtDocV;
  }

  public int getNbDocR() {
    return nbDocR;
  }

  public void setNbDocR(int nbDocR) {
    this.nbDocR = nbDocR;
  }

  public double getMtDocR() {
    return mtDocR;
  }

  public void setMtDocR(double mtDocR) {
    this.mtDocR = mtDocR;
  }

  public String getRc() {

    return rc;
  }

  public void setRc(String rc) {
    this.rc = rc;
  }

  public String getNis() {

    return nis;
  }

  public void setNis(String nis) {
    this.nis = nis;
  }

  public String getCliCat() {
    return cliCat;
  }

  public void setCliCat(String cliCat) {
    this.cliCat = cliCat;
  }

  public String getCliOrg() {
    return cliOrg;
  }

  public void setCliOrg(String cliOrg) {
    this.cliOrg = cliOrg;
  }

  public Compte getCompte() {
    return compte;
  }

  public void setCompte(Compte compte) {
    this.compte = compte;
  }

  public List<Facture> getFactures() {
    return factures;
  }

  public void setFactures(List<Facture> factures) {
    this.factures = factures;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + numClient;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Clientencompte other = (Clientencompte) obj;
    if (numClient != other.numClient)
      return false;
    return true;
  }

  public int compareTo(Object other) {
    long nombre1 = ((Clientencompte) other).getNumClient();
    long nombre2 = this.getNumClient();
    if (nombre1 > nombre2)
      return -1;
    else if (nombre1 == nombre2)
      return 0;
    else
      return 1;
  }

}
