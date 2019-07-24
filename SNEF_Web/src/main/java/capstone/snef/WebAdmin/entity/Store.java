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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "Store", catalog = "snef_part2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
    , @NamedQuery(name = "Store.findByStoreId", query = "SELECT s FROM Store s WHERE s.storeId = :storeId")
    , @NamedQuery(name = "Store.findByStoreName", query = "SELECT s FROM Store s WHERE s.storeName = :storeName")
    , @NamedQuery(name = "Store.findByRatingPoint", query = "SELECT s FROM Store s WHERE s.ratingPoint = :ratingPoint")
    , @NamedQuery(name = "Store.findByAvatar", query = "SELECT s FROM Store s WHERE s.avatar = :avatar")
    , @NamedQuery(name = "Store.findByOpenHour", query = "SELECT s FROM Store s WHERE s.openHour = :openHour")
    , @NamedQuery(name = "Store.findByCloseHour", query = "SELECT s FROM Store s WHERE s.closeHour = :closeHour")})
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StoreId", nullable = false)
    private Integer storeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "StoreName", nullable = false, length = 50)
    private String storeName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RatingPoint", precision = 12, scale = 0)
    private Float ratingPoint;
    @Size(max = 400)
    @Column(name = "Avatar", length = 400)
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "OpenHour", nullable = false, length = 5)
    private String openHour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CloseHour", nullable = false, length = 5)
    private String closeHour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
    private List<StoreProduct> storeProductList;
    @JoinColumn(name = "LocationId", referencedColumnName = "LocationId", nullable = false)
    @ManyToOne(optional = false)
    private Location locationId;
    @JoinColumn(name = "StoreManagerId", referencedColumnName = "StoreManagerId", nullable = false)
    @ManyToOne(optional = false)
    private StoreManager storeManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
    private List<Flashsales> flashsalesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
    private List<StoreFollwer> storeFollwerList;

    public Store() {
    }

    public Store(Integer storeId) {
        this.storeId = storeId;
    }

    public Store(Integer storeId, String storeName, String openHour, String closeHour) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Float getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(Float ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    @XmlTransient
    public List<StoreProduct> getStoreProductList() {
        return storeProductList;
    }

    public void setStoreProductList(List<StoreProduct> storeProductList) {
        this.storeProductList = storeProductList;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public StoreManager getStoreManagerId() {
        return storeManagerId;
    }

    public void setStoreManagerId(StoreManager storeManagerId) {
        this.storeManagerId = storeManagerId;
    }

    @XmlTransient
    public List<Flashsales> getFlashsalesList() {
        return flashsalesList;
    }

    public void setFlashsalesList(List<Flashsales> flashsalesList) {
        this.flashsalesList = flashsalesList;
    }

    @XmlTransient
    public List<StoreFollwer> getStoreFollwerList() {
        return storeFollwerList;
    }

    public void setStoreFollwerList(List<StoreFollwer> storeFollwerList) {
        this.storeFollwerList = storeFollwerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeId != null ? storeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Store)) {
            return false;
        }
        Store other = (Store) object;
        if ((this.storeId == null && other.storeId != null) || (this.storeId != null && !this.storeId.equals(other.storeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.Store[ storeId=" + storeId + " ]";
    }
    
}
