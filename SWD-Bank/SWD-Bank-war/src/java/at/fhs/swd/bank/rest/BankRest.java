/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhs.swd.bank.rest;

import at.fhs.swd.bank.controller.BankService;
import at.fhs.swd.bank.model.Bank;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kial
 */
@RequestScoped
@Named
@Path("bank")
public class BankRest {

    @EJB
    private BankService bankService;

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Bank> findAll() {
        return bankService.getAllBank();
    }

    @GET
    @Path("/{bic}")
    @Produces({MediaType.APPLICATION_JSON})
    public Bank findBank(@PathParam("bic") String bic) {
        return bankService.findBank(bic);
    }

    @POST
    @Path("/")
    @Consumes("application/x-www-form-urlencoded")
    public void addBank(@FormParam("bic") String bic, @FormParam("name") String name) {
        bankService.addBank(bic, name);
    }
}
