/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sim.test.db.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.sim.test.db.entity.TMove;

/**
 *
 * @author g
 */
@Stateless
public class TMoveFacade extends AbstractFacade<TMove> {

    @PersistenceContext(unitName = "ScnEditor-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TMoveFacade() {
        super(TMove.class);
    }
    
}
