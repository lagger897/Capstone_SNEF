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
@Table(name = "Store", catalog = "SNEF_Part2", schema = "dbo")
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "StoreId")
    private Integer storeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "StoreName")
    private String storeName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RatingPoint")
    private Double ratingPoint;
    @Size(max = 400)
    @Column(name = "Avatar")
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "OpenHour")
    private String openHour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CloseHour")
    private String closeHour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
    private List<StoreProduct> storeProductList;
    @JoinColumn(name = "LocationId", referencedColumnName = "LocationId")
    @ManyToOne(optional = false)
    private Location locationId;
    @JoinColumn(name = "StoreManagerId", referencedColumnName = "StoreManagerId")
    @ManyToOne(optional = false)
    private StoreManager storeManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
    private List<FlashSales> flashSalesList;
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

    public Double getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(Double ratingPoint) {
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
    public List<FlashSales> getFlashSalesList() {
        return flashSalesList;
    }

    public void setFlashSalesList(List<FlashSales> flashSalesList) {
        this.flashSalesList = flashSalesList;
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
