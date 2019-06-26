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
@Table(name = "Order", catalog = "SNEF_Part2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerOrder.findAll", query = "SELECT c FROM CustomerOrder c")
    , @NamedQuery(name = "CustomerOrder.findByOrderId", query = "SELECT c FROM CustomerOrder c WHERE c.orderId = :orderId")
    , @NamedQuery(name = "CustomerOrder.findByDateOrder", query = "SELECT c FROM CustomerOrder c WHERE c.dateOrder = :dateOrder")
    , @NamedQuery(name = "CustomerOrder.findByTotalPrice", query = "SELECT c FROM CustomerOrder c WHERE c.totalPrice = :totalPrice")
    , @NamedQuery(name = "CustomerOrder.findByConfirmationCode", query = "SELECT c FROM CustomerOrder c WHERE c.confirmationCode = :confirmationCode")
    , @NamedQuery(name = "CustomerOrder.findByOrderQuantity", query = "SELECT c FROM CustomerOrder c WHERE c.orderQuantity = :orderQuantity")
    , @NamedQuery(name = "CustomerOrder.findByStatus", query = "SELECT c FROM CustomerOrder c WHERE c.status = :status")
    , @NamedQuery(name = "CustomerOrder.findByRatingPoint", query = "SELECT c FROM CustomerOrder c WHERE c.ratingPoint = :ratingPoint")})
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderId")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateOrder")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalPrice")
    private double totalPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ConfirmationCode")
    private String confirmationCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderQuantity")
    private int orderQuantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private boolean status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RatingPoint")
    private Double ratingPoint;
    @JoinColumn(name = "CustomerCustomerId", referencedColumnName = "CustomerId")
    @ManyToOne(optional = false)
    private Customer customerCustomerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderOrderId")
    private List<OrderDetail> orderDetailList;

    public CustomerOrder() {
    }

    public CustomerOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public CustomerOrder(Integer orderId, Date dateOrder, double totalPrice, String confirmationCode, int orderQuantity, boolean status) {
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
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

    public Double getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(Double ratingPoint) {
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
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.CustomerOrder[ orderId=" + orderId + " ]";
    }
    
}
