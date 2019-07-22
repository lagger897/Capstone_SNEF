/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "StoreManager", catalog = "snef_part2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreManager.findAll", query = "SELECT s FROM StoreManager s")
    , @NamedQuery(name = "StoreManager.findByStoreManagerId", query = "SELECT s FROM StoreManager s WHERE s.storeManagerId = :storeManagerId")})
public class StoreManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StoreManagerId")
    private Integer storeManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeManagerId")
    private List<Store> storeList;
    @JoinColumn(name = "AccountId", referencedColumnName = "AccountId")
    @ManyToOne(optional = false)
    private Account accountId;

    public StoreManager() {
    }

    public StoreManager(Integer storeManagerId) {
        this.storeManagerId = storeManagerId;
    }

    public Integer getStoreManagerId() {
        return storeManagerId;
    }

    public void setStoreManagerId(Integer storeManagerId) {
        this.storeManagerId = storeManagerId;
    }

    @XmlTransient
    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeManagerId != null ? storeManagerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreManager)) {
            return false;
        }
        StoreManager other = (StoreManager) object;
        if ((this.storeManagerId == null && other.storeManagerId != null) || (this.storeManagerId != null && !this.storeManagerId.equals(other.storeManagerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.StoreManager[ storeManagerId=" + storeManagerId + " ]";
    }
    
}
