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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "StoreProductImage", catalog = "SNEF_Part2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreProductImage.findAll", query = "SELECT s FROM StoreProductImage s")
    , @NamedQuery(name = "StoreProductImage.findByFSPId", query = "SELECT s FROM StoreProductImage s WHERE s.fSPId = :fSPId")
    , @NamedQuery(name = "StoreProductImage.findByImageSrc", query = "SELECT s FROM StoreProductImage s WHERE s.imageSrc = :imageSrc")})
public class StoreProductImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FSPId")
    private Integer fSPId;
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

    public StoreProductImage(Integer fSPId) {
        this.fSPId = fSPId;
    }

    public StoreProductImage(Integer fSPId, String imageSrc) {
        this.fSPId = fSPId;
        this.imageSrc = imageSrc;
    }

    public Integer getFSPId() {
        return fSPId;
    }

    public void setFSPId(Integer fSPId) {
        this.fSPId = fSPId;
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
        hash += (fSPId != null ? fSPId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreProductImage)) {
            return false;
        }
        StoreProductImage other = (StoreProductImage) object;
        if ((this.fSPId == null && other.fSPId != null) || (this.fSPId != null && !this.fSPId.equals(other.fSPId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.StoreProductImage[ fSPId=" + fSPId + " ]";
    }
    
}
