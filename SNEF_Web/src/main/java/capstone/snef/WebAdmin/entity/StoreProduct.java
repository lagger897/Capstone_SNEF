/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.snef.WebAdmin.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "StoreProduct", catalog = "SNEF_Part2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreProduct.findAll", query = "SELECT s FROM StoreProduct s")
    , @NamedQuery(name = "StoreProduct.findByStoreProductId", query = "SELECT s FROM StoreProduct s WHERE s.storeProductId = :storeProductId")
    , @NamedQuery(name = "StoreProduct.findByProductName", query = "SELECT s FROM StoreProduct s WHERE s.productName = :productName")
    , @NamedQuery(name = "StoreProduct.findByExpiredDate", query = "SELECT s FROM StoreProduct s WHERE s.expiredDate = :expiredDate")
    , @NamedQuery(name = "StoreProduct.findByQuantity", query = "SELECT s FROM StoreProduct s WHERE s.quantity = :quantity")
    , @NamedQuery(name = "StoreProduct.findByPrice", query = "SELECT s FROM StoreProduct s WHERE s.price = :price")
    , @NamedQuery(name = "StoreProduct.findByDescription", query = "SELECT s FROM StoreProduct s WHERE s.description = :description")
    , @NamedQuery(name = "StoreProduct.findBySku", query = "SELECT s FROM StoreProduct s WHERE s.sku = :sku")})
public class StoreProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StoreProductId")
    private Integer storeProductId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ProductName")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExpiredDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private Double price;
    @Size(max = 4000)
    @Column(name = "Description")
    private String description;
    @Size(max = 50)
    @Column(name = "SKU")
    private String sku;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeProductId")
    private List<FlashSaleProduct> flashSaleProductList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeProductId")
    private List<StoreProductImage> storeProductImageList;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "StoreId", referencedColumnName = "StoreId")
    @ManyToOne(optional = false)
    private Store storeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeProductId")
    private List<LikeItem> likeItemList;

    public StoreProduct() {
    }

    public StoreProduct(Integer storeProductId) {
        this.storeProductId = storeProductId;
    }

    public StoreProduct(Integer storeProductId, String productName, Date expiredDate, int quantity) {
        this.storeProductId = storeProductId;
        this.productName = productName;
        this.expiredDate = expiredDate;
        this.quantity = quantity;
    }

    public Integer getStoreProductId() {
        return storeProductId;
    }

    public void setStoreProductId(Integer storeProductId) {
        this.storeProductId = storeProductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @XmlTransient
    public List<FlashSaleProduct> getFlashSaleProductList() {
        return flashSaleProductList;
    }

    public void setFlashSaleProductList(List<FlashSaleProduct> flashSaleProductList) {
        this.flashSaleProductList = flashSaleProductList;
    }

    @XmlTransient
    public List<StoreProductImage> getStoreProductImageList() {
        return storeProductImageList;
    }

    public void setStoreProductImageList(List<StoreProductImage> storeProductImageList) {
        this.storeProductImageList = storeProductImageList;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    @XmlTransient
    public List<LikeItem> getLikeItemList() {
        return likeItemList;
    }

    public void setLikeItemList(List<LikeItem> likeItemList) {
        this.likeItemList = likeItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeProductId != null ? storeProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreProduct)) {
            return false;
        }
        StoreProduct other = (StoreProduct) object;
        if ((this.storeProductId == null && other.storeProductId != null) || (this.storeProductId != null && !this.storeProductId.equals(other.storeProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.StoreProduct[ storeProductId=" + storeProductId + " ]";
    }
    
}
