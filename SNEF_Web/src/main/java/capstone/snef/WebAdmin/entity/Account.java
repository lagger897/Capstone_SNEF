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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phuc Nguyen -VN
 */
@Entity
@Table(name = "Account", catalog = "snef_part2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByAccountId", query = "SELECT a FROM Account a WHERE a.accountId = :accountId")
    , @NamedQuery(name = "Account.findByUserName", query = "SELECT a FROM Account a WHERE a.userName = :userName")
    , @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password")
    , @NamedQuery(name = "Account.findByFirstName", query = "SELECT a FROM Account a WHERE a.firstName = :firstName")
    , @NamedQuery(name = "Account.findByLastName", query = "SELECT a FROM Account a WHERE a.lastName = :lastName")
    , @NamedQuery(name = "Account.findByPhone", query = "SELECT a FROM Account a WHERE a.phone = :phone")
    , @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email")
    , @NamedQuery(name = "Account.findByIsActive", query = "SELECT a FROM Account a WHERE a.isActive = :isActive")
    , @NamedQuery(name = "Account.findByAvatar", query = "SELECT a FROM Account a WHERE a.avatar = :avatar")
    , @NamedQuery(name = "Account.findByGender", query = "SELECT a FROM Account a WHERE a.gender = :gender")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AccountId", nullable = false)
    private Integer accountId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "UserName", nullable = false, length = 30)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Password", nullable = false, length = 30)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FirstName", nullable = false, length = 20)
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LastName", nullable = false, length = 20)
    private String lastName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "Phone", length = 20)
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email", length = 50)
    private String email;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Size(max = 400)
    @Column(name = "Avatar", length = 400)
    private String avatar;
    @Column(name = "Gender")
    private Short gender;
    @OneToMany(mappedBy = "accountId")
    private List<Order1> order1List;
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    @ManyToOne
    private Role roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
    private List<NewProductRequest> newProductRequestList;
    @OneToOne(mappedBy = "accountId")
    private Store store;
    @OneToMany(mappedBy = "accountId")
    private List<Like1> like1List;

    public Account() {
    }

    public Account(Integer accountId) {
        this.accountId = accountId;
    }

    public Account(Integer accountId, String userName, String password, String firstName, String lastName) {
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    @XmlTransient
    public List<Order1> getOrder1List() {
        return order1List;
    }

    public void setOrder1List(List<Order1> order1List) {
        this.order1List = order1List;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @XmlTransient
    public List<NewProductRequest> getNewProductRequestList() {
        return newProductRequestList;
    }

    public void setNewProductRequestList(List<NewProductRequest> newProductRequestList) {
        this.newProductRequestList = newProductRequestList;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @XmlTransient
    public List<Like1> getLike1List() {
        return like1List;
    }

    public void setLike1List(List<Like1> like1List) {
        this.like1List = like1List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.snef.WebAdmin.entity.Account[ accountId=" + accountId + " ]";
    }
    
}
