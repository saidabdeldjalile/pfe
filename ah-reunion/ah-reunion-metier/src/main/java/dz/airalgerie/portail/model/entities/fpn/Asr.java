/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.fpn;

import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.portail.model.dto.safety.AsrNotifsDto;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = ErpConstante.DbSchemaName.AGS_FPN, name = "ASR")
@NamedQueries({@NamedQuery(name = "Asr.findAll", query = "SELECT a FROM Asr a")})
@NamedNativeQueries({@NamedNativeQuery(name = "Asr.findPaginatedView",
    query = "DECLARE @MATRICULE INT = ?1;\n" + "\n"
        + "SELECT A.ID, A.MATRICULE, P.NOM, A.FONCTION, A.DATE_EVENT EVENT_DATE, A.AIRCRAFT, A.FLT, A.DEP, A.ARR, C.NB_COMMENTS, A.SECOND_PILOTE SECOND_PILOTE_MATRICULE, PM.NOM SECOND_PILOTE_NOM, ISNULL(N.IS_READ, 1) IS_READ, A.CREATED_AT ASR_CREATED, NC.NB_NEW_COMMENTS, NULL PRIORITE, NULL STATUT, NULL TRAITE_PAR_MATRICULE, NULL TRAITE_PAR_NOM\n"
        + "FROM " + ErpConstante.DbSchemaName.AGS_FPN + ".ASR A\n"
        + "OUTER APPLY (SELECT ISNULL(COUNT(*), 0) NB_COMMENTS FROM "
        + ErpConstante.DbSchemaName.AGS_FPN + ".ASR_COMMENTS C WHERE C.ASR_ID = A.ID) C\n"
        + "OUTER APPLY (SELECT TOP 1 IS_READ FROM " + ErpConstante.DbSchemaName.AGS_AUTH
        + ".V_NOTIFICATIONS N WHERE N.NOTIFIABLE_TYPE = 'ASR' AND N.NOTIFIABLE_ID = A.ID AND N.MATRICULE = @MATRICULE ORDER BY N.CREATED_AT DESC) N\n"
        + "OUTER APPLY (SELECT ISNULL(COUNT(*), 0) NB_NEW_COMMENTS\n" + "	FROM "
        + ErpConstante.DbSchemaName.AGS_AUTH + ".V_NOTIFICATIONS N \n" + "	INNER JOIN "
        + ErpConstante.DbSchemaName.AGS_FPN
        + ".ASR_COMMENTS AC ON N.NOTIFIABLE_TYPE = 'ASR_COMMENT' AND N.NOTIFIABLE_ID = AC.ID\n"
        + "	WHERE AC.ASR_ID = A.ID AND N.MATRICULE = @MATRICULE AND N.IS_READ = 0\n" + ") NC\n"
        + "LEFT JOIN " + ErpConstante.DbSchemaName.AGS_CAR
        + ".V_PERSONNEL P ON P.MATRICULE = A.MATRICULE\n" + "LEFT JOIN "
        + ErpConstante.DbSchemaName.AGS_CAR + ".V_PERSONNEL PM ON PM.MATRICULE = A.SECOND_PILOTE\n"
        + "WHERE A.MATRICULE = @MATRICULE OR (A.IS_ANNONYME = 0 AND A.SECOND_PILOTE = @MATRICULE)\n"
        + "ORDER BY a.CREATED_AT DESC",
    resultSetMapping = "Asr.findRecapView"),
    @NamedNativeQuery(name = "Asr.findPaginatedAdminView", query = "DECLARE @MATRICULE INT = ?1;\n"
        + "\n"
        + "SELECT A.ID, A.MATRICULE, P.NOM, A.FONCTION, A.DATE_EVENT EVENT_DATE, A.AIRCRAFT, A.FLT, A.DEP, A.ARR, C.NB_COMMENTS, A.SECOND_PILOTE SECOND_PILOTE_MATRICULE, PM.NOM SECOND_PILOTE_NOM, ISNULL(N.IS_READ, 1) IS_READ, A.CREATED_AT ASR_CREATED, NC.NB_NEW_COMMENTS, A.PRIORITE, A.STATUT, PT.MATRICULE TRAITE_PAR_MATRICULE, PT.NOM TRAITE_PAR_NOM\n"
        + "FROM " + ErpConstante.DbSchemaName.AGS_FPN + ".ASR A\n"
        + "OUTER APPLY (SELECT ISNULL(COUNT(*), 0) NB_COMMENTS FROM "
        + ErpConstante.DbSchemaName.AGS_FPN + ".ASR_COMMENTS C WHERE C.ASR_ID = A.ID) C\n"
        + "OUTER APPLY (SELECT TOP 1 IS_READ FROM " + ErpConstante.DbSchemaName.AGS_AUTH
        + ".V_NOTIFICATIONS N WHERE N.NOTIFIABLE_TYPE = 'ASR' AND N.NOTIFIABLE_ID = A.ID AND N.MATRICULE = @MATRICULE ORDER BY N.CREATED_AT DESC) N\n"
        + "OUTER APPLY (SELECT ISNULL(COUNT(*), 0) NB_NEW_COMMENTS\n" + "	FROM "
        + ErpConstante.DbSchemaName.AGS_AUTH + ".V_NOTIFICATIONS N \n" + "	INNER JOIN "
        + ErpConstante.DbSchemaName.AGS_FPN
        + ".ASR_COMMENTS AC ON N.NOTIFIABLE_TYPE = 'ASR_COMMENT' AND N.NOTIFIABLE_ID = AC.ID\n"
        + "	WHERE AC.ASR_ID = A.ID AND N.MATRICULE = @MATRICULE AND N.IS_READ = 0\n" + ") NC\n"
        + "LEFT JOIN " + ErpConstante.DbSchemaName.AGS_CAR
        + ".V_PERSONNEL P ON P.MATRICULE = A.MATRICULE\n" + "LEFT JOIN "
        + ErpConstante.DbSchemaName.AGS_CAR + ".V_PERSONNEL PM ON PM.MATRICULE = A.SECOND_PILOTE\n"
        + "LEFT JOIN " + ErpConstante.DbSchemaName.AGS_CAR
        + ".V_PERSONNEL PT ON PT.MATRICULE = A.TRAITE_PAR\n" + "ORDER BY a.CREATED_AT DESC",
        resultSetMapping = "Asr.findRecapView")})

@SqlResultSetMapping(name = "Asr.findRecapView",
    classes = @ConstructorResult(targetClass = AsrNotifsDto.class,
        columns = {@ColumnResult(name = "ID", type = int.class),
            @ColumnResult(name = "MATRICULE", type = int.class),
            @ColumnResult(name = "NOM", type = String.class),
            @ColumnResult(name = "FONCTION", type = String.class),
            @ColumnResult(name = "EVENT_DATE", type = LocalDateTime.class),
            @ColumnResult(name = "AIRCRAFT", type = String.class),
            @ColumnResult(name = "FLT", type = String.class),
            @ColumnResult(name = "DEP", type = String.class),
            @ColumnResult(name = "ARR", type = String.class),
            @ColumnResult(name = "NB_COMMENTS", type = Integer.class),
            @ColumnResult(name = "SECOND_PILOTE_MATRICULE", type = Integer.class),
            @ColumnResult(name = "SECOND_PILOTE_NOM", type = String.class),
            @ColumnResult(name = "IS_READ", type = boolean.class),
            @ColumnResult(name = "ASR_DATE", type = LocalDateTime.class),
            @ColumnResult(name = "NB_NEW_COMMENTS", type = Integer.class),
            @ColumnResult(name = "PRIORITE", type = Integer.class),
            @ColumnResult(name = "STATUT", type = Integer.class),
            @ColumnResult(name = "TRAITE_PAR_MATRICULE", type = Integer.class),
            @ColumnResult(name = "TRAITE_PAR_NOM", type = String.class)}))
public class Asr implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Column(name = "DATE_EVENT")
  private LocalDateTime dateEvent;
  @Size(max = 150)
  @Column(name = "FONCTION")
  private String fonction;
  @Size(max = 10)
  @Column(name = "FLT")
  private String flt;
  @Size(max = 15)
  @Column(name = "AIRCRAFT")
  private String aircraft;
  @Size(max = 5)
  @Column(name = "DEP")
  private String dep;
  @Size(max = 5)
  @Column(name = "ARR")
  private String arr;
  @Lob
  @Size(max = 2147483647)
  @Column(name = "DETAILS")
  private String details;
  @Size(max = 50)
  @Column(name = "LIEU")
  private String lieu;
  @Size(max = 20)
  @Column(name = "ALTITUDE")
  private String altitude;
  @Size(max = 20)
  @Column(name = "VITESSE")
  private String vitesse;
  @Size(max = 20)
  @Column(name = "ATL")
  private String atl;
  @Size(max = 20)
  @Column(name = "PISTE")
  private String piste;
  @Column(name = "ETAT_PISTE")
  private Integer etatPiste;
  @JoinColumn(name = "SECOND_PILOTE", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private PersonnelAgs secondPilote;
  @Column(name = "IS_ANNONYME")
  private boolean isAnnonyme;
  @Size(max = 200)
  @Column(name = "AUTRE_EVENT")
  private String autreEvent;
  @Size(max = 200)
  @Column(name = "AUTRE_CONSEQ")
  private String autreConsequence;
  @Column(name = "STATUT")
  private Integer statut;
  @Column(name = "PRIORITE")
  private Integer priorite;
  @Column(name = "CREATED_AT")
  private LocalDateTime createdAt;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private PersonnelAgs personnelAgs;
  @JoinColumn(name = "TRAITE_PAR", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private PersonnelAgs traitePar;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "asrId", fetch = FetchType.LAZY)
  private List<AsrEvents> asrEventsList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "asr", fetch = FetchType.LAZY)
  @OrderBy(value = "createdAt")
  private List<AsrComments> asrCommentsList;

  public Asr() {
  }

  public Asr(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDateTime getDateEvent() {
    return dateEvent;
  }

  public void setDateEvent(LocalDateTime dateEvent) {
    this.dateEvent = dateEvent;
  }

  public String getFonction() {
    return fonction;
  }

  public void setFonction(String fonction) {
    this.fonction = fonction;
  }

  public String getFlt() {
    return flt;
  }

  public void setFlt(String flt) {
    this.flt = flt;
  }

  public String getAircraft() {
    return aircraft;
  }

  public void setAircraft(String aircraft) {
    this.aircraft = aircraft;
  }

  public String getDep() {
    return dep;
  }

  public void setDep(String dep) {
    this.dep = dep;
  }

  public String getArr() {
    return arr;
  }

  public void setArr(String arr) {
    this.arr = arr;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public String getLieu() {
    return lieu;
  }

  public void setLieu(String lieu) {
    this.lieu = lieu;
  }

  public String getAltitude() {
    return altitude;
  }

  public void setAltitude(String altitude) {
    this.altitude = altitude;
  }

  public String getVitesse() {
    return vitesse;
  }

  public void setVitesse(String vitesse) {
    this.vitesse = vitesse;
  }

  public String getAtl() {
    return atl;
  }

  public void setAtl(String atl) {
    this.atl = atl;
  }

  public String getPiste() {
    return piste;
  }

  public void setPiste(String piste) {
    this.piste = piste;
  }

  public Integer getEtatPiste() {
    return etatPiste;
  }

  public void setEtatPiste(Integer etatPiste) {
    this.etatPiste = etatPiste;
  }

  public PersonnelAgs getSecondPilote() {
    return secondPilote;
  }

  public void setSecondPilote(PersonnelAgs secondPilote) {
    this.secondPilote = secondPilote;
  }

  public boolean isIsAnnonyme() {
    return isAnnonyme;
  }

  public void setIsAnnonyme(boolean isAnnonyme) {
    this.isAnnonyme = isAnnonyme;
  }

  public String getAutreEvent() {
    return autreEvent;
  }

  public void setAutreEvent(String autreEvent) {
    this.autreEvent = autreEvent;
  }

  public String getAutreConsequence() {
    return autreConsequence;
  }

  public void setAutreConsequence(String autreConsequence) {
    this.autreConsequence = autreConsequence;
  }

  public Integer getPriorite() {
    return priorite;
  }

  public void setPriorite(Integer priorite) {
    this.priorite = priorite;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public PersonnelAgs getTraitePar() {
    return traitePar;
  }

  public void setTraitePar(PersonnelAgs traitePar) {
    this.traitePar = traitePar;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public PersonnelAgs getPersonnelAgs() {
    return personnelAgs;
  }

  public void setPersonnelAgs(PersonnelAgs personnelAgs) {
    this.personnelAgs = personnelAgs;
  }

  public List<AsrEvents> getAsrEventsList() {
    return asrEventsList;
  }

  public void setAsrEventsList(List<AsrEvents> asrEventsList) {
    this.asrEventsList = asrEventsList;
  }

  public List<AsrComments> getAsrCommentsList() {
    return asrCommentsList;
  }

  public void setAsrCommentsList(List<AsrComments> asrCommentsList) {
    this.asrCommentsList = asrCommentsList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Asr)) {
      return false;
    }
    Asr other = (Asr) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.fpn.Asr[ id=" + id + " ]";
  }

}
