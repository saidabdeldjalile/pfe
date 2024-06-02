/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ops.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Root
 */
@Embeddable
public class LdmMessagePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "F_DATE")
    private LocalDateTime fDate;
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

    public LdmMessagePK() {
    }

    public LdmMessagePK(LocalDateTime fDate, int flt, String suffix, String arr) {
        this.fDate = fDate;
        this.flt = flt;
        this.suffix = suffix;
        this.arr = arr;
    }

    public LocalDateTime getFDate() {
        return fDate;
    }

    public void setFDate(LocalDateTime fDate) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fDate != null ? fDate.hashCode() : 0);
        hash += (int) flt;
        hash += (suffix != null ? suffix.hashCode() : 0);
        hash += (arr != null ? arr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LdmMessagePK)) {
            return false;
        }
        LdmMessagePK other = (LdmMessagePK) object;
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
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.ops.model.entities.LdmMessagePK[ fDate=" + fDate + ", flt=" + flt + ", suffix=" + suffix + ", arr=" + arr + " ]";
    }

}