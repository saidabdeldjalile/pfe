/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import dz.airalgerie.gfc.model.entities.cu.BanqueContrepartie;
import dz.airalgerie.gfc.model.entities.cu.CaisseContrepartie;
import dz.airalgerie.gfc.model.entities.cu.ClientCpta;
import dz.airalgerie.gfc.model.entities.cu.PieceBanqueDetails;
import dz.airalgerie.gfc.model.entities.cu.FournisseurCpta;
import dz.airalgerie.gfc.model.entities.cu.JournalOd;
import dz.airalgerie.gfc.model.entities.cu.PieceCaisseDetails;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kehli
 */
@Entity
@Table(name = "COMPTE_COMPTABLE", schema = "CF")
public class CompteComptable implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Basic(optional = false)
  @NotNull
  @Size(min = 12, max = 12)
  @Column(name = "COMPTE_COMPTABLE")
  private String compteComptable;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "LIBELLE")
  private String libelle;

  @NotNull
  @Column(name = "DATE_OUVERTURE")
  @Temporal(TemporalType.DATE)
  private Date dateOuveture;

  @NotNull
  @Column(name = "DATE_FERMETURE")
  @Temporal(TemporalType.DATE)
  private Date dateFermeture;

  @OneToOne(mappedBy = "compteComptable", fetch = FetchType.LAZY)
  private ClientCpta client;

  @OneToOne(mappedBy = "compteComptable", fetch = FetchType.LAZY)
  private FournisseurCpta fournisseurCpta;

  @OneToOne(mappedBy = "compteComptable", fetch = FetchType.LAZY)
  private BanqueContrepartie banqueContrepartie;

  @OneToOne(mappedBy = "compteComptable", fetch = FetchType.LAZY)
  private CaisseContrepartie caisseContrepartie;

  @OneToMany(mappedBy = "compteComptable", fetch = FetchType.LAZY)
  private List<PieceBanqueDetails> pieceBanqueDetailsList;

  @OneToMany(mappedBy = "compteComptable", fetch = FetchType.LAZY)
  private List<PieceCaisseDetails> pieceCaisseDetailsList;

  @OneToMany(mappedBy = "compteComptable", fetch = FetchType.LAZY)
  private List<JournalOd> journalOdList;

  public CompteComptable() {
    this.id = 0;
  }

  public CompteComptable(Integer id, String compteComptable, String libelle, Date dateOuveture,
      Date dateFermeture) {
    this.id = id;
    this.compteComptable = compteComptable;
    this.libelle = libelle;
    this.dateOuveture = dateOuveture;
    this.dateFermeture = dateFermeture;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCompteComptable() {
    return compteComptable;
  }

  public void setCompteComptable(String compteComptable) {
    this.compteComptable = compteComptable;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Date getDateOuveture() {
    return dateOuveture;
  }

  public void setDateOuveture(Date dateOuveture) {
    this.dateOuveture = dateOuveture;
  }

  public Date getDateFermeture() {
    return dateFermeture;
  }

  public void setDateFermeture(Date dateFermeture) {
    this.dateFermeture = dateFermeture;
  }

  public ClientCpta getClient() {
    return client;
  }

  public void setClient(ClientCpta client) {
    this.client = client;
  }

  public FournisseurCpta getFournisseurCpta() {
    return fournisseurCpta;
  }

  public void setFournisseurCpta(FournisseurCpta fournisseurCpta) {
    this.fournisseurCpta = fournisseurCpta;
  }

  public BanqueContrepartie getBanqueContrepartie() {
    return banqueContrepartie;
  }

  public void setBanqueContrepartie(BanqueContrepartie banqueContrepartie) {
    this.banqueContrepartie = banqueContrepartie;
  }

  public CaisseContrepartie getCaisseContrepartie() {
    return caisseContrepartie;
  }

  public void setCaisseContrepartie(CaisseContrepartie caisseContrepartie) {
    this.caisseContrepartie = caisseContrepartie;
  }

  public List<PieceBanqueDetails> getPieceBanqueDetailsList() {
    return pieceBanqueDetailsList;
  }

  public void setPieceBanqueDetailsList(List<PieceBanqueDetails> pieceBanqueDetailsList) {
    this.pieceBanqueDetailsList = pieceBanqueDetailsList;
  }

  public List<PieceCaisseDetails> getPieceCaisseDetailsList() {
    return pieceCaisseDetailsList;
  }

  public void setPieceCaisseDetailsList(List<PieceCaisseDetails> pieceCaisseDetailsList) {
    this.pieceCaisseDetailsList = pieceCaisseDetailsList;
  }

  public List<JournalOd> getJournalOdList() {
    return journalOdList;
  }

  public void setJournalOdList(List<JournalOd> journalOdList) {
    this.journalOdList = journalOdList;
  }

  @Override
  public String toString() {
    return "ID:" + this.getId() + " - NUMERO COMPTE:" + this.getCompteComptable();
  }
  
  public String autoCompleteLibelle() {
    return compteComptable + " - " + libelle;
  }
}
