
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the agence database table.
 * 
 */
@Entity
@Table(name = "agence")
public class Agence implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "code_iata")
  private int codeIata;

  @Column(name = "Adresse")
  private String adresse;

  @Column(name = "code_caisse")
  private int codeCaisse;

  @Column(name = "Nom_agence")
  private String nomAgence;

  @Column(name = "Frais_R_RIA")
  private float fraisRemRia;

  @Column(name = "Frais_R_INT")
  private float fraisRemInt;

  @Column(name = "Tel")
  private String tel;

  @Column(name = "E_MAIL")
  private String email;

  @Column(name = "R_COM")
  private String rcom;

  @Column(name = "N_ART")
  private String nart;

  @Column(name = "ID_FISC")
  private String fisc;

  @Column(name = "RIB")
  private String rib;

  // bi-directional many-to-one association to Unite
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Unite_Num_uni")
  private Unite unite;

  // bi-directional many-to-one association to Badc
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<Badc> badcs;

  // bi-directional many-to-one association to Billet
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<Billet> billets;

  // bi-directional many-to-one association to Cheque
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<Cheque> cheques;

  // bi-directional many-to-one association to DemandeDadc
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<DemandeDadc> demandeDadcs;

  // bi-directional many-to-one association to OperationDiv
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<OperationDiv> operationDivs;

  // bi-directional many-to-one association to User
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<User> users;

  // bi-directional many-to-one association to Versement
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<Versement> versements;

  // bi-directional many-to-one association to JournalCaisse
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<JournalCaisse> journalCaisses;

  // bi-directional many-to-one association to Bodoan
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<Bodoan> bodoans;

  // bi-directional many-to-one association to BordereauEnvoi
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<BordereauEnvoi> bordereauenvois;

  // bi-directional many-to-one association to BorAvoir
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<BorAvoir> boravoirs;

  // bi-directional many-to-many association to Monnaie
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "monnaie_has_agence", joinColumns = {@JoinColumn(name = "agence_code_iata")},
      inverseJoinColumns = {@JoinColumn(name = "monnaie_Code_monnaie")})

  private List<Monnaie> monnaies;

  // bi-directional many-to-one association to BilletRemb
  @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
  private Set<BilletRemb> billetRembs;

  @Transient
  private Monnaie monnaie;

  public Agence() {}

  public int getCodeIata() {
    return this.codeIata;
  }

  public void setCodeIata(int codeIata) {
    this.codeIata = codeIata;
  }

  public String getAdresse() {
    return this.adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public int getCodeCaisse() {
    return this.codeCaisse;
  }

  public void setCodeCaisse(int codeCaisse) {
    this.codeCaisse = codeCaisse;
  }

  public String getNomAgence() {
    return this.nomAgence;
  }

  public void setNomAgence(String nomAgence) {
    this.nomAgence = nomAgence;
  }

  public Unite getUnite() {
    return this.unite;
  }

  public void setUnite(Unite unite) {
    this.unite = unite;
  }

  public Set<Badc> getBadcs() {
    return this.badcs;
  }

  public void setBadcs(Set<Badc> badcs) {
    this.badcs = badcs;
  }

  public Set<Billet> getBillets() {
    return this.billets;
  }

  public void setBillets(Set<Billet> billets) {
    this.billets = billets;
  }

  public Set<Cheque> getCheques() {
    return this.cheques;
  }

  public void setCheques(Set<Cheque> cheques) {
    this.cheques = cheques;
  }

  public Set<DemandeDadc> getDemandeDadcs() {
    return this.demandeDadcs;
  }

  public void setDemandeDadcs(Set<DemandeDadc> demandeDadcs) {
    this.demandeDadcs = demandeDadcs;
  }

  public Set<OperationDiv> getOperationDivs() {
    return this.operationDivs;
  }

  public void setOperationDivs(Set<OperationDiv> operationDivs) {
    this.operationDivs = operationDivs;
  }

  public Set<User> getUsers() {
    return this.users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  public Set<Versement> getVersements() {
    return this.versements;
  }

  public void setVersements(Set<Versement> versements) {
    this.versements = versements;
  }

  public Set<JournalCaisse> getJournalCaisses() {
    return journalCaisses;
  }

  public void setJournalCaisses(Set<JournalCaisse> journalCaisses) {
    this.journalCaisses = journalCaisses;
  }

  public Set<Bodoan> getBodoans() {
    return bodoans;
  }

  public void setBodoans(Set<Bodoan> bodoans) {
    this.bodoans = bodoans;
  }

  public Set<BordereauEnvoi> getBordereauenvois() {
    return bordereauenvois;
  }

  public void setBordereauenvois(Set<BordereauEnvoi> bordereauenvois) {
    this.bordereauenvois = bordereauenvois;
  }

  public Set<BorAvoir> getBoravoirs() {
    return boravoirs;
  }

  public void setBoravoirs(Set<BorAvoir> boravoirs) {
    this.boravoirs = boravoirs;
  }

  public List<Monnaie> getMonnaies() {
    return this.monnaies;
  }

  public void setMonnaies(List<Monnaie> monnaies) {
    this.monnaies = monnaies;
  }

  public Set<BilletRemb> getBilletRembs() {
    return billetRembs;
  }

  public void setBilletRembs(Set<BilletRemb> billetRembs) {
    this.billetRembs = billetRembs;
  }

  public float getFraisRemRia() {
    return fraisRemRia;
  }

  public void setFraisRemRia(float fraisRemRia) {
    this.fraisRemRia = fraisRemRia;
  }

  public float getFraisRemInt() {
    return fraisRemInt;
  }

  public void setFraisRemInt(float fraisRemInt) {
    this.fraisRemInt = fraisRemInt;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRcom() {
    return rcom;
  }

  public void setRcom(String rcom) {
    this.rcom = rcom;
  }

  public String getNart() {
    return nart;
  }

  public void setNart(String nart) {
    this.nart = nart;
  }

  public String getFisc() {
    return fisc;
  }

  public void setFisc(String fisc) {
    this.fisc = fisc;
  }

  public String getRib() {
    return rib;
  }

  public void setRib(String rib) {
    this.rib = rib;
  }

  public Monnaie getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(Monnaie monnaie) {
    this.monnaie = monnaie;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codeIata;
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
    Agence other = (Agence) obj;
    if (codeIata != other.codeIata)
      return false;
    return true;
  }

}
