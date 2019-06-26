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
@Table(name = "OrderDetail", catalog = "SNEF_Part2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o")
    , @NamedQuery(name = "OrderDetail.findByOrderDetailId", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailId = :orderDetailId")
    , @NamedQuery(name = "OrderDetail.findByQuantity", query = "SELECT o FROM OrderDetail o WHERE o.quantity = :quantity")
    , @NamedQuery(name = "OrderDetail.findByOrderDetailPrice", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailPrice = :orderDetailPrice")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderDetailId")
    private Integer orderDetailId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderDetailPrice")
    private double orderDetailPrice;
    @JoinColumn(name = "FlashSaleProductId", referencedColumnName = "FlashSaleProductId")
    @ManyToOne(optional = false)
    private FlashSaleProduct flashSaleProductId;
    @JoinColumn(name = "OrderOrderId", referencedColumnName = "OrderId")
    @ManyToOne(optional = false)
    private CustomerOrder orderOrderId;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public OrderDetail(Integer orderDetailId, int quantity, double orderDetailPrice) {
        this.orderDetailId = orderDetailId;
        this.quantity = quantity;
        this.orderDetailPrice = orderDetailPrice;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOrderDetailPrice() {
        return orderDetailPrice;
    }

    public void setOrderDetailPrice(double orderDetailPrice) {
        this.orderDetailPrice = orderDetailPrice;
    }

    public FlashSaleProduct getFlashSaleProductId() {
        return flashSaleProductId;
    }

    public void setFlashSaleProductId(FlashSaleProduct flashSaleProductId) {
        this.flashSaleProductId = flashSaleProductId;
    }

    public CustomerOrder getOrderOrderId() {
        return orderOrderId;
    }

    public void setOrderOrderId(CustomerOrder orderOrderId) {
        this.orderOrderId = orderOrderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailId != null ? orderDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.orderDetailId == null && other.orderDetailId != null) || (this.orderDetailId != null && !this.orderDetailId.equals(other.orderDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.OrderDetail[ orderDetailId=" + orderDetailId + " ]";
    }
    
}
