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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "FlashsaleProduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlashsaleProduct.findAll", query = "SELECT f FROM FlashsaleProduct f")
    , @NamedQuery(name = "FlashsaleProduct.findByFlashSaleProductId", query = "SELECT f FROM FlashsaleProduct f WHERE f.flashSaleProductId = :flashSaleProductId")
    , @NamedQuery(name = "FlashsaleProduct.findByQuantity", query = "SELECT f FROM FlashsaleProduct f WHERE f.quantity = :quantity")
    , @NamedQuery(name = "FlashsaleProduct.findByStatus", query = "SELECT f FROM FlashsaleProduct f WHERE f.status = :status")})
public class FlashsaleProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FlashSaleProductId")
    private Integer flashSaleProductId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "FlashSalesId", referencedColumnName = "FlashSalesId")
    @ManyToOne(optional = false)
    private Flashsales flashSalesId;
    @JoinColumn(name = "StoreProductId", referencedColumnName = "StoreProductId")
    @ManyToOne(optional = false)
    private StoreProduct storeProductId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flashSaleProductId")
    private List<OrderDetail> orderDetailList;

    public FlashsaleProduct() {
    }

    public FlashsaleProduct(Integer flashSaleProductId) {
        this.flashSaleProductId = flashSaleProductId;
    }

    public FlashsaleProduct(Integer flashSaleProductId, int quantity) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Flashsales getFlashSalesId() {
        return flashSalesId;
    }

    public void setFlashSalesId(Flashsales flashSalesId) {
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
        if (!(object instanceof FlashsaleProduct)) {
            return false;
        }
        FlashsaleProduct other = (FlashsaleProduct) object;
        if ((this.flashSaleProductId == null && other.flashSaleProductId != null) || (this.flashSaleProductId != null && !this.flashSaleProductId.equals(other.flashSaleProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.FlashsaleProduct[ flashSaleProductId=" + flashSaleProductId + " ]";
    }
    
}
