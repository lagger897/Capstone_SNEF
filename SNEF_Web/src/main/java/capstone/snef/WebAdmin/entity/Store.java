/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "Store", catalog = "snef_part2", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"accountId"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
    , @NamedQuery(name = "Store.findByStoreId", query = "SELECT s FROM Store s WHERE s.storeId = :storeId")
    , @NamedQuery(name = "Store.findByStoreName", query = "SELECT s FROM Store s WHERE s.storeName = :storeName")
    , @NamedQuery(name = "Store.findByAddress", query = "SELECT s FROM Store s WHERE s.address = :address")
    , @NamedQuery(name = "Store.findByRatingPoint", query = "SELECT s FROM Store s WHERE s.ratingPoint = :ratingPoint")
    , @NamedQuery(name = "Store.findByAvatar", query = "SELECT s FROM Store s WHERE s.avatar = :avatar")
    , @NamedQuery(name = "Store.findByOpenHour", query = "SELECT s FROM Store s WHERE s.openHour = :openHour")
    , @NamedQuery(name = "Store.findByCloseHour", query = "SELECT s FROM Store s WHERE s.closeHour = :closeHour")
    , @NamedQuery(name = "Store.findByLongitude", query = "SELECT s FROM Store s WHERE s.longitude = :longitude")
    , @NamedQuery(name = "Store.findByLatitude", query = "SELECT s FROM Store s WHERE s.latitude = :latitude")
    , @NamedQuery(name = "Store.findByStatus", query = "SELECT s FROM Store s WHERE s.status = :status")
    , @NamedQuery(name = "Store.findByPhone", query = "SELECT s FROM Store s WHERE s.phone = :phone")})
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
    @Size(max = 500)
    @Column(name = "Address", length = 500)
    private String address;
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
    @Column(name = "Longitude", precision = 22, scale = 0)
    private Double longitude;
    @Column(name = "Latitude", precision = 22, scale = 0)
    private Double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status", nullable = false)
    private short status;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "Phone", length = 20)
    private String phone;
    @OneToMany(mappedBy = "storeid")
    private List<Order1> order1List;
    @JoinColumn(name = "accountId", referencedColumnName = "AccountId")
    @OneToOne
    private Account accountId;

    public Store() {
    }

    public Store(Integer storeId) {
        this.storeId = storeId;
    }

    public Store(Integer storeId, String storeName, String openHour, String closeHour, short status) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.status = status;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public List<Order1> getOrder1List() {
        return order1List;
    }

    public void setOrder1List(List<Order1> order1List) {
        this.order1List = order1List;
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
