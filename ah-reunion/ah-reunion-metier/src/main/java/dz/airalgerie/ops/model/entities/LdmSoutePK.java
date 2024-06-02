/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ops.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Root
 */
@Embeddable
public class LdmSoutePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "F_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLT")
    private int flt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SUFFIX")
    private String suffix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ARR")
    private String arr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COMPARTIMENT")
    private String compartiment;

    public LdmSoutePK() {
    }

    public LdmSoutePK(Date fDate, int flt, String suffix, String arr, String compartiment) {
        this.fDate = fDate;
        this.flt = flt;
        this.suffix = suffix;
        this.arr = arr;
        this.compartiment = compartiment;
    }

    public Date getFDate() {
        return fDate;
    }

    public void setFDate(Date fDate) {
        this.fDate = fDate;
    }

    public int getFlt() {
        return flt;
    }

    public void setFlt(int flt) {
        this.flt = flt;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getArr() {
        return arr;
    }

    public void setArr(String arr) {
        this.arr = arr;
    }

    public String getCompartiment() {
        return compartiment;
    }

    public void setCompartiment(String compartiment) {
        this.compartiment = compartiment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fDate != null ? fDate.hashCode() : 0);
        hash += (int) flt;
        hash += (suffix != null ? suffix.hashCode() : 0);
        hash += (arr != null ? arr.hashCode() : 0);
        hash += (compartiment != null ? compartiment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LdmSoutePK)) {
            return false;
        }
        LdmSoutePK other = (LdmSoutePK) object;
        if ((this.fDate == null && other.fDate != null) || (this.fDate != null && !this.fDate.equals(other.fDate))) {
            return false;
        }
        if (this.flt != other.flt) {
            return false;
        }
        if ((this.suffix == null && other.suffix != null) || (this.suffix != null && !this.suffix.equals(other.suffix))) {
            return false;
        }
        if ((this.arr == null && other.arr != null) || (this.arr != null && !this.arr.equals(other.arr))) {
            return false;
        }
        if ((this.compartiment == null && other.compartiment != null) || (this.compartiment != null && !this.compartiment.equals(other.compartiment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.ops.model.entities.LdmSoutePK[ fDate=" + fDate + ", flt=" + flt + ", suffix=" + suffix + ", arr=" + arr + ", compartiment=" + compartiment + " ]";
    }

}
