package model.database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cássio Figueiredo
 */
@Entity
@Table(name = "tbtask")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbtask.findAll", query = "SELECT t FROM Tbtask t"),
    @NamedQuery(name = "Tbtask.findById", query = "SELECT t FROM Tbtask t WHERE t.id = :id"),
    @NamedQuery(name = "Tbtask.findByName", query = "SELECT t FROM Tbtask t WHERE t.name = :name"),
    @NamedQuery(name = "Tbtask.findByPriority", query = "SELECT t FROM Tbtask t WHERE t.priority = :priority"),
    @NamedQuery(name = "Tbtask.findBySituation", query = "SELECT t FROM Tbtask t WHERE t.situation = :situation"),
    @NamedQuery(name = "Tbtask.findByDate", query = "SELECT t FROM Tbtask t WHERE t.date = :date")})
public class Tbtask implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "priority")
    private String priority;
    @Basic(optional = false)
    @Column(name = "situation")
    private String situation;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Tbtask() {
    }

    public Tbtask(Integer id) {
        this.id = id;
    }

    public Tbtask(String name, String priority, String situation, Date date) {
        this.name = name;
        this.priority = priority;
        this.situation = situation;
        this.date = date;
    }

    public Tbtask(Integer id, String name, String priority, String situation, Date date) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.situation = situation;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbtask)) {
            return false;
        }
        Tbtask other = (Tbtask) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.database.Tbtask[ id=" + id + " ]";
    }
    
}
