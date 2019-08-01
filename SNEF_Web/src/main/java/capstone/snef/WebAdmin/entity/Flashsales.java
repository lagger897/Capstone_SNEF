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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "Flashsales", catalog = "snef_part2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flashsales.findAll", query = "SELECT f FROM Flashsales f")
    , @NamedQuery(name = "Flashsales.findByFlashSalesId", query = "SELECT f FROM Flashsales f WHERE f.flashSalesId = :flashSalesId")
    , @NamedQuery(name = "Flashsales.findByDiscount", query = "SELECT f FROM Flashsales f WHERE f.discount = :discount")
    , @NamedQuery(name = "Flashsales.findByStartDate", query = "SELECT f FROM Flashsales f WHERE f.startDate = :startDate")
    , @NamedQuery(name = "Flashsales.findByEndDate", query = "SELECT f FROM Flashsales f WHERE f.endDate = :endDate")})
public class Flashsales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FlashSalesId", nullable = false)
    private Integer flashSalesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Discount", nullable = false)
    private int discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StartDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EndDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flashSalesId")
    private List<FlashsaleProduct> flashsaleProductList;
    @JoinColumn(name = "StoreId", referencedColumnName = "StoreId", nullable = false)
    @ManyToOne(optional = false)
    private Store storeId;

    public Flashsales() {
    }

    public Flashsales(Integer flashSalesId) {
        this.flashSalesId = flashSalesId;
    }

    public Flashsales(Integer flashSalesId, int discount, Date startDate, Date endDate) {
        this.flashSalesId = flashSalesId;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Flashsales(int discount, Date startDate, Date endDate, Store storeId) {
        this.storeId = storeId;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getFlashSalesId() {
        return flashSalesId;
    }

    public void setFlashSalesId(Integer flashSalesId) {
        this.flashSalesId = flashSalesId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlTransient
    public List<FlashsaleProduct> getFlashsaleProductList() {
        return flashsaleProductList;
    }

    public void setFlashsaleProductList(List<FlashsaleProduct> flashsaleProductList) {
        this.flashsaleProductList = flashsaleProductList;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flashSalesId != null ? flashSalesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flashsales)) {
            return false;
        }
        Flashsales other = (Flashsales) object;
        if ((this.flashSalesId == null && other.flashSalesId != null) || (this.flashSalesId != null && !this.flashSalesId.equals(other.flashSalesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.Flashsales[ flashSalesId=" + flashSalesId + " ]";
    }

}
