package dz.airalgerie.commun.reunion;

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrateur
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> {

  @PersistenceContext(unitName = "produit_pu")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public ProduitFacade() {
    super(Produit.class);
  }

}
