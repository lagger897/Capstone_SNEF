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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "OrderDetail", catalog = "snef_part2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o")
    , @NamedQuery(name = "OrderDetail.findByOrderDetailId", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailId = :orderDetailId")
    , @NamedQuery(name = "OrderDetail.findByQuantity", query = "SELECT o FROM OrderDetail o WHERE o.quantity = :quantity")
    , @NamedQuery(name = "OrderDetail.findByOrderDetailPrice", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailPrice = :orderDetailPrice")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrderDetailId", nullable = false)
    private Integer orderDetailId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderDetailPrice", nullable = false)
    private float orderDetailPrice;
    @JoinColumn(name = "FlashSaleProductId", referencedColumnName = "FlashSaleProductId", nullable = false)
    @ManyToOne(optional = false)
    private FlashsaleProduct flashSaleProductId;
    @JoinColumn(name = "OrderOrderId", referencedColumnName = "OrderId", nullable = false)
    @ManyToOne(optional = false)
    private Order1 orderOrderId;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public OrderDetail(Integer orderDetailId, int quantity, float orderDetailPrice) {
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

    public float getOrderDetailPrice() {
        return orderDetailPrice;
    }

    public void setOrderDetailPrice(float orderDetailPrice) {
        this.orderDetailPrice = orderDetailPrice;
    }

    public FlashsaleProduct getFlashSaleProductId() {
        return flashSaleProductId;
    }

    public void setFlashSaleProductId(FlashsaleProduct flashSaleProductId) {
        this.flashSaleProductId = flashSaleProductId;
    }

    public Order1 getOrderOrderId() {
        return orderOrderId;
    }

    public void setOrderOrderId(Order1 orderOrderId) {
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
