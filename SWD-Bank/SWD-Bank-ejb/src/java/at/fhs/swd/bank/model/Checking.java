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
@Table(name = "CHECKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checking.findAll", query = "SELECT c FROM Checking c")
    , @NamedQuery(name = "Checking.findById", query = "SELECT c FROM Checking c WHERE c.id = :id")
    , @NamedQuery(name = "Checking.findByIban", query = "SELECT c FROM Checking c WHERE c.iban = :iban")
    , @NamedQuery(name = "Checking.findByAccountName", query = "SELECT c FROM Checking c WHERE c.accountName = :accountName")
    , @NamedQuery(name = "Checking.findByCreditInterest", query = "SELECT c FROM Checking c WHERE c.creditInterest = :creditInterest")
    , @NamedQuery(name = "Checking.findByDebitInterest", query = "SELECT c FROM Checking c WHERE c.debitInterest = :debitInterest")
    , @NamedQuery(name = "Checking.findByBalance", query = "SELECT c FROM Checking c WHERE c.balance = :balance")
    , @NamedQuery(name = "Checking.findByBalanceDate", query = "SELECT c FROM Checking c WHERE c.balanceDate = :balanceDate")})
public class Checking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IBAN")
    private String iban;
    @Size(max = 100)
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDIT_INTEREST")
    private double creditInterest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEBIT_INTEREST")
    private double debitInterest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BALANCE")
    private double balance;
    @Column(name = "BALANCE_DATE")
    @Temporal(TemporalType.DATE)
    private Date balanceDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checking")
    private Collection<Custody> custodyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checking")
    private Collection<Savings> savingsCollection;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checking")
    private Collection<CheckingTransaction> checkingTransactionCollection;

    public Checking() {
    }

    public Checking(Integer id) {
        this.id = id;
    }

    public Checking(Integer id, String iban, double creditInterest, double debitInterest, double balance) {
        this.id = id;
        this.iban = iban;
        this.creditInterest = creditInterest;
        this.debitInterest = debitInterest;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getCreditInterest() {
        return creditInterest;
    }

    public void setCreditInterest(double creditInterest) {
        this.creditInterest = creditInterest;
    }

    public double getDebitInterest() {
        return debitInterest;
    }

    public void setDebitInterest(double debitInterest) {
        this.debitInterest = debitInterest;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    @XmlTransient
    public Collection<Custody> getCustodyCollection() {
        return custodyCollection;
    }

    public void setCustodyCollection(Collection<Custody> custodyCollection) {
        this.custodyCollection = custodyCollection;
    }

    @XmlTransient
    public Collection<Savings> getSavingsCollection() {
        return savingsCollection;
    }

    public void setSavingsCollection(Collection<Savings> savingsCollection) {
        this.savingsCollection = savingsCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @XmlTransient
    public Collection<CheckingTransaction> getCheckingTransactionCollection() {
        return checkingTransactionCollection;
    }

    public void setCheckingTransactionCollection(Collection<CheckingTransaction> checkingTransactionCollection) {
        this.checkingTransactionCollection = checkingTransactionCollection;
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
        if (!(object instanceof Checking)) {
            return false;
        }
        Checking other = (Checking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.fhs.swd.bank.model.Checking[ id=" + id + " ]";
    }
    
}
