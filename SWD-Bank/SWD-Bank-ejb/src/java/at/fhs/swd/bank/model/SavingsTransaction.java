/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhs.swd.bank.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kial
 */
@Entity
@Table(name = "SAVINGS_TRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SavingsTransaction.findAll", query = "SELECT s FROM SavingsTransaction s")
    , @NamedQuery(name = "SavingsTransaction.findById", query = "SELECT s FROM SavingsTransaction s WHERE s.id = :id")
    , @NamedQuery(name = "SavingsTransaction.findByTime", query = "SELECT s FROM SavingsTransaction s WHERE s.time = :time")
    , @NamedQuery(name = "SavingsTransaction.findByTransactionType", query = "SELECT s FROM SavingsTransaction s WHERE s.transactionType = :transactionType")
    , @NamedQuery(name = "SavingsTransaction.findByTransactionLine1", query = "SELECT s FROM SavingsTransaction s WHERE s.transactionLine1 = :transactionLine1")
    , @NamedQuery(name = "SavingsTransaction.findByTransactionLine2", query = "SELECT s FROM SavingsTransaction s WHERE s.transactionLine2 = :transactionLine2")
    , @NamedQuery(name = "SavingsTransaction.findByTransactionDate", query = "SELECT s FROM SavingsTransaction s WHERE s.transactionDate = :transactionDate")
    , @NamedQuery(name = "SavingsTransaction.findByAmount", query = "SELECT s FROM SavingsTransaction s WHERE s.amount = :amount")})
public class SavingsTransaction implements Serializable {

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
    @JoinColumn(name = "CHECKING_TRANSACTION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CheckingTransaction checkingTransaction;
    @JoinColumn(name = "SAVINGS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Savings savings;

    public SavingsTransaction() {
    }

    public SavingsTransaction(Integer id) {
        this.id = id;
    }

    public SavingsTransaction(Integer id, Date time, int transactionType, String transactionLine1, Date transactionDate, double amount) {
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

    public CheckingTransaction getCheckingTransaction() {
        return checkingTransaction;
    }

    public void setCheckingTransaction(CheckingTransaction checkingTransaction) {
        this.checkingTransaction = checkingTransaction;
    }

    public Savings getSavings() {
        return savings;
    }

    public void setSavings(Savings savings) {
        this.savings = savings;
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
        if (!(object instanceof SavingsTransaction)) {
            return false;
        }
        SavingsTransaction other = (SavingsTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.fhs.swd.bank.model.SavingsTransaction[ id=" + id + " ]";
    }
    
}
