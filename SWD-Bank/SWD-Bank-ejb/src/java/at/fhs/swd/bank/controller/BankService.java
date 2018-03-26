/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhs.swd.bank.controller;

import at.fhs.swd.bank.model.Bank;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kial
 */
@Stateless
@LocalBean
public class BankService {

    @PersistenceContext
    private EntityManager em;

    public Bank addBank(String bic, String name) {
        Bank b = new Bank();
        b.setBic(bic);
        b.setName(name);
        em.persist(b);
        return b;
    }

    public List<Bank> getAllBank() {
        return em.createNamedQuery("Bank.findAll", Bank.class).getResultList();
    }

    public Bank findBank(String bic) {
        try {
            return em.createNamedQuery("Bank.findByBic", Bank.class)
                    .setParameter("bic", bic)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
