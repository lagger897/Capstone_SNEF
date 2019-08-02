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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "StoreProductImage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreProductImage.findAll", query = "SELECT s FROM StoreProductImage s")
    , @NamedQuery(name = "StoreProductImage.findBySPIId", query = "SELECT s FROM StoreProductImage s WHERE s.sPIId = :sPIId")
    , @NamedQuery(name = "StoreProductImage.findByImageSrc", query = "SELECT s FROM StoreProductImage s WHERE s.imageSrc = :imageSrc")})
public class StoreProductImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SPIId")
    private Integer sPIId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "ImageSrc")
    private String imageSrc;
    @JoinColumn(name = "StoreProductId", referencedColumnName = "StoreProductId")
    @ManyToOne(optional = false)
    private StoreProduct storeProductId;

    public StoreProductImage() {
    }

    public StoreProductImage(Integer sPIId) {
        this.sPIId = sPIId;
    }

    public StoreProductImage(Integer sPIId, String imageSrc) {
        this.sPIId = sPIId;
        this.imageSrc = imageSrc;
    }
    
    public StoreProductImage(String imageSrc, StoreProduct product) {
        this.imageSrc = imageSrc;
        this.storeProductId = product;
    }

    public Integer getSPIId() {
        return sPIId;
    }

    public void setSPIId(Integer sPIId) {
        this.sPIId = sPIId;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public StoreProduct getStoreProductId() {
        return storeProductId;
    }

    public void setStoreProductId(StoreProduct storeProductId) {
        this.storeProductId = storeProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sPIId != null ? sPIId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreProductImage)) {
            return false;
        }
        StoreProductImage other = (StoreProductImage) object;
        if ((this.sPIId == null && other.sPIId != null) || (this.sPIId != null && !this.sPIId.equals(other.sPIId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.StoreProductImage[ sPIId=" + sPIId + " ]";
    }
    
}
