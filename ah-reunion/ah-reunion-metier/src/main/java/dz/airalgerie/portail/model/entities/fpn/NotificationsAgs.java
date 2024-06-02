/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.fpn;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = ErpConstante.DbSchemaName.AGS_AUTH, name = "V_NOTIFICATIONS")
@NamedQueries({
    @NamedQuery(name = "NotificationsAgs.findAll", query = "SELECT n FROM NotificationsAgs n")})
public class NotificationsAgs implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "TYPE")
  private String type;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Size(max = 10)
  @Column(name = "DOMAINE")
  private String domaine;
  @Size(max = 50)
  @Column(name = "NOTIFIABLE_TYPE")
  private String notifiableType;
  @Column(name = "NOTIFIABLE_ID")
  private Integer notifiableId;
  @Lob
  @Size(max = 2147483647)
  @Column(name = "DATA")
  private String data;
  @Column(name = "IS_READ")
  private Boolean isRead;
  @Column(name = "READ_AT")
  private LocalDateTime readAt;
  @Column(name = "CREATED_AT")
  private LocalDateTime createdAt;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "notifications1", fetch = FetchType.LAZY)
  private NotificationsAgs notifications;
  @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private NotificationsAgs notifications1;

  public NotificationsAgs() {
  }

  public NotificationsAgs(Integer id) {
    this.id = id;
  }

  public NotificationsAgs(Integer id, String type, int matricule) {
    this.id = id;
    this.type = type;
    this.matricule = matricule;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public String getDomaine() {
    return domaine;
  }

  public void setDomaine(String domaine) {
    this.domaine = domaine;
  }

  public String getNotifiableType() {
    return notifiableType;
  }

  public void setNotifiableType(String notifiableType) {
    this.notifiableType = notifiableType;
  }

  public Integer getNotifiableId() {
    return notifiableId;
  }

  public void setNotifiableId(Integer notifiableId) {
    this.notifiableId = notifiableId;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Boolean getIsRead() {
    return isRead;
  }

  public void setIsRead(Boolean isRead) {
    this.isRead = isRead;
  }

  public LocalDateTime getReadAt() {
    return readAt;
  }

  public void setReadAt(LocalDateTime readAt) {
    this.readAt = readAt;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public NotificationsAgs getNotifications() {
    return notifications;
  }

  public void setNotifications(NotificationsAgs notifications) {
    this.notifications = notifications;
  }

  public NotificationsAgs getNotifications1() {
    return notifications1;
  }

  public void setNotifications1(NotificationsAgs notifications1) {
    this.notifications1 = notifications1;
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
    if (!(object instanceof NotificationsAgs)) {
      return false;
    }
    NotificationsAgs other = (NotificationsAgs) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.fpn.Notifications[ id=" + id + " ]";
  }

}
