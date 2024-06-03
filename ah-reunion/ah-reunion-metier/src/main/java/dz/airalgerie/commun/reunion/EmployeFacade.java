package dz.airalgerie.commun.reunion;

import dz.airalgerie.grh.model.dto.commun.PersonnelDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class EmployeFacade extends AbstractFacade<Employe> {

    @PersistenceContext(unitName = "produit_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeFacade() {
        super(Employe.class);
    }
  public List<Employe> findAllEmployees() {
        return em.createNamedQuery("Employe.findAll").getResultList();
    }
   public Employe findByMatricule(Integer matricule) {
        TypedQuery<Employe> query = em.createNamedQuery("Employe.findById", Employe.class);
        query.setParameter("matricule", matricule);
        List<Employe> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
   public List<Employe> findEmployesWithoutLogin() {
        TypedQuery<Employe> query = em.createQuery("SELECT e FROM Employe e WHERE e.login IS NULL", Employe.class);
        return query.getResultList();
    }
   
     /**
   * Permet de rechercher les donnees basiques d'un employe.
   *
   * @param matricule Matricule de l'employe.
   * @return Objet PersonnelDTO.
   */
  public PersonnelDTO findByMatriculeInfo(Integer matricule) {
    return (PersonnelDTO) em.createQuery(
        "SELECT new dz.airalgerie.grh.model.dto.commun.PersonnelDTO(p.matricule, p.nom, p.prenom, p.mail ) FROM Employe p WHERE p.matricule = :matricule",
        PersonnelDTO.class).setParameter("matricule", matricule).getSingleResult();
  }
  
    public Object[] findUserInfos(Integer matricule) {
    if (matricule != null && matricule > 0) {
      return (Object[]) em.createNativeQuery("SELECT P.[MATRICULE]\n" + "	, P.NOM\n"
          + "	, P.PRENOM\n" + ", P.MAIL " + "FROM dbo.EMPLOYE P\n"
          + "WHERE P.MATRICULE = ?1")
          .setParameter(1, matricule).getSingleResult();
    } else {
      Object[] userSignalitique = {"", ""};
      return (userSignalitique);
    }
  }

}
