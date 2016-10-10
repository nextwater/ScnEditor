/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sim.test.db.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.sim.test.db.entity.XEvent;

/**
 *
 * @author g
 */
@Stateless
public class XEventFacade extends AbstractFacade<XEvent> {

    @PersistenceContext(unitName = "ScnEditor-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public XEventFacade() {
        super(XEvent.class);
    }
    
    public List<String> findAgentsBySceneId(int sid){
        return em.createNativeQuery("SELECT fqid FROM x_event WHERE scenarioid=? AND fqid LIKE ?;")
                .setParameter(1, sid)
                .setParameter(2, "a.%")
                .getResultList();
    }
    
    public List<String> findObjsBySceneId(int sid){
        return em.createNativeQuery("SELECT fqid FROM x_event WHERE scenarioid=? AND fqid LIKE ?;")
                .setParameter(1, sid)
                .setParameter(2, "o.%")
                .getResultList();
    }

    public List<String> findTasksBySceneId(int sid){
        return em.createNativeQuery("SELECT fqid FROM x_event WHERE scenarioid=? AND fqid LIKE ?;")
                .setParameter(1, sid)
                .setParameter(2, "t.%")
                .getResultList();
    }
    
    public List<String> findRelsBySceneId(int sid){
        return em.createNativeQuery("SELECT rid FROM x_event WHERE scenarioid=? AND rid !='';")
                .setParameter(1, sid)
                .getResultList();
    }
}
