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
@Table(name = "Configuration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuration.findAll", query = "SELECT c FROM Configuration c")
    , @NamedQuery(name = "Configuration.findByConfigurationId", query = "SELECT c FROM Configuration c WHERE c.configurationId = :configurationId")
    , @NamedQuery(name = "Configuration.findByConfigurationName", query = "SELECT c FROM Configuration c WHERE c.configurationName = :configurationName")
    , @NamedQuery(name = "Configuration.findByConfigurationValue", query = "SELECT c FROM Configuration c WHERE c.configurationValue = :configurationValue")})
public class Configuration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "configurationId")
    private Integer configurationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "configurationName")
    private String configurationName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "configurationValue")
    private String configurationValue;

    public Configuration() {
    }

    public Configuration(Integer configurationId) {
        this.configurationId = configurationId;
    }

    public Configuration(Integer configurationId, String configurationName, String configurationValue) {
        this.configurationId = configurationId;
        this.configurationName = configurationName;
        this.configurationValue = configurationValue;
    }

    public Integer getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(Integer configurationId) {
        this.configurationId = configurationId;
    }

    public String getConfigurationName() {
        return configurationName;
    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    public String getConfigurationValue() {
        return configurationValue;
    }

    public void setConfigurationValue(String configurationValue) {
        this.configurationValue = configurationValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configurationId != null ? configurationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuration)) {
            return false;
        }
        Configuration other = (Configuration) object;
        if ((this.configurationId == null && other.configurationId != null) || (this.configurationId != null && !this.configurationId.equals(other.configurationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.Configuration[ configurationId=" + configurationId + " ]";
    }
    
}
