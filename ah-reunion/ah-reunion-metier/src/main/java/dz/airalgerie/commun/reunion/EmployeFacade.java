package dz.airalgerie.commun.reunion;

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

}
