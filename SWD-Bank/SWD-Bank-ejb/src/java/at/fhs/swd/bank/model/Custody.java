/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhs.swd.bank.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kial
 */
@Entity
@Table(name = "CUSTODY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Custody.findAll", query = "SELECT c FROM Custody c")
    , @NamedQuery(name = "Custody.findById", query = "SELECT c FROM Custody c WHERE c.id = :id")
    , @NamedQuery(name = "Custody.findByIban", query = "SELECT c FROM Custody c WHERE c.iban = :iban")
    , @NamedQuery(name = "Custody.findByAccountName", query = "SELECT c FROM Custody c WHERE c.accountName = :accountName")})
public class Custody implements Serializable {

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
    @JoinColumn(name = "CHECKING_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Checking checking;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custody")
    private Collection<Share> shareCollection;

    public Custody() {
    }

    public Custody(Integer id) {
        this.id = id;
    }

    public Custody(Integer id, String iban) {
        this.id = id;
        this.iban = iban;
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

    @XmlTransient
    public Collection<Share> getShareCollection() {
        return shareCollection;
    }

    public void setShareCollection(Collection<Share> shareCollection) {
        this.shareCollection = shareCollection;
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
        if (!(object instanceof Custody)) {
            return false;
        }
        Custody other = (Custody) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.fhs.swd.bank.model.Custody[ id=" + id + " ]";
    }
    
}
