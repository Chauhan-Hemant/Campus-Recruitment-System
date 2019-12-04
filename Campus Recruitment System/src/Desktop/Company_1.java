/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desktop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Hemant
 */
@Entity
@Table(name = "COMPANY", catalog = "", schema = "MYUSER1")
@NamedQueries({
    @NamedQuery(name = "Company_1.findAll", query = "SELECT c FROM Company_1 c")
    , @NamedQuery(name = "Company_1.findByCompanyName", query = "SELECT c FROM Company_1 c WHERE c.companyName = :companyName")
    , @NamedQuery(name = "Company_1.findByCompanyAddress", query = "SELECT c FROM Company_1 c WHERE c.companyAddress = :companyAddress")
    , @NamedQuery(name = "Company_1.findByCity", query = "SELECT c FROM Company_1 c WHERE c.city = :city")
    , @NamedQuery(name = "Company_1.findByContactNumber", query = "SELECT c FROM Company_1 c WHERE c.contactNumber = :contactNumber")
    , @NamedQuery(name = "Company_1.findByPassword", query = "SELECT c FROM Company_1 c WHERE c.password = :password")})
public class Company_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "COMPANY_ADDRESS")
    private String companyAddress;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "CONTACT_NUMBER")
    private BigInteger contactNumber;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;

    public Company_1() {
    }

    public Company_1(String companyName) {
        this.companyName = companyName;
    }

    public Company_1(String companyName, String companyAddress, String city, BigInteger contactNumber, String password) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.city = city;
        this.contactNumber = contactNumber;
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        String oldCompanyName = this.companyName;
        this.companyName = companyName;
        changeSupport.firePropertyChange("companyName", oldCompanyName, companyName);
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        String oldCompanyAddress = this.companyAddress;
        this.companyAddress = companyAddress;
        changeSupport.firePropertyChange("companyAddress", oldCompanyAddress, companyAddress);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        changeSupport.firePropertyChange("city", oldCity, city);
    }

    public BigInteger getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(BigInteger contactNumber) {
        BigInteger oldContactNumber = this.contactNumber;
        this.contactNumber = contactNumber;
        changeSupport.firePropertyChange("contactNumber", oldContactNumber, contactNumber);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyName != null ? companyName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company_1)) {
            return false;
        }
        Company_1 other = (Company_1) object;
        if ((this.companyName == null && other.companyName != null) || (this.companyName != null && !this.companyName.equals(other.companyName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Desktop.Company_1[ companyName=" + companyName + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
