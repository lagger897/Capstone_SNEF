/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "Like", catalog = "snef_part2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Like1.findAll", query = "SELECT l FROM Like1 l")
    , @NamedQuery(name = "Like1.findByLikeId", query = "SELECT l FROM Like1 l WHERE l.likeId = :likeId")})
public class Like1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LikeId", nullable = false)
    private Integer likeId;
    @JoinColumn(name = "AccountId", referencedColumnName = "AccountId")
    @ManyToOne
    private Account accountId;
    @JoinColumn(name = "StoreProductId", referencedColumnName = "StoreProductId", nullable = false)
    @ManyToOne(optional = false)
    private StoreProduct storeProductId;

    public Like1() {
    }

    public Like1(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public StoreProduct getStoreProductId() {
        return storeProductId;
    }

    public void setStoreProductId(StoreProduct storeProductId) {
        this.storeProductId = storeProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (likeId != null ? likeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Like1)) {
            return false;
        }
        Like1 other = (Like1) object;
        if ((this.likeId == null && other.likeId != null) || (this.likeId != null && !this.likeId.equals(other.likeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.Like1[ likeId=" + likeId + " ]";
    }
    
}
