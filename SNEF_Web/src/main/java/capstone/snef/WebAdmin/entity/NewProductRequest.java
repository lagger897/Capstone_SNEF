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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "NewProductRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewProductRequest.findAll", query = "SELECT n FROM NewProductRequest n")
    , @NamedQuery(name = "NewProductRequest.findByNPRId", query = "SELECT n FROM NewProductRequest n WHERE n.nPRId = :nPRId")
    , @NamedQuery(name = "NewProductRequest.findByStatus", query = "SELECT n FROM NewProductRequest n WHERE n.status = :status")
    , @NamedQuery(name = "NewProductRequest.findByMessage", query = "SELECT n FROM NewProductRequest n WHERE n.message = :message")})
public class NewProductRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NPRId")
    private Integer nPRId;
    @Column(name = "Status")
    private Boolean status;
    @Size(max = 500)
    @Column(name = "Message")
    private String message;
    @JoinColumn(name = "AdminId", referencedColumnName = "AccountId")
    @ManyToOne
    private Account adminId;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "StoreId", referencedColumnName = "StoreId")
    @ManyToOne(optional = false)
    private Store storeId;

    public NewProductRequest() {
    }

    public NewProductRequest(Integer nPRId) {
        this.nPRId = nPRId;
    }
    public NewProductRequest(Product productID, Account adminID, Store storeID, boolean status) {
        this.productId = productID;
        this.adminId = adminID;
        this.storeId = storeID;
        this.status = status;
    }

    public Integer getNPRId() {
        return nPRId;
    }

    public void setNPRId(Integer nPRId) {
        this.nPRId = nPRId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Account getAdminId() {
        return adminId;
    }

    public void setAdminId(Account adminId) {
        this.adminId = adminId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPRId != null ? nPRId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewProductRequest)) {
            return false;
        }
        NewProductRequest other = (NewProductRequest) object;
        if ((this.nPRId == null && other.nPRId != null) || (this.nPRId != null && !this.nPRId.equals(other.nPRId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.NewProductRequest[ nPRId=" + nPRId + " ]";
    }
    
}
