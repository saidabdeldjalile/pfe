/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.facade;

import dz.airalgerie.commun.facade.AbstractFacade;
import dz.airalgerie.commun.model.utils.QueryResult;
import dz.airalgerie.commun.ref.entities.RefFonction;
import dz.airalgerie.commun.ref.entities.RefFonction_;
import dz.airalgerie.commun.ref.entities.RefModule;
import dz.airalgerie.commun.ref.model.dto.auth.RefFonctionDTO;
import dz.airalgerie.commun.utils.ErpConstante;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

/**
 *
 * @author Sofyane MAKERRI
 */
@Stateless
public class RefFonctionFacade extends AbstractFacade<RefFonction> {

  @PersistenceContext(unitName = ErpConstante.UnitName.REF_PU_NAME)
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public RefFonctionFacade() {
    super(RefFonction.class);
  }

  public List<RefFonction> findByCodeDomaine(String codeDomaine) {
    if (codeDomaine != null && !codeDomaine.isEmpty()) {
      // List<RefModule> list = em.createQuery("SELECT m FROM RefModule m where m.refDomaine.code
      // =:codeDomaine and m.refModuleParent is null order by m.refModuleParent, m.rang",
      // RefModule.class)
      // .setParameter("codeDomaine", codeDomaine)
      // .getResultList();
      List<RefFonction> list = em.createQuery(
          "SELECT m FROM RefFonction m where m.refModule.refDomaine.code =:codeDomaine order by m.refModule.refModuleParent, m.rang",
          RefFonction.class).setParameter("codeDomaine", codeDomaine).getResultList();

      return list;

    }
    return new ArrayList<>();
  }

  /**
   * Recherche les modules avec pagination
   *
   * @param count     Permet de calculer le nombe total de résultats.
   * @param first     Indice du premier résultat.
   * @param pageSize  Nombre de lignes d'une page.
   * @param sortField Champ destiné au tri.
   * @param sortOrder Sens du tri.
   * @param filters   Liste des filtres à appliquer sur la recherche.
   * @return
   */
  public QueryResult<RefFonctionDTO> findPaginatedFonctions(boolean count, int first, int pageSize,
      String sortField, Boolean sortOrder, Map<String, Object> filters) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<RefFonctionDTO> q = cb.createQuery(RefFonctionDTO.class);
    Root<RefFonction> fonction = q.from(RefFonction.class);

    Join<RefFonction, RefModule> module =
        (Join<RefFonction, RefModule>) fonction.fetch(RefFonction_.refModule, JoinType.LEFT);

    Path<?> path = fonction;
    q.multiselect(path.get("id"), path.get("code"), path.get("libelle"), path.get("descr"),
        path.get("url"), path.get("rang"), path.get("icon"), path.get("statut"), module.get("id"),
        module.get("code"));

    return (QueryResult<RefFonctionDTO>) findPaginated(fonction, q, count, first, pageSize,
        sortField, sortOrder, filters);
  }

  /**
   * Permet de faire une recherche par autocomplétion des fonctions.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des modules correspondants au termes.
   */
  public List<RefFonction> findAutoCompleteBylibelle(String query) {
    return em.createQuery("SELECT f FROM RefFonction f WHERE f.libelle LIKE :libelle")
        .setParameter("libelle", "%" + query + "%").setMaxResults(20).getResultList();
  }

  /**
   * Permet de faire une recherche des donctions par module
   *
   * @param Module Paramètre recherché.
   * @return
   */
  public List<RefFonction> findFunctionByModule(String Module) {
    return em.createQuery("SELECT m FROM RefFonction m WHERE m.refModule.code = :code")
        .setParameter("code", Module).getResultList();
  }

}
