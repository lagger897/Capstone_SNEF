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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Order", catalog = "snef_part2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o")
    , @NamedQuery(name = "Order1.findByOrderId", query = "SELECT o FROM Order1 o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "Order1.findByDateOrder", query = "SELECT o FROM Order1 o WHERE o.dateOrder = :dateOrder")
    , @NamedQuery(name = "Order1.findByTotalPrice", query = "SELECT o FROM Order1 o WHERE o.totalPrice = :totalPrice")
    , @NamedQuery(name = "Order1.findByConfirmationCode", query = "SELECT o FROM Order1 o WHERE o.confirmationCode = :confirmationCode")
    , @NamedQuery(name = "Order1.findByOrderQuantity", query = "SELECT o FROM Order1 o WHERE o.orderQuantity = :orderQuantity")
    , @NamedQuery(name = "Order1.findByStatus", query = "SELECT o FROM Order1 o WHERE o.status = :status")
    , @NamedQuery(name = "Order1.findByRatingPoint", query = "SELECT o FROM Order1 o WHERE o.ratingPoint = :ratingPoint")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrderId", nullable = false)
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateOrder", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalPrice", nullable = false)
    private float totalPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ConfirmationCode", nullable = false, length = 50)
    private String confirmationCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderQuantity", nullable = false)
    private int orderQuantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status", nullable = false)
    private boolean status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RatingPoint", precision = 12, scale = 0)
    private Float ratingPoint;
    @JoinColumn(name = "CustomerCustomerId", referencedColumnName = "CustomerId", nullable = false)
    @ManyToOne(optional = false)
    private Customer customerCustomerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderOrderId")
    private List<OrderDetail> orderDetailList;

    public Order1() {
    }

    public Order1(Integer orderId) {
        this.orderId = orderId;
    }

    public Order1(Integer orderId, Date dateOrder, float totalPrice, String confirmationCode, int orderQuantity, boolean status) {
        this.orderId = orderId;
        this.dateOrder = dateOrder;
        this.totalPrice = totalPrice;
        this.confirmationCode = confirmationCode;
        this.orderQuantity = orderQuantity;
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Float getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(Float ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    public Customer getCustomerCustomerId() {
        return customerCustomerId;
    }

    public void setCustomerCustomerId(Customer customerCustomerId) {
        this.customerCustomerId = customerCustomerId;
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
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.Order1[ orderId=" + orderId + " ]";
    }
    
}
