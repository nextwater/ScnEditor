/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sim.test.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author g
 */
@Entity
@Table(name = "x_event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XEvent.findAll", query = "SELECT x FROM XEvent x"),
    @NamedQuery(name = "XEvent.findByEid", query = "SELECT x FROM XEvent x WHERE x.eid = :eid"),
    @NamedQuery(name = "XEvent.findByFqid", query = "SELECT x FROM XEvent x WHERE x.fqid = :fqid"),
    @NamedQuery(name = "XEvent.findByRid", query = "SELECT x FROM XEvent x WHERE x.rid = :rid"),
    @NamedQuery(name = "XEvent.findByScenarioid", query = "SELECT x FROM XEvent x WHERE x.scenarioid = :scenarioid"),
    @NamedQuery(name = "XEvent.findByStepid", query = "SELECT x FROM XEvent x WHERE x.stepid = :stepid")})
public class XEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eid")
    private Integer eid;
    @Size(max = 2147483647)
    @Column(name = "fqid")
    private String fqid;
    @Size(max = 2147483647)
    @Column(name = "rid")
    private String rid;
    @Column(name = "scenarioid")
    private Integer scenarioid;
    @Column(name = "stepid")
    private Integer stepid;

    public XEvent() {
    }

    public XEvent(Integer eid) {
        this.eid = eid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getFqid() {
        return fqid;
    }

    public void setFqid(String fqid) {
        this.fqid = fqid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Integer getScenarioid() {
        return scenarioid;
    }

    public void setScenarioid(Integer scenarioid) {
        this.scenarioid = scenarioid;
    }

    public Integer getStepid() {
        return stepid;
    }

    public void setStepid(Integer stepid) {
        this.stepid = stepid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eid != null ? eid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XEvent)) {
            return false;
        }
        XEvent other = (XEvent) object;
        if ((this.eid == null && other.eid != null) || (this.eid != null && !this.eid.equals(other.eid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sim.test.db.entity.XEvent[ eid=" + eid + " ]";
    }
    
}
