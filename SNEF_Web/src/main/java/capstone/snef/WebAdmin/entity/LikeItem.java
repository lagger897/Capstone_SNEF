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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "Like", catalog = "SNEF_Part2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LikeItem.findAll", query = "SELECT l FROM LikeItem l")
    , @NamedQuery(name = "LikeItem.findByLikeId", query = "SELECT l FROM LikeItem l WHERE l.likeId = :likeId")})
public class LikeItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LikeId")
    private Integer likeId;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "StoreProductId", referencedColumnName = "StoreProductId")
    @ManyToOne(optional = false)
    private StoreProduct storeProductId;

    public LikeItem() {
    }

    public LikeItem(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
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
        if (!(object instanceof LikeItem)) {
            return false;
        }
        LikeItem other = (LikeItem) object;
        if ((this.likeId == null && other.likeId != null) || (this.likeId != null && !this.likeId.equals(other.likeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.LikeItem[ likeId=" + likeId + " ]";
    }
    
}
