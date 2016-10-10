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
@Table(name = "t_move")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMove.findAll", query = "SELECT t FROM TMove t"),
    @NamedQuery(name = "TMove.findByFqid", query = "SELECT t FROM TMove t WHERE t.fqid = :fqid"),
    @NamedQuery(name = "TMove.findByLabel", query = "SELECT t FROM TMove t WHERE t.label = :label"),
    @NamedQuery(name = "TMove.findByToX", query = "SELECT t FROM TMove t WHERE t.toX = :toX"),
    @NamedQuery(name = "TMove.findByToY", query = "SELECT t FROM TMove t WHERE t.toY = :toY"),
    @NamedQuery(name = "TMove.findByT", query = "SELECT t FROM TMove t WHERE t.t = :t")})
public class TMove implements Serializable {

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
    @Column(name = "to_x")
    private Double toX;
    @Column(name = "to_y")
    private Double toY;
    @Column(name = "t")
    private Integer t;

    public TMove() {
    }

    public TMove(String fqid) {
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

    public Double getToX() {
        return toX;
    }

    public void setToX(Double toX) {
        this.toX = toX;
    }

    public Double getToY() {
        return toY;
    }

    public void setToY(Double toY) {
        this.toY = toY;
    }

    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
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
        if (!(object instanceof TMove)) {
            return false;
        }
        TMove other = (TMove) object;
        if ((this.fqid == null && other.fqid != null) || (this.fqid != null && !this.fqid.equals(other.fqid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sim.test.db.entity.TMove[ fqid=" + fqid + " ]";
    }
    
}
