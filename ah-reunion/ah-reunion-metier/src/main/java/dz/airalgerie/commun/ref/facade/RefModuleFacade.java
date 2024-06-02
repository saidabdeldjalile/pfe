/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.facade;

import dz.airalgerie.commun.facade.AbstractFacade;
import dz.airalgerie.commun.model.utils.FunctionDTO;
import dz.airalgerie.commun.model.utils.ModuleDTO;
import dz.airalgerie.commun.model.utils.QueryResult;
import dz.airalgerie.commun.ref.entities.RefDomaine;
import dz.airalgerie.commun.ref.entities.RefModule;
import dz.airalgerie.commun.ref.entities.RefModule_;
import dz.airalgerie.commun.ref.model.dto.auth.RefModuleDTO;
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
public class RefModuleFacade extends AbstractFacade<RefModule> {

  @PersistenceContext(unitName = ErpConstante.UnitName.REF_PU_NAME)
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public RefModuleFacade() {
    super(RefModule.class);
  }

  /**
   * Permet d'avoir le menu de l'application pour chaque utilisateur connecté.
   *
   * @param codeDomaine
   * 
   * @return
   */
  public List<ModuleDTO> findMenuByDomaine(String codeDomaine, Integer matricule) {
    if (codeDomaine != null && !codeDomaine.isEmpty()) {
      // TODO: Supprimer la requête, seulement à titre informatif.
      // List<RefModule> list = new ArrayList<>();
      // = em.createQuery("SELECT DISTINCT m FROM RefModule m LEFT JOIN m.refModules me LEFT JOIN
      // m.refFonctions mf LEFT JOIN me.refFonctions mef LEFT JOIN mf.refPermissions mfp LEFT JOIN
      // mef.refPermissions mefp WHERE m.refDomaine.code =:codeDomaine AND m.refModuleParent IS NULL
      // AND ((mfp.autorize = 1 AND mfp.refRole.id = 1) OR (mefp.autorize = 1 AND mefp.refRole.id =
      // 1)) ORDER BY m.rang ASC")
      // .setHint("eclipselink.batch", "m.refFonctions")
      // .setHint("eclipselink.batch", "m.refFonctions.refPermissions")
      // .setHint("eclipselink.batch", "m.refModules")
      // .setHint("eclipselink.batch", "m.refModules.refFonctions")
      // .setHint("eclipselink.batch", "m.refModules.refFonctions.refPermissions")
      // .setParameter("codeDomaine", codeDomaine)
      // .getResultList();

      List<Object[]> results = em.createNativeQuery("SELECT DISTINCT MP.ID ID_MP\n"
          + "	, MP.LIBELLE MP_LIBELLE\n" + "	, MP.DESCR MP_DESCR\n" + "	, MP.RANG MP_RANG\n"
          + "	, MP.ICON ICON\n" + "	, MF.ID ID_MF\n" + "	, MF.LIBELLE MF_LIBELLE\n"
          + "	, MF.DESCR MF_DESCR\n" + "	, MF.RANG MF_RANG\n" + "	, F.ID ID_F\n"
          + "	, F.LIBELLE F_LIBELLE\n" + "	, F.DESCR F_DESCR\n" + "	, F.URL URL\n"
          + "	, F.RANG F_RANG\n" + "FROM AUTH.MODULE MP\n"
          + "	INNER JOIN AUTH.DOMAINE D ON D.ID = MP.ID_DOMAINE AND D.STATUT = 1\n"
          + "	LEFT JOIN AUTH.MODULE MF ON MF.ID_MODULE_PARENT = MP.ID AND MF.STATUT = 1\n"
          + "	LEFT JOIN AUTH.FONCTION F ON F.ID_MODULE = CASE WHEN MF.ID IS NOT NULL THEN MF.ID ELSE MP.ID END AND F.STATUT = 1\n"
          + "	INNER JOIN AUTH.PERMISSION P ON P.ID_FONCTION = F.ID\n"
          + "	INNER JOIN AUTH.GROUPE_PERMISSION GP ON P.ID = GP.ID_PERMISSION\n"
          + "	INNER JOIN AUTH.USERS_GROUPE UG ON UG.ID_GROUPE = GP.ID_GROUPE\n"
          + "	INNER JOIN AUTH.USERS U ON U.MATRICULE = UG.MATRICULE\n" + "WHERE D.CODE = ?1\n"
          + "	AND MP.STATUT = 1\n" + "	AND MP.ID_MODULE_PARENT IS NULL\n"
          + "	AND U.MATRICULE = ?2\n" + "\n" + "UNION\n" + "\n" + "SELECT DISTINCT MP.ID ID_MP\n"
          + "	, MP.LIBELLE MP_LIBELLE\n" + "	, MP.DESCR MP_DESCR\n" + "	, MP.RANG MP_RANG\n"
          + "	, MP.ICON ICON\n" + "	, NULL ID_MF\n" + "	, NULL MF_LIBELLE\n"
          + "	, NULL MF_DESCR\n" + "	, NULL MF_RANG\n" + "	, F.ID ID_F\n"
          + "	, F.LIBELLE F_LIBELLE\n" + "	, F.DESCR F_DESCR\n" + "	, F.URL URL\n"
          + "	, F.RANG F_RANG\n" + "FROM AUTH.MODULE MP\n"
          + "	INNER JOIN AUTH.DOMAINE D ON D.ID = MP.ID_DOMAINE AND D.STATUT = 1\n"
          + "	LEFT JOIN AUTH.FONCTION F ON F.ID_MODULE = MP.ID AND F.STATUT = 1\n"
          + "	INNER JOIN AUTH.PERMISSION P ON P.ID_FONCTION = F.ID\n"
          + "	INNER JOIN AUTH.GROUPE_PERMISSION GP ON P.ID = GP.ID_PERMISSION\n"
          + "	INNER JOIN AUTH.USERS_GROUPE UG ON UG.ID_GROUPE = GP.ID_GROUPE\n"
          + "	INNER JOIN AUTH.USERS U ON U.MATRICULE = UG.MATRICULE\n" + "WHERE D.CODE = ?1\n"
          + "	AND MP.STATUT = 1\n" + "	AND MP.ID_MODULE_PARENT IS NULL\n"
          + "	AND U.MATRICULE = ?2\n"
          + "ORDER BY MP_RANG, MP_LIBELLE, MF_RANG, MF_LIBELLE, F_RANG, F.LIBELLE")
          .setParameter("1", codeDomaine).setParameter("2", matricule).getResultList();

      List<ModuleDTO> menu = new ArrayList<>();
      ModuleDTO module = null;
      ModuleDTO subModule = null;
      FunctionDTO fonction = null;

      for (Object[] record : results) {
        if (module == null || !module.getId().equals(record[0])) {
          if (module != null) {
            if (subModule != null) {
              module.getSubModule().add(subModule);
            }
            menu.add(module);
          }

          module = new ModuleDTO((Integer) record[0], (String) record[1], (String) record[2],
              (Integer) record[3], (String) record[4]);
          subModule = null;
        }

        if ((subModule == null && record[5] != null)
            || (subModule != null && !record[5].equals(subModule.getId()))) {
          if (subModule != null) {
            module.getSubModule().add(subModule);
          }
          subModule = new ModuleDTO((Integer) record[5], (String) record[6], (String) record[7],
              (Integer) record[8], null);

        }

        if ((subModule != null && record[5].equals(subModule.getId()))) {
          fonction = new FunctionDTO((Integer) record[9], (String) record[10], (String) record[11],
              (String) record[12], (Integer) record[13]);
          subModule.getFonctions().add(fonction);
        } else if (record[5] == null) {
          fonction = new FunctionDTO((Integer) record[9], (String) record[10], (String) record[11],
              (String) record[12], (Integer) record[13]);
          module.getFonctions().add(fonction);
        }
      }
      if (module != null) {
        if (subModule != null) {
          module.getSubModule().add(subModule);
        }

        menu.add(module);
      }

      return menu;

    }
    return new ArrayList<>();
  }

  public List<RefModule> findByCodeDomaine(String codeDomaine) {
    if (codeDomaine != null && !codeDomaine.isEmpty()) {
      // List<RefModule> list = em.createQuery("SELECT m FROM RefModule m where m.refDomaine.code
      // =:codeDomaine and m.refModuleParent is null order by m.refModuleParent, m.rang",
      // RefModule.class)
      // .setParameter("codeDomaine", codeDomaine)
      // .getResultList();
      List<RefModule> list = em.createQuery(
          "SELECT m FROM RefModule m where m.refDomaine.code =:codeDomaine order by m.refModuleParent, m.rang",
          RefModule.class).setParameter("codeDomaine", codeDomaine).getResultList();

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
  public QueryResult<RefModuleDTO> findPaginatedModules(boolean count, int first, int pageSize,
      String sortField, Boolean sortOrder, Map<String, Object> filters) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<RefModuleDTO> q = cb.createQuery(RefModuleDTO.class);
    Root<RefModule> module = q.from(RefModule.class);

    Join<RefModule, RefDomaine> domaine =
        (Join<RefModule, RefDomaine>) module.fetch(RefModule_.refDomaine, JoinType.LEFT);
    Join<RefModule, RefModule> moduleParent =
        (Join<RefModule, RefModule>) module.fetch(RefModule_.refModuleParent, JoinType.LEFT);

    Path<?> path = module;
    q.multiselect(path.get("id"), path.get("code"), path.get("libelle"), path.get("descr"),
        path.get("rang"), path.get("icon"), path.get("statut"), domaine.get("id"),
        domaine.get("code"), moduleParent.get("id"));

    return (QueryResult<RefModuleDTO>) findPaginated(module, q, count, first, pageSize, sortField,
        sortOrder, filters);
  }

  /**
   * Permet de faire une recherche par autocomplétion des modules.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des modules correspondants au termes.
   */
  public List<RefModule> findAutoCompleteBylibelle(String query) {
    return em.createQuery("SELECT m FROM RefModule m WHERE m.libelle LIKE :libelle")
        .setParameter("libelle", "%" + query + "%").setMaxResults(20).getResultList();
  }

  /**
   * Permet de faire une recherche des modules par domaine
   *
   * @param Domaine Paramètre recherché.
   * @return
   */
  public List<RefModule> findModuleByDomaine(String Domaine) {
    return em.createQuery("SELECT m FROM RefModule m WHERE m.refDomaine.code = :code")
        .setParameter("code", Domaine).getResultList();
  }

}
