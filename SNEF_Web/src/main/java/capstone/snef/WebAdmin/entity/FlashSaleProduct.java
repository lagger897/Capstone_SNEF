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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "FlashSaleProduct", catalog = "SNEF_Part2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlashSaleProduct.findAll", query = "SELECT f FROM FlashSaleProduct f")
    , @NamedQuery(name = "FlashSaleProduct.findByFlashSaleProductId", query = "SELECT f FROM FlashSaleProduct f WHERE f.flashSaleProductId = :flashSaleProductId")
    , @NamedQuery(name = "FlashSaleProduct.findByQuantity", query = "SELECT f FROM FlashSaleProduct f WHERE f.quantity = :quantity")})
public class FlashSaleProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FlashSaleProductId")
    private Integer flashSaleProductId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "FlashSalesId", referencedColumnName = "FlashSalesId")
    @ManyToOne(optional = false)
    private FlashSales flashSalesId;
    @JoinColumn(name = "StoreProductId", referencedColumnName = "StoreProductId")
    @ManyToOne(optional = false)
    private StoreProduct storeProductId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flashSaleProductId")
    private List<OrderDetail> orderDetailList;

    public FlashSaleProduct() {
    }

    public FlashSaleProduct(Integer flashSaleProductId) {
        this.flashSaleProductId = flashSaleProductId;
    }

    public FlashSaleProduct(Integer flashSaleProductId, int quantity) {
        this.flashSaleProductId = flashSaleProductId;
        this.quantity = quantity;
    }

    public Integer getFlashSaleProductId() {
        return flashSaleProductId;
    }

    public void setFlashSaleProductId(Integer flashSaleProductId) {
        this.flashSaleProductId = flashSaleProductId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public FlashSales getFlashSalesId() {
        return flashSalesId;
    }

    public void setFlashSalesId(FlashSales flashSalesId) {
        this.flashSalesId = flashSalesId;
    }

    public StoreProduct getStoreProductId() {
        return storeProductId;
    }

    public void setStoreProductId(StoreProduct storeProductId) {
        this.storeProductId = storeProductId;
    }

    @XmlTransient
    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flashSaleProductId != null ? flashSaleProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FlashSaleProduct)) {
            return false;
        }
        FlashSaleProduct other = (FlashSaleProduct) object;
        if ((this.flashSaleProductId == null && other.flashSaleProductId != null) || (this.flashSaleProductId != null && !this.flashSaleProductId.equals(other.flashSaleProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.FlashSaleProduct[ flashSaleProductId=" + flashSaleProductId + " ]";
    }
    
}
