/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.entities.commun;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "COUNT_USERS",schema ="AUTH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountUsers.findAll", query = "SELECT c FROM CountUsers c"),
    @NamedQuery(name = "CountUsers.findByDomaine", query = "SELECT c FROM CountUsers c WHERE c.countUsersPK.domaine = :domaine"),
    @NamedQuery(name = "CountUsers.findByDate", query = "SELECT c FROM CountUsers c WHERE c.countUsersPK.date = :date"),
    @NamedQuery(name = "CountUsers.findByNbUtilisateur", query = "SELECT c FROM CountUsers c WHERE c.nbUtilisateur = :nbUtilisateur"),
    @NamedQuery(name = "CountUsers.findByPeak", query = "SELECT c FROM CountUsers c WHERE c.peak = :peak")})
public class CountUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CountUsersPK countUsersPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NB_UTILISATEUR")
    private int nbUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEAK")
    private int peak;

    public CountUsers() {
    }

    public CountUsers(CountUsersPK countUsersPK) {
        this.countUsersPK = countUsersPK;
    }

    public CountUsers(CountUsersPK countUsersPK, int nbUtilisateur, int peak) {
        this.countUsersPK = countUsersPK;
        this.nbUtilisateur = nbUtilisateur;
        this.peak = peak;
    }

    public CountUsers(String domaine, Date date) {
        this.countUsersPK = new CountUsersPK(domaine, date);
    }

    public CountUsersPK getCountUsersPK() {
        return countUsersPK;
    }

    public void setCountUsersPK(CountUsersPK countUsersPK) {
        this.countUsersPK = countUsersPK;
    }

    public int getNbUtilisateur() {
        return nbUtilisateur;
    }

    public void setNbUtilisateur(int nbUtilisateur) {
        this.nbUtilisateur = nbUtilisateur;
    }

    public int getPeak() {
        return peak;
    }

    public void setPeak(int peak) {
        this.peak = peak;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countUsersPK != null ? countUsersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountUsers)) {
            return false;
        }
        CountUsers other = (CountUsers) object;
        if ((this.countUsersPK == null && other.countUsersPK != null) || (this.countUsersPK != null && !this.countUsersPK.equals(other.countUsersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.commun.model.entities.commun.CountUsers[ countUsersPK=" + countUsersPK + " ]";
    }

}
