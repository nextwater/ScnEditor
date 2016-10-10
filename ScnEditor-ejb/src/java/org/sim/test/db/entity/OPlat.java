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
@Table(name = "o_plat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OPlat.findAll", query = "SELECT o FROM OPlat o"),
    @NamedQuery(name = "OPlat.findByFqid", query = "SELECT o FROM OPlat o WHERE o.fqid = :fqid"),
    @NamedQuery(name = "OPlat.findByLabel", query = "SELECT o FROM OPlat o WHERE o.label = :label"),
    @NamedQuery(name = "OPlat.findByX", query = "SELECT o FROM OPlat o WHERE o.x = :x"),
    @NamedQuery(name = "OPlat.findByY", query = "SELECT o FROM OPlat o WHERE o.y = :y")})
public class OPlat implements Serializable {

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

    public OPlat() {
    }

    public OPlat(String fqid) {
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
        if (!(object instanceof OPlat)) {
            return false;
        }
        OPlat other = (OPlat) object;
        if ((this.fqid == null && other.fqid != null) || (this.fqid != null && !this.fqid.equals(other.fqid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sim.test.db.entity.OPlat[ fqid=" + fqid + " ]";
    }
    
}
