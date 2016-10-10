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
@Table(name = "a_agent1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AAgent1.findAll", query = "SELECT a FROM AAgent1 a"),
    @NamedQuery(name = "AAgent1.findByFqid", query = "SELECT a FROM AAgent1 a WHERE a.fqid = :fqid"),
    @NamedQuery(name = "AAgent1.findByLabel", query = "SELECT a FROM AAgent1 a WHERE a.label = :label"),
    @NamedQuery(name = "AAgent1.findByX", query = "SELECT a FROM AAgent1 a WHERE a.x = :x"),
    @NamedQuery(name = "AAgent1.findByY", query = "SELECT a FROM AAgent1 a WHERE a.y = :y")})
public class AAgent1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "fqid")
    private String fqid;
    @Size(max = 2147483647)
    @Column(name = "label")
    private String label;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "x")
    private Double x;
    @Column(name = "y")
    private Double y;

    public AAgent1() {
    }

    public AAgent1(String fqid) {
        this.fqid = fqid;
    }

    public String getFqid() {
        return fqid;
    }

    public void setFqid(String fqid) {
        this.fqid = fqid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fqid != null ? fqid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AAgent1)) {
            return false;
        }
        AAgent1 other = (AAgent1) object;
        if ((this.fqid == null && other.fqid != null) || (this.fqid != null && !this.fqid.equals(other.fqid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sim.test.db.entity.AAgent1[ fqid=" + fqid + " ]";
    }
    
}
