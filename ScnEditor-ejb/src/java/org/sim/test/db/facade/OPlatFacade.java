/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sim.test.db.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.sim.test.db.entity.OPlat;

/**
 *
 * @author g
 */
@Stateless
public class OPlatFacade extends AbstractFacade<OPlat> {

    @PersistenceContext(unitName = "ScnEditor-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OPlatFacade() {
        super(OPlat.class);
    }
    
}
