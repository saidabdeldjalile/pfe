package dz.airalgerie.commun.reunion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FichierReunionFacade extends AbstractFacade<FichierReunion> {

    @PersistenceContext(unitName = "produit_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichierReunionFacade() {
        super(FichierReunion.class);
    }
}
