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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author g
 */
@Entity
@Table(name = "r_rel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RRel.findAll", query = "SELECT r FROM RRel r"),
    @NamedQuery(name = "RRel.findByRid", query = "SELECT r FROM RRel r WHERE r.rid = :rid"),
    @NamedQuery(name = "RRel.findByValue", query = "SELECT r FROM RRel r WHERE r.value = :value")})
public class RRel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "rid")
    private String rid;
    @Size(max = 2147483647)
    @Column(name = "value")
    private String value;

    public RRel() {
    }

    public RRel(String rid) {
        this.rid = rid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RRel)) {
            return false;
        }
        RRel other = (RRel) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sim.test.db.entity.RRel[ rid=" + rid + " ]";
    }
    
}
