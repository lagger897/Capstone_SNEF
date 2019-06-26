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
@Table(name = "StoreFollwer", catalog = "SNEF_Part2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreFollwer.findAll", query = "SELECT s FROM StoreFollwer s")
    , @NamedQuery(name = "StoreFollwer.findByStoreFollower", query = "SELECT s FROM StoreFollwer s WHERE s.storeFollower = :storeFollower")})
public class StoreFollwer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StoreFollower")
    private Integer storeFollower;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "StoreId", referencedColumnName = "StoreId")
    @ManyToOne(optional = false)
    private Store storeId;

    public StoreFollwer() {
    }

    public StoreFollwer(Integer storeFollower) {
        this.storeFollower = storeFollower;
    }

    public Integer getStoreFollower() {
        return storeFollower;
    }

    public void setStoreFollower(Integer storeFollower) {
        this.storeFollower = storeFollower;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeFollower != null ? storeFollower.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreFollwer)) {
            return false;
        }
        StoreFollwer other = (StoreFollwer) object;
        if ((this.storeFollower == null && other.storeFollower != null) || (this.storeFollower != null && !this.storeFollower.equals(other.storeFollower))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.StoreFollwer[ storeFollower=" + storeFollower + " ]";
    }
    
}
