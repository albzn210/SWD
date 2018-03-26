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
@Table(name = "SHARE_TRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShareTransaction.findAll", query = "SELECT s FROM ShareTransaction s")
    , @NamedQuery(name = "ShareTransaction.findById", query = "SELECT s FROM ShareTransaction s WHERE s.id = :id")
    , @NamedQuery(name = "ShareTransaction.findByTime", query = "SELECT s FROM ShareTransaction s WHERE s.time = :time")
    , @NamedQuery(name = "ShareTransaction.findByTransactionType", query = "SELECT s FROM ShareTransaction s WHERE s.transactionType = :transactionType")
    , @NamedQuery(name = "ShareTransaction.findByTransactionLine1", query = "SELECT s FROM ShareTransaction s WHERE s.transactionLine1 = :transactionLine1")
    , @NamedQuery(name = "ShareTransaction.findByTransactionLine2", query = "SELECT s FROM ShareTransaction s WHERE s.transactionLine2 = :transactionLine2")
    , @NamedQuery(name = "ShareTransaction.findByTransactionDate", query = "SELECT s FROM ShareTransaction s WHERE s.transactionDate = :transactionDate")
    , @NamedQuery(name = "ShareTransaction.findByAmount", query = "SELECT s FROM ShareTransaction s WHERE s.amount = :amount")
    , @NamedQuery(name = "ShareTransaction.findByPrice", query = "SELECT s FROM ShareTransaction s WHERE s.price = :price")
    , @NamedQuery(name = "ShareTransaction.findByQuantity", query = "SELECT s FROM ShareTransaction s WHERE s.quantity = :quantity")})
public class ShareTransaction implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "CHECKING_TRANSACTION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CheckingTransaction checkingTransaction;
    @JoinColumn(name = "SHARE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Share share;

    public ShareTransaction() {
    }

    public ShareTransaction(Integer id) {
        this.id = id;
    }

    public ShareTransaction(Integer id, Date time, int transactionType, String transactionLine1, Date transactionDate, double amount, double price) {
        this.id = id;
        this.time = time;
        this.transactionType = transactionType;
        this.transactionLine1 = transactionLine1;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CheckingTransaction getCheckingTransaction() {
        return checkingTransaction;
    }

    public void setCheckingTransaction(CheckingTransaction checkingTransaction) {
        this.checkingTransaction = checkingTransaction;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
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
        if (!(object instanceof ShareTransaction)) {
            return false;
        }
        ShareTransaction other = (ShareTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.fhs.swd.bank.model.ShareTransaction[ id=" + id + " ]";
    }
    
}
