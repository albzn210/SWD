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
@Table(name = "SAVINGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Savings.findAll", query = "SELECT s FROM Savings s")
    , @NamedQuery(name = "Savings.findById", query = "SELECT s FROM Savings s WHERE s.id = :id")
    , @NamedQuery(name = "Savings.findByIban", query = "SELECT s FROM Savings s WHERE s.iban = :iban")
    , @NamedQuery(name = "Savings.findByAccountName", query = "SELECT s FROM Savings s WHERE s.accountName = :accountName")
    , @NamedQuery(name = "Savings.findByCreditInterest", query = "SELECT s FROM Savings s WHERE s.creditInterest = :creditInterest")
    , @NamedQuery(name = "Savings.findByBalance", query = "SELECT s FROM Savings s WHERE s.balance = :balance")
    , @NamedQuery(name = "Savings.findByBalanceDate", query = "SELECT s FROM Savings s WHERE s.balanceDate = :balanceDate")})
public class Savings implements Serializable {

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
    @Column(name = "BALANCE")
    private double balance;
    @Column(name = "BALANCE_DATE")
    @Temporal(TemporalType.DATE)
    private Date balanceDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "savings")
    private Collection<SavingsTransaction> savingsTransactionCollection;
    @JoinColumn(name = "CHECKING_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Checking checking;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Customer customer;

    public Savings() {
    }

    public Savings(Integer id) {
        this.id = id;
    }

    public Savings(Integer id, String iban, double creditInterest, double balance) {
        this.id = id;
        this.iban = iban;
        this.creditInterest = creditInterest;
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
    public Collection<SavingsTransaction> getSavingsTransactionCollection() {
        return savingsTransactionCollection;
    }

    public void setSavingsTransactionCollection(Collection<SavingsTransaction> savingsTransactionCollection) {
        this.savingsTransactionCollection = savingsTransactionCollection;
    }

    public Checking getChecking() {
        return checking;
    }

    public void setChecking(Checking checking) {
        this.checking = checking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (!(object instanceof Savings)) {
            return false;
        }
        Savings other = (Savings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.fhs.swd.bank.model.Savings[ id=" + id + " ]";
    }
    
}
