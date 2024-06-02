/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.ca;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */

@Entity
@Table(name = "STATB20", schema = "CA")
@XmlRootElement

public class STATB20 implements Serializable {

  @Column(name = "CHAR_PAX")
  private BigDecimal charPax;
  @Column(name = "CHAR_FRET")
  private BigDecimal charFret;
  @Column(name = "AFRT_AVION")
  private BigDecimal afrtAvion;
  @Column(name = "RECETTE_ANNEXE")
  private BigDecimal recetteAnnexe;

  @Column(name = "RECETTE_FRET")
  private BigDecimal recette_fret;

  @EmbeddedId
  protected StatB20PK StatB20PK;
  @Column(name = "DATE_TRT")
  private Integer date_trt;
  // @Column(name = "DATE_TRT")
  // private Integer date_trt;
  @Column(name = "NUM_LIGNE")
  private Integer num_ligne;
  @Column(name = "MATR_APP")
  @Size(max = 2)
  private String matr_app;
  @Size(max = 2)
  @Column(name = "TYPE_APP")
  private String type_app;
  @Size(max = 1)
  @Column(name = "NATURE_VOL")
  private String nature_vol;
  @Size(max = 6)
  @Column(name = "RELATION")
  private String relation;
  @Size(max = 1)
  @Column(name = "NATURE_DOC")
  private String nature_doc;

  @Column(name = "COMPTE_ANALYT")
  private BigDecimal compte_analyt;
  @Size(max = 4)
  @Column(name = "CODE_RELAT")
  private String code_relat;

  @Column(name = "ENT_SOR")
  private BigDecimal ent_sor;
  @Size(max = 255)
  @Column(name = "DISTANCE")
  private String distance;

  @Column(name = "SIEGES_OFF_F")
  private Integer sieges_off_f;

  @Column(name = "SIEGES_OFF_C")
  private Integer sieges_off_c;

  @Column(name = "SIEGES_OFF_Y")
  private Integer sieges_off_y;

  @Column(name = "NOMBRE_PAX_F")
  private Integer nombre_pax_f;

  @Column(name = "NOMBRE_PAX_C")
  private Integer nombre_pax_c;

  @Column(name = "NOMBRE_PAX_Y")
  private Integer nombre_pax_y;

  @Column(name = "GRATUITE_PAX_F")
  private Integer gratuite_pax_f;

  @Column(name = "GRATUITE_PAX_C")
  private Integer gratuite_pax_c;

  @Column(name = "GRATUITE_PAX_Y")
  private Integer gratuite_pax_y;

  @Column(name = "GRATUITE_BB_F")
  private Integer gratuite_bb_f;

  @Column(name = "GRATUITE_BB_C")
  private Integer gratuite_bb_c;

  @Column(name = "GRATUITE_BB_Y")
  private Integer gratuite_bb_y;

  @Column(name = "RECETTE_PAX")
  private BigDecimal recette_pax;

  @Column(name = "RECETTE_BCB")
  private BigDecimal recette_bcb;

  @Size(max = 18)
  @Column(name = "ROTATION")
  private String rotation;

  @Column(name = "HEURE_MIN")
  private BigDecimal heure_min;

  @Column(name = "RECETTE_POSTE")
  private BigDecimal recette_poste;

  @Column(name = "NBR_ROT")
  private Integer nbr_rot;

  public STATB20() {

  }

  public StatB20PK getStatB20PK() {
    return StatB20PK;
  }

  public void setStatB20PK(StatB20PK StatB20PK) {
    this.StatB20PK = StatB20PK;
  }

  public String getMatr_app() {
    return matr_app;
  }

  public void setMatr_app(String matr_app) {
    this.matr_app = matr_app;
  }

  public String getType_app() {
    return type_app;
  }

  public void setType_app(String type_app) {
    this.type_app = type_app;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public String getCode_relat() {
    return code_relat;
  }

  public void setCode_relat(String code_relat) {
    this.code_relat = code_relat;
  }

  public Integer getSieges_off_f() {
    return sieges_off_f;
  }

  public void setSieges_off_f(Integer sieges_off_f) {
    this.sieges_off_f = sieges_off_f;
  }

  public Integer getSieges_off_c() {
    return sieges_off_c;
  }

  public void setSieges_off_c(Integer sieges_off_c) {
    this.sieges_off_c = sieges_off_c;
  }

  public Integer getSieges_off_y() {
    return sieges_off_y;
  }

  public void setSieges_off_y(Integer sieges_off_y) {
    this.sieges_off_y = sieges_off_y;
  }

  public Integer getNombre_pax_f() {
    return nombre_pax_f;
  }

  public void setNombre_pax_f(Integer nombre_pax_f) {
    this.nombre_pax_f = nombre_pax_f;
  }

  public Integer getNombre_pax_c() {
    return nombre_pax_c;
  }

  public void setNombre_pax_c(Integer nombre_pax_c) {
    this.nombre_pax_c = nombre_pax_c;
  }

  public Integer getNombre_pax_y() {
    return nombre_pax_y;
  }

  public void setNombre_pax_y(Integer nombre_pax_y) {
    this.nombre_pax_y = nombre_pax_y;
  }

  public Integer getGratuite_pax_f() {
    return gratuite_pax_f;
  }

  public void setGratuite_pax_f(Integer gratuite_pax_f) {
    this.gratuite_pax_f = gratuite_pax_f;
  }

  public Integer getGratuite_pax_c() {
    return gratuite_pax_c;
  }

  public void setGratuite_pax_c(Integer gratuite_pax_c) {
    this.gratuite_pax_c = gratuite_pax_c;
  }

  public Integer getGratuite_pax_y() {
    return gratuite_pax_y;
  }

  public void setGratuite_pax_y(Integer gratuite_pax_y) {
    this.gratuite_pax_y = gratuite_pax_y;
  }

  public Integer getGratuite_bb_f() {
    return gratuite_bb_f;
  }

  public void setGratuite_bb_f(Integer gratuite_bb_f) {
    this.gratuite_bb_f = gratuite_bb_f;
  }

  public Integer getGratuite_bb_c() {
    return gratuite_bb_c;
  }

  public void setGratuite_bb_c(Integer gratuite_bb_c) {
    this.gratuite_bb_c = gratuite_bb_c;
  }

  public Integer getGratuite_bb_y() {
    return gratuite_bb_y;
  }

  public void setGratuite_bb_y(Integer gratuite_bb_y) {
    this.gratuite_bb_y = gratuite_bb_y;
  }

  public BigDecimal getRecette_pax() {
    return recette_pax;
  }

  public void setRecette_pax(BigDecimal recette_pax) {
    this.recette_pax = recette_pax;
  }

  public BigDecimal getRecette_bcb() {
    return recette_bcb;
  }

  public void setRecette_bcb(BigDecimal recette_bcb) {
    this.recette_bcb = recette_bcb;
  }

  public BigDecimal getRecette_fret() {
    return recette_fret;
  }

  public void setRecette_fret(BigDecimal recette_fret) {
    this.recette_fret = recette_fret;
  }

  public String getRotation() {
    return rotation;
  }

  public void setRotation(String rotation) {
    this.rotation = rotation;
  }

  public BigDecimal getHeure_min() {
    return heure_min;
  }

  public void setHeure_min(BigDecimal heure_min) {
    this.heure_min = heure_min;
  }

  public BigDecimal getRecette_poste() {
    return recette_poste;
  }

  public void setRecette_poste(BigDecimal recette_poste) {
    this.recette_poste = recette_poste;
  }

  public Integer getNbr_rot() {
    return nbr_rot;
  }

  public void setNbr_rot(Integer nbr_rot) {
    this.nbr_rot = nbr_rot;
  }

  // public STATB20(Integer id) {
  // this.id = id;
  // }
  //
  // public STATB20(Integer id, int dateTrt, short numLigne) {
  // this.id = id;
  // this.dateTrt = dateTrt;
  // this.numLigne = numLigne;
  // }
  //
  // public Integer getId() {
  // return id;
  // }
  //
  // public void setId(Integer id) {
  // this.id = id;
  // }

  public BigDecimal getCharPax() {
    return charPax;
  }

  public void setCharPax(BigDecimal charPax) {
    this.charPax = charPax;
  }

  public BigDecimal getCharFret() {
    return charFret;
  }

  public void setCharFret(BigDecimal charFret) {
    this.charFret = charFret;
  }

  public BigDecimal getAfrtAvion() {
    return afrtAvion;
  }

  public void setAfrtAvion(BigDecimal afrtAvion) {
    this.afrtAvion = afrtAvion;
  }

  public BigDecimal getRecetteAnnexe() {
    return recetteAnnexe;
  }

  public void setRecetteAnnexe(BigDecimal recetteAnnexe) {
    this.recetteAnnexe = recetteAnnexe;
  }

  // @Override
  // public int hashCode() {
  // int hash = 0;
  // hash += (id != null ? id.hashCode() : 0);
  // return hash;
  // }

  // @Override
  // public boolean equals(Object object) {
  // // TODO: Warning - this method won't work in the case the id fields are not set
  // if (!(object instanceof STATB20)) {
  // return false;
  // }
  // STATB20 other = (STATB20) object;
  // if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
  // return false;
  // }
  // return true;
  // }

  // @Override
  // public String toString() {
  // return "jpa.STATB20[ id=" + id + " ]";
  // }

  public STATB20(StatB20PK StatB20PK) {
    this.StatB20PK = StatB20PK;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + Objects.hashCode(this.StatB20PK);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final STATB20 other = (STATB20) obj;
    if (!Objects.equals(this.StatB20PK, other.StatB20PK)) {
      return false;
    }
    return true;
  }

  public Integer getDate_trt() {
    return date_trt;
  }

  public void setDate_trt(Integer date_trt) {
    this.date_trt = date_trt;
  }

  public Integer getNum_ligne() {
    return num_ligne;
  }

  public void setNum_ligne(Integer num_ligne) {
    this.num_ligne = num_ligne;
  }

  public String getNature_vol() {
    return nature_vol;
  }

  public void setNature_vol(String nature_vol) {
    this.nature_vol = nature_vol;
  }

  public String getNature_doc() {
    return nature_doc;
  }

  public void setNature_doc(String nature_doc) {
    this.nature_doc = nature_doc;
  }

  public BigDecimal getCompte_analyt() {
    return compte_analyt;
  }

  public void setCompte_analyt(BigDecimal compte_analyt) {
    this.compte_analyt = compte_analyt;
  }

  public BigDecimal getEnt_sor() {
    return ent_sor;
  }

  public void setEnt_sor(BigDecimal ent_sor) {
    this.ent_sor = ent_sor;
  }

  public String getDistance() {
    return distance;
  }

  public void setDistance(String distance) {
    this.distance = distance;
  }

}
