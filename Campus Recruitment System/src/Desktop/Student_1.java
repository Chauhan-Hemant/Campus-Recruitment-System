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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Hemant
 */
@Entity
@Table(name = "STUDENT", catalog = "", schema = "MYUSER1")
@NamedQueries({
    @NamedQuery(name = "Student_1.findAll", query = "SELECT s FROM Student_1 s")
    , @NamedQuery(name = "Student_1.findByStudentId", query = "SELECT s FROM Student_1 s WHERE s.studentId = :studentId")
    , @NamedQuery(name = "Student_1.findByStudentName", query = "SELECT s FROM Student_1 s WHERE s.studentName = :studentName")
    , @NamedQuery(name = "Student_1.findByContactNumber", query = "SELECT s FROM Student_1 s WHERE s.contactNumber = :contactNumber")
    , @NamedQuery(name = "Student_1.findByEmailId", query = "SELECT s FROM Student_1 s WHERE s.emailId = :emailId")
    , @NamedQuery(name = "Student_1.findByGender", query = "SELECT s FROM Student_1 s WHERE s.gender = :gender")
    , @NamedQuery(name = "Student_1.findByDateOfBirth", query = "SELECT s FROM Student_1 s WHERE s.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Student_1.findByTenthPercentage", query = "SELECT s FROM Student_1 s WHERE s.tenthPercentage = :tenthPercentage")
    , @NamedQuery(name = "Student_1.findByTenthBoard", query = "SELECT s FROM Student_1 s WHERE s.tenthBoard = :tenthBoard")
    , @NamedQuery(name = "Student_1.findByTenthPassingYear", query = "SELECT s FROM Student_1 s WHERE s.tenthPassingYear = :tenthPassingYear")
    , @NamedQuery(name = "Student_1.findByTwelvePercentage", query = "SELECT s FROM Student_1 s WHERE s.twelvePercentage = :twelvePercentage")
    , @NamedQuery(name = "Student_1.findByTwelveBoard", query = "SELECT s FROM Student_1 s WHERE s.twelveBoard = :twelveBoard")
    , @NamedQuery(name = "Student_1.findByTwelvePassingYear", query = "SELECT s FROM Student_1 s WHERE s.twelvePassingYear = :twelvePassingYear")
    , @NamedQuery(name = "Student_1.findByCourse", query = "SELECT s FROM Student_1 s WHERE s.course = :course")
    , @NamedQuery(name = "Student_1.findByAggregate", query = "SELECT s FROM Student_1 s WHERE s.aggregate = :aggregate")
    , @NamedQuery(name = "Student_1.findByUniversity", query = "SELECT s FROM Student_1 s WHERE s.university = :university")
    , @NamedQuery(name = "Student_1.findByPassword", query = "SELECT s FROM Student_1 s WHERE s.password = :password")})
public class Student_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STUDENT_ID")
    private String studentId;
    @Basic(optional = false)
    @Column(name = "STUDENT_NAME")
    private String studentName;
    @Basic(optional = false)
    @Column(name = "CONTACT_NUMBER")
    private BigInteger contactNumber;
    @Basic(optional = false)
    @Column(name = "EMAIL_ID")
    private String emailId;
    @Basic(optional = false)
    @Column(name = "GENDER")
    private String gender;
    @Basic(optional = false)
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "TENTH_PERCENTAGE")
    private BigInteger tenthPercentage;
    @Basic(optional = false)
    @Column(name = "TENTH_BOARD")
    private String tenthBoard;
    @Basic(optional = false)
    @Column(name = "TENTH_PASSING_YEAR")
    private BigInteger tenthPassingYear;
    @Basic(optional = false)
    @Column(name = "TWELVE_PERCENTAGE")
    private BigInteger twelvePercentage;
    @Basic(optional = false)
    @Column(name = "TWELVE_BOARD")
    private String twelveBoard;
    @Basic(optional = false)
    @Column(name = "TWELVE_PASSING_YEAR")
    private BigInteger twelvePassingYear;
    @Basic(optional = false)
    @Column(name = "COURSE")
    private String course;
    @Basic(optional = false)
    @Column(name = "AGGREGATE")
    private BigInteger aggregate;
    @Basic(optional = false)
    @Column(name = "UNIVERSITY")
    private String university;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;

    public Student_1() {
    }

    public Student_1(String studentId) {
        this.studentId = studentId;
    }

    public Student_1(String studentId, String studentName, BigInteger contactNumber, String emailId, String gender, Date dateOfBirth, BigInteger tenthPercentage, String tenthBoard, BigInteger tenthPassingYear, BigInteger twelvePercentage, String twelveBoard, BigInteger twelvePassingYear, String course, BigInteger aggregate, String university, String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.tenthPercentage = tenthPercentage;
        this.tenthBoard = tenthBoard;
        this.tenthPassingYear = tenthPassingYear;
        this.twelvePercentage = twelvePercentage;
        this.twelveBoard = twelveBoard;
        this.twelvePassingYear = twelvePassingYear;
        this.course = course;
        this.aggregate = aggregate;
        this.university = university;
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        String oldStudentId = this.studentId;
        this.studentId = studentId;
        changeSupport.firePropertyChange("studentId", oldStudentId, studentId);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        String oldStudentName = this.studentName;
        this.studentName = studentName;
        changeSupport.firePropertyChange("studentName", oldStudentName, studentName);
    }

    public BigInteger getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(BigInteger contactNumber) {
        BigInteger oldContactNumber = this.contactNumber;
        this.contactNumber = contactNumber;
        changeSupport.firePropertyChange("contactNumber", oldContactNumber, contactNumber);
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        String oldEmailId = this.emailId;
        this.emailId = emailId;
        changeSupport.firePropertyChange("emailId", oldEmailId, emailId);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        Date oldDateOfBirth = this.dateOfBirth;
        this.dateOfBirth = dateOfBirth;
        changeSupport.firePropertyChange("dateOfBirth", oldDateOfBirth, dateOfBirth);
    }

    public BigInteger getTenthPercentage() {
        return tenthPercentage;
    }

    public void setTenthPercentage(BigInteger tenthPercentage) {
        BigInteger oldTenthPercentage = this.tenthPercentage;
        this.tenthPercentage = tenthPercentage;
        changeSupport.firePropertyChange("tenthPercentage", oldTenthPercentage, tenthPercentage);
    }

    public String getTenthBoard() {
        return tenthBoard;
    }

    public void setTenthBoard(String tenthBoard) {
        String oldTenthBoard = this.tenthBoard;
        this.tenthBoard = tenthBoard;
        changeSupport.firePropertyChange("tenthBoard", oldTenthBoard, tenthBoard);
    }

    public BigInteger getTenthPassingYear() {
        return tenthPassingYear;
    }

    public void setTenthPassingYear(BigInteger tenthPassingYear) {
        BigInteger oldTenthPassingYear = this.tenthPassingYear;
        this.tenthPassingYear = tenthPassingYear;
        changeSupport.firePropertyChange("tenthPassingYear", oldTenthPassingYear, tenthPassingYear);
    }

    public BigInteger getTwelvePercentage() {
        return twelvePercentage;
    }

    public void setTwelvePercentage(BigInteger twelvePercentage) {
        BigInteger oldTwelvePercentage = this.twelvePercentage;
        this.twelvePercentage = twelvePercentage;
        changeSupport.firePropertyChange("twelvePercentage", oldTwelvePercentage, twelvePercentage);
    }

    public String getTwelveBoard() {
        return twelveBoard;
    }

    public void setTwelveBoard(String twelveBoard) {
        String oldTwelveBoard = this.twelveBoard;
        this.twelveBoard = twelveBoard;
        changeSupport.firePropertyChange("twelveBoard", oldTwelveBoard, twelveBoard);
    }

    public BigInteger getTwelvePassingYear() {
        return twelvePassingYear;
    }

    public void setTwelvePassingYear(BigInteger twelvePassingYear) {
        BigInteger oldTwelvePassingYear = this.twelvePassingYear;
        this.twelvePassingYear = twelvePassingYear;
        changeSupport.firePropertyChange("twelvePassingYear", oldTwelvePassingYear, twelvePassingYear);
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        String oldCourse = this.course;
        this.course = course;
        changeSupport.firePropertyChange("course", oldCourse, course);
    }

    public BigInteger getAggregate() {
        return aggregate;
    }

    public void setAggregate(BigInteger aggregate) {
        BigInteger oldAggregate = this.aggregate;
        this.aggregate = aggregate;
        changeSupport.firePropertyChange("aggregate", oldAggregate, aggregate);
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        String oldUniversity = this.university;
        this.university = university;
        changeSupport.firePropertyChange("university", oldUniversity, university);
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
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student_1)) {
            return false;
        }
        Student_1 other = (Student_1) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Desktop.Student_1[ studentId=" + studentId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
