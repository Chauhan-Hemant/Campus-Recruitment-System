/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desktop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
@Table(name = "JOBS", catalog = "", schema = "MYUSER1")
@NamedQueries({
    @NamedQuery(name = "Jobs.findAll", query = "SELECT j FROM Jobs j")
    , @NamedQuery(name = "Jobs.findByCompanyName", query = "SELECT j FROM Jobs j WHERE j.companyName = :companyName")
    , @NamedQuery(name = "Jobs.findByJobName", query = "SELECT j FROM Jobs j WHERE j.jobName = :jobName")
    , @NamedQuery(name = "Jobs.findByJobDescription", query = "SELECT j FROM Jobs j WHERE j.jobDescription = :jobDescription")
    , @NamedQuery(name = "Jobs.findByJobRequirement", query = "SELECT j FROM Jobs j WHERE j.jobRequirement = :jobRequirement")
    , @NamedQuery(name = "Jobs.findByKeyResponse", query = "SELECT j FROM Jobs j WHERE j.keyResponse = :keyResponse")
    , @NamedQuery(name = "Jobs.findByJobCriteria", query = "SELECT j FROM Jobs j WHERE j.jobCriteria = :jobCriteria")
    , @NamedQuery(name = "Jobs.findByJobSalary", query = "SELECT j FROM Jobs j WHERE j.jobSalary = :jobSalary")})
public class Jobs implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "JOB_NAME")
    private String jobName;
    @Basic(optional = false)
    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;
    @Basic(optional = false)
    @Column(name = "JOB_REQUIREMENT")
    private String jobRequirement;
    @Basic(optional = false)
    @Column(name = "KEY_RESPONSE")
    private String keyResponse;
    @Basic(optional = false)
    @Column(name = "JOB_CRITERIA")
    private String jobCriteria;
    @Basic(optional = false)
    @Column(name = "JOB_SALARY")
    private String jobSalary;

    public Jobs() {
    }

    public Jobs(String companyName) {
        this.companyName = companyName;
    }

    public Jobs(String companyName, String jobName, String jobDescription, String jobRequirement, String keyResponse, String jobCriteria, String jobSalary) {
        this.companyName = companyName;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.jobRequirement = jobRequirement;
        this.keyResponse = keyResponse;
        this.jobCriteria = jobCriteria;
        this.jobSalary = jobSalary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        String oldCompanyName = this.companyName;
        this.companyName = companyName;
        changeSupport.firePropertyChange("companyName", oldCompanyName, companyName);
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        String oldJobName = this.jobName;
        this.jobName = jobName;
        changeSupport.firePropertyChange("jobName", oldJobName, jobName);
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        String oldJobDescription = this.jobDescription;
        this.jobDescription = jobDescription;
        changeSupport.firePropertyChange("jobDescription", oldJobDescription, jobDescription);
    }

    public String getJobRequirement() {
        return jobRequirement;
    }

    public void setJobRequirement(String jobRequirement) {
        String oldJobRequirement = this.jobRequirement;
        this.jobRequirement = jobRequirement;
        changeSupport.firePropertyChange("jobRequirement", oldJobRequirement, jobRequirement);
    }

    public String getKeyResponse() {
        return keyResponse;
    }

    public void setKeyResponse(String keyResponse) {
        String oldKeyResponse = this.keyResponse;
        this.keyResponse = keyResponse;
        changeSupport.firePropertyChange("keyResponse", oldKeyResponse, keyResponse);
    }

    public String getJobCriteria() {
        return jobCriteria;
    }

    public void setJobCriteria(String jobCriteria) {
        String oldJobCriteria = this.jobCriteria;
        this.jobCriteria = jobCriteria;
        changeSupport.firePropertyChange("jobCriteria", oldJobCriteria, jobCriteria);
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        String oldJobSalary = this.jobSalary;
        this.jobSalary = jobSalary;
        changeSupport.firePropertyChange("jobSalary", oldJobSalary, jobSalary);
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
        if (!(object instanceof Jobs)) {
            return false;
        }
        Jobs other = (Jobs) object;
        if ((this.companyName == null && other.companyName != null) || (this.companyName != null && !this.companyName.equals(other.companyName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Desktop.Jobs[ companyName=" + companyName + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
