package at.fhs.swd.bank.controller;

import at.fhs.swd.bank.model.Bank;
import at.fhs.swd.bank.model.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class CustomerService {

    @PersistenceContext
    private EntityManager em;

    @EJB
    private BankService bankBean;

    public Customer addCustomer(String bic, String name, String customerNo) {
        Bank b = bankBean.findBank(bic);
        Customer c = new Customer();
        c.setBank(b);
        c.setName(name);
        c.setCustomerNo(customerNo);
        em.persist(c);

        return c;
    }

    public List<Customer> findCustomers(String bic) {
        Bank b = bankBean.findBank(bic);
        return em.createNamedQuery("Customer.findByBank", Customer.class)
                .setParameter("bank", b)
                .getResultList();
    }
}
