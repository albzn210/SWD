/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhs.swd.bank.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kial
 */
@Entity
@Table(name = "CHECKING_TRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CheckingTransaction.findAll", query = "SELECT c FROM CheckingTransaction c")
    , @NamedQuery(name = "CheckingTransaction.findById", query = "SELECT c FROM CheckingTransaction c WHERE c.id = :id")
    , @NamedQuery(name = "CheckingTransaction.findByTime", query = "SELECT c FROM CheckingTransaction c WHERE c.time = :time")
    , @NamedQuery(name = "CheckingTransaction.findByTransactionType", query = "SELECT c FROM CheckingTransaction c WHERE c.transactionType = :transactionType")
    , @NamedQuery(name = "CheckingTransaction.findByTransactionLine1", query = "SELECT c FROM CheckingTransaction c WHERE c.transactionLine1 = :transactionLine1")
    , @NamedQuery(name = "CheckingTransaction.findByTransactionLine2", query = "SELECT c FROM CheckingTransaction c WHERE c.transactionLine2 = :transactionLine2")
    , @NamedQuery(name = "CheckingTransaction.findByTransactionDate", query = "SELECT c FROM CheckingTransaction c WHERE c.transactionDate = :transactionDate")
    , @NamedQuery(name = "CheckingTransaction.findByAmount", query = "SELECT c FROM CheckingTransaction c WHERE c.amount = :amount")
    , @NamedQuery(name = "CheckingTransaction.findByRefBankNo", query = "SELECT c FROM CheckingTransaction c WHERE c.refBankNo = :refBankNo")
    , @NamedQuery(name = "CheckingTransaction.findByRefAccountNo", query = "SELECT c FROM CheckingTransaction c WHERE c.refAccountNo = :refAccountNo")})
public class CheckingTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_TYPE")
    private int transactionType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TRANSACTION_LINE_1")
    private String transactionLine1;
    @Size(max = 100)
    @Column(name = "TRANSACTION_LINE_2")
    private String transactionLine2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private double amount;
    @Size(max = 5)
    @Column(name = "REF_BANK_NO")
    private String refBankNo;
    @Size(max = 20)
    @Column(name = "REF_ACCOUNT_NO")
    private String refAccountNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkingTransaction")
    private Collection<SavingsTransaction> savingsTransactionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkingTransaction")
    private Collection<ShareTransaction> shareTransactionCollection;
    @JoinColumn(name = "CHECKING_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Checking checking;

    public CheckingTransaction() {
    }

    public CheckingTransaction(Integer id) {
        this.id = id;
    }

    public CheckingTransaction(Integer id, Date time, int transactionType, String transactionLine1, Date transactionDate, double amount) {
        this.id = id;
        this.time = time;
        this.transactionType = transactionType;
        this.transactionLine1 = transactionLine1;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionLine1() {
        return transactionLine1;
    }

    public void setTransactionLine1(String transactionLine1) {
        this.transactionLine1 = transactionLine1;
    }

    public String getTransactionLine2() {
        return transactionLine2;
    }

    public void setTransactionLine2(String transactionLine2) {
        this.transactionLine2 = transactionLine2;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRefBankNo() {
        return refBankNo;
    }

    public void setRefBankNo(String refBankNo) {
        this.refBankNo = refBankNo;
    }

    public String getRefAccountNo() {
        return refAccountNo;
    }

    public void setRefAccountNo(String refAccountNo) {
        this.refAccountNo = refAccountNo;
    }

    @XmlTransient
    public Collection<SavingsTransaction> getSavingsTransactionCollection() {
        return savingsTransactionCollection;
    }

    public void setSavingsTransactionCollection(Collection<SavingsTransaction> savingsTransactionCollection) {
        this.savingsTransactionCollection = savingsTransactionCollection;
    }

    @XmlTransient
    public Collection<ShareTransaction> getShareTransactionCollection() {
        return shareTransactionCollection;
    }

    public void setShareTransactionCollection(Collection<ShareTransaction> shareTransactionCollection) {
        this.shareTransactionCollection = shareTransactionCollection;
    }

    public Checking getChecking() {
        return checking;
    }

    public void setChecking(Checking checking) {
        this.checking = checking;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CheckingTransaction)) {
            return false;
        }
        CheckingTransaction other = (CheckingTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.fhs.swd.bank.model.CheckingTransaction[ id=" + id + " ]";
    }
    
}
